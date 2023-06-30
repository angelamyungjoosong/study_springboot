package com.yojulab.study_springboot.restapis;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yojulab.study_springboot.service.HelloWorldService;

@Controller // extends Http와 같은 것
public class HelloWorldController {
      //ioc는 beans 모든 파일을 메모리에 올려. 
    //DI Dependency Injection? 캡 씌운 부분을 메모리에 다 올려. new와 비슷. 처음에 속도는 오래 걸리지만 사용속도는 빨라진다. 
    @Autowired
     HelloWorldService helloWorldService;

   @GetMapping("/helloWorld") //이 메소드는 doGet(doGet 메소드쓸거야라는 선언)과 같이 Get 사용할거야.annotation방법. / 이 URL쓸거야  
    public int helloWorld(){
        return 0;
        }

    // 메소드와 URL이름만 다르면, 한클래스에 get,...등등의 method 여러개 넣을 수 있다. 한 업무에 여러기능.  
    // 서블릿에서는 /helloWorldGetRequest?Name=yojulab&Id=U-01  -html로 보내서 html로 받았지. 브라우저.  그래서 getparameter로 받았어야함. 
    // 이런 형식으로 바뀜 ->  /helloWorldGetRequest/yojulab/U-01  - URL의 위치값에 의해 name인 것을 알 수 있음. 이제는 app이 들어가면서 frontend/backend가 분리되면서 url을그대로 따라가는 형식으로 바뀐다. 이건 웹에서만 사욯하는 방식.해킹하기 어려움 
     
    @GetMapping("/helloWorldGetRequest/{name}/{Id}")
    // parameter로 안바고. 위치값에 의해 mapping해줘서 아이디=U-01 이런식으로 매칭을 해주기 때문에 우리는 가져오기만하면됨.
        public int helloWorldGetRequest(@PathVariable String name, @PathVariable String Id){
         //url에서 넘어온 변수야라고 알려주기 위해 캡씌운다 
            return 0;
         }

    // ?serviceKey=v9nQhJoXl4wY6sr2aLQYKMdNKR0lxjG7kl1dC%2FJrqcuVLuUBk7f3AkJEMJI9yKry0NP%2FlEqJFSJcQ9K8LkOsiA%3D%3D
    // &currentPage=1
    // &perPage=10
    // &SN=1

    ///helloWorldResponse/1/10/1
         @GetMapping("/helloWorldResponse/{currentPage}/{perPage}/{SN}")
         //모든것의 최상위는 오브젝트. 원하는 걸 실어보내면 spring이 알아서 string으로 넣는다. 
            public ResponseEntity<Object>  helloWorldResponse(@PathVariable String currentPage, @PathVariable String perPage, @PathVariable String SN){
               //  "spm_row": 471,"SN": 1, "CMPNM": "로이유통", "RDNMADR": null, "TELNO": null
                HashMap resultMap = new HashMap<>();
                resultMap.put("spm_row", 471);
                resultMap.put("SN", 1); 
                resultMap.put("CMPNM", "로이유통");
                resultMap.put("TELNO", null);

                return ResponseEntity.ok().body(resultMap);
                //json으로 상대에게 결과값을 보내줌
         }

          @GetMapping("/helloWorldResponseList/{currentPage}/{perPage}/{SN}")
         //받는 값을 object로 모든것의 최상위는 오브젝트. 원하는 걸 실어보내면 spring이 알아서 string으로 넣는다. 
            public ResponseEntity<Object>  helloWorldResponseList(@PathVariable String currentPage, @PathVariable String perPage, @PathVariable String SN){
                // "spm_row": 471, "SN": 1, "CMPNM": "로이유통", "RDNMADR": null
                // "spm_row": 571, "SN": 2, "CMPNM": "의료유통", "RDNMADR": 3
                ArrayList arrayList = new ArrayList<> ();
                HashMap resultMap = new HashMap<>();
                resultMap.put("spm_row", 471);
                resultMap.put("SN", 1); 
                resultMap.put("CMPNM","로이유통");
                resultMap.put("RDNMADR", null);
                arrayList.add(resultMap);

                resultMap = new HashMap<>();
                resultMap.put("spm_row", 571);
                resultMap.put("SN", 2); 
                resultMap.put("CMPNM","의료유통");
                resultMap.put("RDNMADR", 3);
                arrayList.add(resultMap);

                return ResponseEntity.ok().body(arrayList);
                //json으로 상대에게 결과값을 보내줌
         }
    

 ///helloWorldResponseWithService/1/10/1
    @GetMapping("/helloWorldResponseWithService/{currentPage}/{perPage}/{SN}")
         //받는 값을 object로 모든것의 최상위는 오브젝트. 원하는 걸 실어보내면 spring이 알아서 string으로 넣는다. 
        
         public ResponseEntity<Object>  helloWorldResponseWithService(@PathVariable String currentPage, @PathVariable String perPage, @PathVariable String SN){
          
                // ioc사용해서 자동으로 인스턴스화 
                ArrayList arrayList = new ArrayList<>();
               arrayList = helloWorldService.fakeSelect(currentPage, perPage);
                return ResponseEntity.ok().body(arrayList);
                //json으로 상대에게 결과값을 보내줌
         }
    }

