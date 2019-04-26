package com.iss.demo;

import com.iss.dao.IBook;
import com.iss.po.Books;
import com.iss.util.DBUtil;
import com.iss.util.ExcelUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Demo {

    @Test
    public void show(){
//        SqlSession sqlSession=DBUtil.getSession();
//        IBook iBook=sqlSession.getMapper(IBook.class);
//        List<Books> list=iBook.getAllBook();
//        System.out.println(list);
//        ExcelUtil.writeExcelFile(list,"D:/day0424AM.xlsx");

        ExcelUtil.readExcelFile("D:/day0424AM.xlsx");

    }
}
