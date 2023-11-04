package com.mybatis.testmybatis.mapper;

import com.mybatis.testmybatis.domain.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {

    //xml 참고하기
    List<Users> findAll();

    //xml 참고 안하기(어노테이션 이용)

    @Insert("insert into users(name, address) values( #{name}, #{address} )")
    void insertUser(Users users);

    @Select("SELECT * FROM users")
    List<Users> findAll2();

    @Select("SELECT * FROM users WHERE id = #{id}")
    Users findById(long id);

    @Update("UPDATE users SET name = #{name}, address = #{address} WHERE id = #{id}")
    void updateUser(Users users);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteUser(long id);


}

