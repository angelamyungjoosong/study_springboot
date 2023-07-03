package com.yojulab.study_springboot.restapis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yojulab.study_springboot.dao.SharedDao;
import com.yojulab.study_springboot.service.CarCompanyService;

@RestController
public class CarCompanyController {
     @Autowired 
     CarCompanyService carcompanyService;

//select all 
      @GetMapping("/carCompany/selectAll/{COMPANY_ID}") // 변수로 온다고 표시
     public ResponseEntity selectAll(@PathVariable String COMPANY_ID) { // 이 파라미터는 url에서 온 파라미터라는 표시를 위해
                                                                            // @pathvariable (url과 mapping되어있다)
        Object result = carcompanyService.selectAll(COMPANY_ID);

        return ResponseEntity.ok().body(result);
     
}
//select detail
@GetMapping("/carCompany/selectDetail/{COMPANY_ID}")
    public ResponseEntity selectDetail(@PathVariable String COMPANY_ID) { // 이 파라미터는 url에서 온 파라미터라는 표시를 위해
                                                                            // @pathvariable (url과 mapping되어있다)
        Object result = carcompanyService.selectDetail(COMPANY_ID);

        return ResponseEntity.ok().body(result);
    
    }
//select search 
  @GetMapping("/carCompany/selectSearch/{search}/{words}") // 변수로 온다고 표시
     public ResponseEntity selectSearch(@PathVariable String search, @PathVariable String words) { // 이 파라미터는 url에서 온 파라미터라는 표시를 위해
                                                                            // @pathvariable (url과 mapping되어있다)
       Object result = carcompanyService.selectSearch(search, words);

        return ResponseEntity.ok().body(result);
     }

//create
    @PostMapping("/carCompany/insert") //이렇게안써도 insert라 인지
    public ResponseEntity insert(@RequestBody Map paramMap)//묶음으로 오니까 map으로 받아 (key,value형식으로)/rest방식은 안보이는 부분도 실어서 보냄. -> uri 노출 안되고 body부분에 실어서 보내줌. @RequestBody 해더 안의 내용 중에 body에서 가져옴(내용은 클라이언트가 준 거 안에 있다 ) 
    {  
        Object result = carcompanyService.insert(paramMap);
       
        return ResponseEntity.ok().body(result);
      
    }
    //update
   @PutMapping("/carCompany/update") 
    public ResponseEntity update(@RequestBody Map paramMap)//묶음으로 오니까 map으로 받아 (key,value형식으로)/rest방식은 안보이는 부분도 실어서 보냄. -> uri 노출 안되고 body부분에 실어서 보내줌. @RequestBody 해더 안의 내용 중에 body에서 가져옴(내용은 클라이언트가 준 거 안에 있다 ) 
    {  
        Object result = carcompanyService.update(paramMap);
       
        return ResponseEntity.ok().body(result);
      
    }  
     //delete
     @DeleteMapping("/carCompany/delete/{COMPANY_ID}") 
    public ResponseEntity delete(@PathVariable String COMPANY_ID) { // 이 파라미터는 url에서 온 파라미터라는 표시를 위해
                                                                            // @pathvariable (url과 mapping되어있다)
        Object result = carcompanyService.delete(COMPANY_ID);

        return ResponseEntity.ok().body(result);
    
    }
    }