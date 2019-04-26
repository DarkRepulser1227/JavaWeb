package com.iss.Mapper;

import com.iss.po.Users;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * form users")
    public List<Users> findAllUser();
}
