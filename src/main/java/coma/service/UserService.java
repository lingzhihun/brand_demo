package coma.service;

import coma.mapper.BrandMapper;
import coma.mapper.UserMapper;
import coma.pojo.Brand;
import coma.pojo.User;
import coma.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User login(String username, String password){

        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectByUser(username,password);

        sqlSession.close();

        return user;
    }


}
