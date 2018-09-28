package jp.xiaolongren.chinese.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jp.xiaolongren.chinese.bean.LoginPageInfo;

@Controller
public class InitWebsiteController {
	
    @GetMapping("/")
    public String login(Model model){
    	model.addAttribute("loginPageInfo", new LoginPageInfo());
    	return "login";
    }
    
}
