package com.yojulab.study_springboot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yojulab.study_springboot.dao.SharedDao;

//service에서 dao 호출 + 데이터담아 
@Service // springframe이 관리할 수 있게 리스트업 위해서 캡씌워줌. 자원 관리 및 속도 위해서.
@Transactional // 하나의 업무에서 오류났을때 무효화. 데이터 정확성 유지. insert 두개 중복되는 경우 아예 처음부터 들어가지 않게한다. 에러 검출용. 
public class CarInforsService { // 리턴형식 모르면 object 붙이자.
    @Autowired // 자동으로 연결해줘 -- 클래스이름이 겹치면 별칭을 직접 줘야함. @Service(name="")
    SharedDao sharedDao; // getOne이라는 메소드를 호출하려고함(스프링 프레임워크는 이미 클래스 리스트를 가지고 인스턴스화 시켜준 상태이기 때문에 어떤걸 사용할지
                         // 선언만 하면 된다. 여러번 사용할 거니까 공통 사용이라는 di 선언. )
 
   //검색 (검색 조건: YEAR, CAR_NAME)
        public Object selectSearch(String search, String words) {
     
        String sqlMapId = "CarInfors.selectSearch"; 
        HashMap dataMap = new HashMap<>();
        dataMap.put("search", search); //YEAR, CAR_NAME 중에 뭔지 구분자로 
        dataMap.put("words", words);

        Object result = sharedDao.getList(sqlMapId, dataMap);
         return result;
    }
 
        public Object selectAll(String CAR_INFOR_ID) {
        // getOne(String sqlMapId, Object dataMap) - Dao에서 형식 그대로 가져옴.]
        // 인스턴스화된것 가져오기

        //어떤 걸 호출,어떤값을 넘길지 이 두가지 (dao통해서 xml넘길때 )넣는다 
        String sqlMapId = "CarInfors.selectAll"; // namespace.select id
        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

        Object result = sharedDao.getList(sqlMapId, dataMap); // 넘겨주는것두번째꺼는 리스트나 map넣어도됨
        //bypass면 object로 받아됨. 리턴도 이걸로 

        return result;
    }

    public Object selectDetail(String CAR_INFOR_ID) {
        // getOne(String sqlMapId, Object dataMap) - Dao에서 형식 그대로 가져옴.]
        // 인스턴스화된것 가져오기

        //어떤 걸 호출,어떤값을 넘길지 이 두가지 (dao통해서 xml넘길때 )넣는다 
        String sqlMapId = "CarInfors.selectByUID"; // namespace.select id
        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

        Object result = sharedDao.getOne(sqlMapId, dataMap); // 넘겨주는것두번째꺼는 리스트나 map넣어도됨
        //bypass면 object로 받아됨. 리턴도 이걸로 

        return result;
    }

    public Object insert(Map dataMap){ //controller에서 map 받아서 넘어옴 
        String sqlMapId="CarInfors.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result; 
    }

    public Object update(Map dataMap){ //controller에서 map 받아서 넘어옴 
        String sqlMapId="CarInfors.update";
        Object result = sharedDao.update(sqlMapId, dataMap);
        return result; 
    }

      public Object delete(String CAR_INFOR_ID){ 
        String sqlMapId="CarInfors.delete";
         HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

         Object result = sharedDao.delete(sqlMapId, dataMap);

        return result; 
    }

        // 2pc(투페이스커밋) -똑같은값을 인서트하니까 하나성공,하나실패함.-> 뒤에꺼 에러메시지 뜸-> 앞에꺼도 에러 발생해서 인서트 되지말아야한다. 레코드 하나 받고 두번 인서트한다. pk 같으니 에러 뱉어서 인서트되면안됨. 
       public Object insertDouble(Map dataMap){  
        String sqlMapId="CarInfors.insert"; //dao와 xml이 1:1fh 매칭
       //sucess
        Object result = sharedDao.insert(sqlMapId, dataMap);
        //error 
        result = sharedDao.insert(sqlMapId, dataMap);
        return result; 
    }
}
