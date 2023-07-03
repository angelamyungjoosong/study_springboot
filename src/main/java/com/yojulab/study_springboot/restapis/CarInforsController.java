package com.yojulab.study_springboot.restapis;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yojulab.study_springboot.service.CarInforsService;

@RestController
public class CarInforsController {
    @Autowired // 인스턴스화해놨으니 가져다 쓰겠다
    CarInforsService carInforsService;

    // /selectSearch/YEAR/2020
    // /selectSearch/CAR_NAME/소
    @GetMapping("/selectSearch/{search}/{words}") // 변수로 온다고 표시
     public ResponseEntity selectSearch(@PathVariable String search, @PathVariable String words) { // 이 파라미터는 url에서 온 파라미터라는 표시를 위해
                                                                            // @pathvariable (url과 mapping되어있다)
        Object result = carInforsService.selectSearch(search, words);

        return ResponseEntity.ok().body(result);
    
    }
    //select  /selectDetail/CI002
    @GetMapping("/selectAll/{CAR_INFOR_ID}") // 변수로 온다고 표시
     public ResponseEntity selectAll(@PathVariable String CAR_INFOR_ID) { // 이 파라미터는 url에서 온 파라미터라는 표시를 위해
                                                                            // @pathvariable (url과 mapping되어있다)
        Object result = carInforsService.selectAll(CAR_INFOR_ID);

        return ResponseEntity.ok().body(result);
    
    }
    @GetMapping("/selectDetail/{CAR_INFOR_ID}")
    public ResponseEntity selectDetail(@PathVariable String CAR_INFOR_ID) { // 이 파라미터는 url에서 온 파라미터라는 표시를 위해
                                                                            // @pathvariable (url과 mapping되어있다)
        Object result = carInforsService.selectDetail(CAR_INFOR_ID);

        return ResponseEntity.ok().body(result);
    
    }
    //create
    @PostMapping("/insert") //이렇게안써도 insert라 인지
    public ResponseEntity insert(@RequestBody Map paramMap)//묶음으로 오니까 map으로 받아 (key,value형식으로)/rest방식은 안보이는 부분도 실어서 보냄. -> uri 노출 안되고 body부분에 실어서 보내줌. @RequestBody 해더 안의 내용 중에 body에서 가져옴(내용은 클라이언트가 준 거 안에 있다 ) 
    {  
        Object result = carInforsService.insert(paramMap);
       
        return ResponseEntity.ok().body(result);
      
    }

    @PutMapping("/update") 
    public ResponseEntity update(@RequestBody Map paramMap)//묶음으로 오니까 map으로 받아 (key,value형식으로)/rest방식은 안보이는 부분도 실어서 보냄. -> uri 노출 안되고 body부분에 실어서 보내줌. @RequestBody 해더 안의 내용 중에 body에서 가져옴(내용은 클라이언트가 준 거 안에 있다 ) 
    {  
        Object result = carInforsService.update(paramMap);
       
        return ResponseEntity.ok().body(result);
      
    }
    //delete
     @DeleteMapping("/delete/{CAR_INFOR_ID}") 
    public ResponseEntity delete(@PathVariable String CAR_INFOR_ID) { // 이 파라미터는 url에서 온 파라미터라는 표시를 위해
                                                                            // @pathvariable (url과 mapping되어있다)
        Object result = carInforsService.delete(CAR_INFOR_ID);

        return ResponseEntity.ok().body(result);
    
    }
  //2PC create
    @PostMapping("/insertDouble") //이렇게안써도 insert라 인지
    public ResponseEntity insertDouble(@RequestBody Map paramMap)//묶음으로 오니까 map으로 받아 (key,value형식으로)/rest방식은 안보이는 부분도 실어서 보냄. -> uri 노출 안되고 body부분에 실어서 보내줌. @RequestBody 해더 안의 내용 중에 body에서 가져옴(내용은 클라이언트가 준 거 안에 있다 ) 
    {   Object result = null;
        try {
            result = carInforsService.insertDouble(paramMap);
        } catch (Exception e) {
             return ResponseEntity.badRequest().body(result); //에러에 대한 메세지 관리. result안나오게. 
        }
       
        return ResponseEntity.ok().body(result);
    }
}
