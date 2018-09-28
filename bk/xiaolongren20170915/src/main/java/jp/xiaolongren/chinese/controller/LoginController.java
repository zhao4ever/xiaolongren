package jp.xiaolongren.chinese.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jp.xiaolongren.chinese.bean.UserLoginInfo;

@Controller
public class LoginController {
	
    @GetMapping(value="/")
    public String login(Model model){
    	model.addAttribute("userLoginInfo", new UserLoginInfo());
    	return "login";
    }
    
    @PostMapping("/login")
    public String loginAdd(@Valid UserLoginInfo userLoginInfo, BindingResult result, Model model){
        // check error info
        model.addAttribute("userLoginInfo", userLoginInfo);
        if(result.hasErrors()){
            List<ObjectError>  list = result.getAllErrors();
            for(ObjectError error: list){
            	System.out.println(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
            }
           
            return "login";
        }
        return "index";
     }    
}
