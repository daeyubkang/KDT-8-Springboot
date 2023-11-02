package com.mybatis.testmybatis.mapper;

import com.mybatis.testmybatis.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {

    //xml 참고하기
    List<Users> findAll();

    //xml 참고 안하기(어노테이션 이용)
    @Insert("insert into users(name, address) values( #{name}, #{address} )")
    void insertUser(Users users);

}

