package coma.mapper;

import coma.pojo.Brand;
import coma.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from tb_user where username = #{username} and password = #{password}")
    @ResultMap("brandResultMap")
    User selectByUser(@Param("username") String username,@Param("password") String password);

}
