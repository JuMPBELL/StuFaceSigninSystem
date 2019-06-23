package com.stufacesigninsystem.demo.Mapper;

import com.stufacesigninsystem.demo.Entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    @Select("select count(*) from tbl_stu where Stu_ID=#{stuid} and Password=#{password}")
    int findstu(@Param("stuid") String stuid,@Param("password") String password);
    @Select("select count(*) from tbl_stu where Stu_ID=#{stuid}")
    int findstuid(@Param("stuid") String stuid);
    @Select("select count(*) from tbl_stu where Password=#{password} and Stu_ID=#{stuid}")
    int findpassword(@Param("password") String password,@Param("stuid") String stuid);
    @Select("SELECT * FROM tbl_stu WHERE stu_id = #{stuid}")
    Map findallBystuid(@Param("stuid") String stuid);
    @Update("UPDATE tbl_stu SET Stu_Face=#{stuface} WHERE Stu_ID=#{stuid}")
    Boolean updatestuimg(@Param("stuface") String stuface,@Param("stuid") String stuid);
    @Select("select * from tbl_signinfo where stu_id=#{stuid}")
    List<Map> findsinginfo(@Param("stuid") String stuid);
}
