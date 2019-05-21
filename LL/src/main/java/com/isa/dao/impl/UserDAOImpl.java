package com.isa.dao.impl;

import com.isa.dao.IUserDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("userDAO")
public class UserDAOImpl implements IUserDAO{
    @Autowired
    SqlSessionFactory sessionFactoryBean;

    @Override
    public String login(String uname, String upwd) {
        try {
            SqlSession sqlSession=sessionFactoryBean.openSession(true);
            String statment="com.isa.mapping.userMapper.login";
            Map map=new HashMap();
            map.put("uname",uname);
            map.put("upwd",upwd);
            System.out.println(map);
            List<Map<String,Object>> list=sqlSession.selectList(statment,map);
            System.out.println(list.size());
            if(list.size()>0)
                return "success";
            else
                return "fault";

        }catch (Exception e){
            e.printStackTrace();
        }
       return  null;
    }

    @Override
    public boolean register(String uname, String upwd, String email) {
        SqlSession sqlSession=sessionFactoryBean.openSession(true);
        String statement="com.isa.mapping.userMapper.register";
        Map map=new HashMap();
        map.put("uname",uname);
        map.put("upwd",upwd);
        map.put("email",email);
        int i=sqlSession.insert(statement);
        if (i>0)
            return true;
        else
            return false;
    }
}
