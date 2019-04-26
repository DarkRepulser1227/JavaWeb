package com.iss.dao;

import com.iss.po.Files;
import org.apache.ibatis.annotations.Insert;

public interface IFile {

    @Insert("insert into files values (#{fid},#{fname},#{fsize},#{ftype},#{fpath},now())")
    public int addFile(Files files);
}
