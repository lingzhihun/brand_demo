package coma.mapper;

import coma.pojo.Brand;
import coma.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from tb_user where username = #{username} and password = #{password}")
//    @ResultMap("brandResultMap")
    User select(@Param("username") String username,@Param("password") String password);

    @Select("select * from tb_user where username = #{username}")
    User selectByUsername(@Param("username") String username);

    @Insert("insert into tb_user values(null, #{username}, #{password})")
    void add(User user);

}
