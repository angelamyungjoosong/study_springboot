package com.yojulab.study_springboot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yojulab.study_springboot.dao.SharedDao;

@Service
@Transactional
public class CarCompanyService {
    @Autowired
    SharedDao sharedDao;

    public Object selectAll(String COMPANY_ID) {
        String sqlMapId = "CarCompany.selectAll";
        HashMap dataMap = new HashMap<>();
        dataMap.put("COMPANY_ID", COMPANY_ID);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object selectDetail(String COMPANY_ID) {
        String sqlMapId = "CarCompany.selectByID";
        HashMap dataMap = new HashMap<>();
        dataMap.put("COMPANY_ID", COMPANY_ID);

        Object result = sharedDao.getOne(sqlMapId, dataMap);

        return result;
    }

    public Object selectSearch(String search, String words) {
        String sqlMapId = "CarCompany.selectSearch"; 
        HashMap dataMap = new HashMap<>();
        dataMap.put("search", search); 
        dataMap.put("words", words);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object insert(Map dataMap){ 
        String sqlMapId="CarCompany.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }
    
     public Object update(Map dataMap){ //controller에서 map 받아서 넘어옴 
        String sqlMapId="CarCompany.update";
        Object result = sharedDao.update(sqlMapId, dataMap);
        return result; 
    }

    public Object delete(String COMPANY_ID){ 
         String sqlMapId="CarCompany.delete";
         HashMap dataMap = new HashMap<>();
         dataMap.put("COMPANY_ID", COMPANY_ID);
         Object result = sharedDao.delete(sqlMapId, dataMap);
        return result; 
    }

}
