package org.daoPractice.dao;

import org.daoPractice.dto.Role;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.daoPractice.dao.RoleDaoSqls.*;

@Repository
public class RoleDao {
    //기존에 선언된 클래스
    //Biding 할 때는 ? 로 매핑하면 헷갈리는 문제를 -> 이름을 이용해서 쿼리를 실행함
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
    //INSERT
    private SimpleJdbcInsert insertAction;

    public RoleDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("role");
    }

    public List<Role> selectAll() {
        return jdbc.query(SELECT_ALL, Collections.<String, Object>emptyMap(), rowMapper);
    }

    public Role selectById(int id) {
        //응답 값이 없는 경우 예외 발생
        try{
            Map<String, ?> params = Collections.singletonMap("roleId",id);
            return jdbc.queryForObject(SELECT_BY_ID, params, rowMapper);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public int insert(Role role) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        return insertAction.execute(params);
    }

    public int update(Role role) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        return jdbc.update(UPDATE, params);
    }

    public int deleteById(int id){
        Map<String, ?> params = Collections.singletonMap("roleId", id);
        return jdbc.update(DELETE_BY_ID,params);
    }
}
