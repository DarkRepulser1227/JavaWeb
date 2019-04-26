package com.iss.controller;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet("/downloadServlet")
public class downloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("ID");
            String filename = "JavaMail.jar";
            response.setHeader("Content-disposition", "attachment;filename=" +
                    URLEncoder.encode(filename, "UTF-8"));

            String path=getServletContext().getRealPath("/uploads");

            File file=new File(path+"\\"+id);

            FileInputStream inputStream=new FileInputStream(file);
            response.setHeader("Content_Length",String.valueOf(file.length()));

            OutputStream outputStream=response.getOutputStream();

            byte buffer[]=new byte[1024];

            int len=0;

            while ((len=inputStream.read(buffer))>0){
                outputStream.write(buffer,0,len);
            }

            inputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
