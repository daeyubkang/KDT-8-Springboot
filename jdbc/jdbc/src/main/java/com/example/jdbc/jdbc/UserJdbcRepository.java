package com.example.jdbc.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepository {

    @Autowired
    private JdbcTemplate jdbc;

    private static String INSERT_USER =
            """
                INSERT INTO users (name, address) VALUES (?, ?);
            """;

    private static String DELETE_USER =
            """
                DELETE FROM users WHERE id = ?;
            """;

    private static String SELECT_USER =
            """
                SELECT * FROM users where id =?;
            """;

    public void insert(Users user){
        jdbc.update(INSERT_USER, user.getName(), user.getAddress());
    }

    public void deleteId(long id){
        jdbc.update(DELETE_USER, id);
    }

    public Users findId(long id){
        //Users클래스의 인스턴스로 매핑하기 위해서 new BeanPropertyRowMapper를 사용
        //BeanPropertyRowMapper: 데이터베이스 테이블의 칼럼과 Java Bean의 프로퍼티 이름을 자동으로 매칭
        return jdbc.queryForObject(SELECT_USER, new BeanPropertyRowMapper<>(Users.class), id);
    }

    //JDBC 주요 메소드
    //queryForObject(): 한 행만 반환할 때 사용
    //queryForMap(): 한 행만 반환. 데이터를 Map 형태로 반환
    //queryForInt(): 단일 값 반환. 반환 값으로 int형태 데이터(ex.select count(*) from users)
    //update(): INSERT, UPDATE, DELETE와 같은 sql문 실행
    //query(): 여러행을 반환하는 쿼리 결과 처리할때 사용
    //excute(): 반환값이 없는 sql명령을 실행:


}
