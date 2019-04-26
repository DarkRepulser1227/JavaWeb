package com.iss.controller;

import com.google.gson.Gson;
import com.iss.model.bookModel;
import com.iss.po.Book;
import com.iss.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/bookServlet")
public class bookServlet extends HttpServlet {
    Gson g = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            String method = request.getParameter("M");
            String res = "";
            switch (method) {
                case "del":
                    res = delBook(request.getParameter("ID"));
                    break;
                case "getBook":
                    res=getAllBook();
                    break;
                case "searchBook":
                    res=getBookDetail(request.getParameter("ID"));
                    break;
                case "upBook":
                    res=upBook(request.getParameter("ID"),request.getParameter("N"),request.getParameter("A"),request.getParameter("P"));
                    break;
            }


            out.print(res);
            out.flush();
            out.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private String upBook(String id, String bname, String author, String price) {
        String str="";
        try {
            boolean b=bookModel.upBook(DBUtil.getConnection(),id,bname,author,price);
            str=getBookDetail(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;

    }

    private String getBookDetail(String id) {
        Book book=null;
        try {
            ResultSet rs = bookModel.getBookDetail(DBUtil.getConnection(),id);
            if (rs.next()){
                book = new Book();
                book.setBid(rs.getString(1));
                book.setBname(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setPrice(rs.getFloat(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return g.toJson(book);

    }

    private String getAllBook() {
        List<Book> list = new ArrayList<Book>();
        try {
            ResultSet rs = bookModel.getBooks(DBUtil.getConnection());

            Book b = null;
            while (rs.next()) {
                b = new Book();
                b.setBid(rs.getString(1));
                String bookname = rs.getString(2);

                b.setBname(bookname.length() <= 10 ? bookname : (bookname.substring(0, 10)) + "...");
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getFloat(4));

                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return g.toJson(list);
    }

    private String delBook(String bookid) {
        bookModel.delBook(DBUtil.getConnection(), bookid);
        return getAllBook();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
