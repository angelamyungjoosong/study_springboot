package com.yojulab.study_springboot.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// hashmap 말고 다른 것도 넣어갈 수 있기 때문에 object 사용. 알아서 바꾸어줌.

@Component // 이것이 service, contoller의 상위 기능이다
public class SharedDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    // 여러 개 레코드
    public Object getList(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplate.selectList(sqlMapId, dataMap);
        return result;
    }

    // 레코드 하나
    public Object getOne(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplate.selectOne(sqlMapId, dataMap);
        return result;
    }

    // 수정
    public Object update(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplate.update(sqlMapId, dataMap);
        return result;
    }

    // 만들때
    // datamap에는 key, value 싫어서 네개 보낸다. 
    public Object insert(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplate.insert(sqlMapId, dataMap);
        return result;
    }

    // 없앨때
    public Object delete(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplate.delete(sqlMapId, dataMap);
        return result;
    }
}
