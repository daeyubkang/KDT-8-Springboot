package com.mybatis.testmybatis.service;

import com.mybatis.testmybatis.domain.Users;
import com.mybatis.testmybatis.dto.UsersDTO;
import com.mybatis.testmybatis.mapper.UsersMapper;
import org.apache.el.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersMapper usersMapper;

    public List<UsersDTO> getUsersList() {
        //DTO쓰는 이유는 domain에 직접적으로 접근하지 않기 위해서(캡슐화)

        //실제 데이터베이스에서 가져오는 Users 배열
        List<Users> result = usersMapper.findAll();
        System.out.println(result);
        //위에 받은 Users배열을 UsersDTO 배열로 반환하기
        List<UsersDTO> users = new ArrayList<>();

        for(int i = 0; i < result.size(); i++){
            UsersDTO user = new UsersDTO();

            user.setId(result.get(i).getId());
            user.setName(result.get(i).getName());
            user.setAddress(result.get(i).getAddress());

            users.add(user);
        }
        return users;
    }

    public void addUser(Users user){
        usersMapper.insertUser(user);
    }

    public void findUser(long id){
        usersMapper.findById(id);
    }

    public void deleteUser(long id){
        usersMapper.deleteUser(id);
    }

    public void updateUser(Users user){
        usersMapper.updateUser(user);
    }

}
