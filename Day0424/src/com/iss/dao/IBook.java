package com.iss.dao;

import com.iss.po.Books;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IBook {

    @Select("select * from books")
    public List<Books> getAllBook();
}
