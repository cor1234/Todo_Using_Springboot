//package com.in28minutes.springboot.myfirstwebapp.login;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//@Controller
//@SessionAttributes("name")
//public class WelcomeController {
//
//    private AuthenticationService authenticationService;
//
////    public LoginController(AuthenticationService authenticationService) {
////        super();
////        this.authenticationService = authenticationService;
////    }
// //   private Logger logger= LoggerFactory.getLogger(getClass());
//    ///login => com.in28minutes.springboot.myfirstwebapp.login.LoginController => login.jsp
//    //http://localhost:8080/login?name=Ranga
//    //Model passing value from controller to jsp using modl
//
//   // public String gotoLoginPage(@RequestParam String name, ModelMap model)
//    @RequestMapping(value="/",method = RequestMethod.GET)
//
//    public String gotoWelcomePage(ModelMap model) {
//        model.put("name", "in28minutes");
////        logger.debug("Request param is {}",name);
////        logger.info("I want this  info level");
////        logger.warn("I want this at warn level");
//      //  System.out.println("Request param is " + name); //NOT RECOMMENDED FOR PROD CODE
//        return "welcome";
//    }
////    @RequestMapping(value="login",method = RequestMethod.POST)
////    public String gotoWelcomePage(@RequestParam String name,
////                                  @RequestParam String password, ModelMap model){
////        if(authenticationService.authenticate(name, password)) {
////
////            model.put("name", name);
////            //Authentication
////            //name - in28minutes
////            //password - dummy
////
////            return "welcome";
////        }
////       model.put("errorMessage","Ibvalid Credential");
////        return "login";
////    }
//}

package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
        model.put("name", getLoggedinUsername());
        return "welcome";
    }

    private String getLoggedinUsername() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}