package com.yojulab.study_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

// controlleer는 rest api와 비슷

// rest api처럼 client한테 응답할 수 있는 접점으로 cap 씌어주는 Controller
// ioc (내가 관리하는 애) 중에서 외부와 클라이언트와 접점에 있는것 
@Controller
public class MainController {
    @GetMapping({"/", "/home", "/main"})
    public ModelAndView main(ModelAndView modelAndView){
        modelAndView.addObject("name", "Yojulab!"); //서블릿에서 attribute과같다. model 뒤에 값 세팅. model에서 jsp로넘기는것과 같다. 서블릿add.attribute에서 리퀘스트에서 던지는것과 같다. 
        modelAndView.setViewName("/WEB-INF/views/main.jsp");
        return modelAndView;
    }
    // @GetMapping({"/", "/home", "/main"})//root에서 들어오는 uri니까 / 넣어주면 됨. 
    // //하나의 메소드에 uri여러개 들어오게 할 수 있다. 또 다른 메소드 안들어도됨.
    // //자바에서 {}이건 array 
    // public ModelAndView main(ModelAndView modelAndView){   
    //     modelAndView.setViewName("/WEB-INF/views/main.jsp");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
    //    //relative path: project 중심 
    //     return modelAndView;
    // }
}

// form-data: form 태그에 input data를 넣고 name을 붙여줘서 가는 방식
