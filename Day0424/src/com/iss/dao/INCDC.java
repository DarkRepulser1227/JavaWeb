package com.iss.dao;

import com.iss.po.Ncdc;
import org.apache.ibatis.annotations.Insert;

public interface INCDC {

    @Insert("insert into ncdc values (#{stn},#{wban},#{yeaRs})")
    public int addInfo(Ncdc ncdc);
}
