package jp.xiaolongren.chinese.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.xiaolongren.chinese.bean.IndexPageInfo;
import jp.xiaolongren.chinese.bean.LoginPageInfo;
import jp.xiaolongren.chinese.bean.RegisterPageInfo;
import jp.xiaolongren.chinese.constant.ErrorCode;
import jp.xiaolongren.chinese.model.IdUserTbl;
import jp.xiaolongren.chinese.repository.IdUserTblRepository;
import jp.xiaolongren.chinese.utils.HashUtils;

@Controller
public class LoginController {
	
	@Autowired
    private IdUserTblRepository idUserTblRepository;
	
	@GetMapping("/guest")
    public String guestAccess(Model model){
		IndexPageInfo indexPageInfo = new IndexPageInfo();
    	indexPageInfo.setUsername("游客");
    	
    	model.addAttribute("indexPageInfo", indexPageInfo);
    	return "index";
    }
	
	@GetMapping("/register")
    public String login(Model model){
    	model.addAttribute("registerPageInfo", new RegisterPageInfo());
    	return "register";
    }
	
    @PostMapping("/login")
    public String login(@Valid LoginPageInfo loginPageInfo, BindingResult result, Model model){
    	    	
    	model.addAttribute("loginPageInfo", loginPageInfo);
    	
    	// input information check
//        if(result.hasErrors()){
//            List<ObjectError>  list = result.getAllErrors();
//            for(ObjectError error: list){
//            	System.out.println(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
//            }
//            
//            return "login";
//        }
        
        // user exist check
        IdUserTbl idUserTbl = idUserTblRepository.findByUsername(loginPageInfo.getUsername());
        System.out.println("idUserTblModel = " + idUserTbl);
        
        // user doesn't exist
        if(idUserTbl == null){
        	
        	result.rejectValue("username", ErrorCode.ACCOUNT_NOT_EXIST.getCode(), ErrorCode.ACCOUNT_NOT_EXIST.getDesc());
        	return "login";
        	
        // user exists, then check the password
        }else{
        	
        	if(!idUserTbl.getPassword().equals(HashUtils.hash(loginPageInfo.getPassword(), "SHA1"))){

                result.rejectValue("password", ErrorCode.PASSWORD_NOT_CORRECT.getCode(), ErrorCode.PASSWORD_NOT_CORRECT.getDesc());
            	return "login";
        	}
        	
        }
        
        // check ok, so redirect to index.html
        IndexPageInfo indexPageInfo = new IndexPageInfo();
    	indexPageInfo.setUsername(idUserTbl.getName());
    	
    	model.addAttribute("indexPageInfo", indexPageInfo);
    	return "index";
            	
     }    
}
