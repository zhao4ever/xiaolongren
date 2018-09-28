package jp.xiaolongren.chinese.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import jp.xiaolongren.chinese.bean.IndexPageInfo;
import jp.xiaolongren.chinese.bean.RegisterPageInfo;
import jp.xiaolongren.chinese.constant.ErrorCode;
import jp.xiaolongren.chinese.model.IdUserTbl;
import jp.xiaolongren.chinese.repository.IdUserTblRepository;
import jp.xiaolongren.chinese.utils.HashUtils;

@Controller
public class RegisterController {
	
	@Autowired
    private IdUserTblRepository idUserTblRepository;
	
	@PostMapping("/rigister")
    public String register(@Valid RegisterPageInfo userRegisterInfo, BindingResult result, Model model){
		
		model.addAttribute("userRegisterInfo", userRegisterInfo);
		
		// user exist check
        IdUserTbl idUserTbl = idUserTblRepository.findByUsername(userRegisterInfo.getUsername());
        System.out.println("idUserTblModel = " + idUserTbl);
        
        if(idUserTbl != null){	
        	result.rejectValue("username", ErrorCode.ACCOUNT_EXISTED.getCode(), ErrorCode.ACCOUNT_EXISTED.getDesc());
        	return "register";
        }
        
        // password unmatch
        if(!userRegisterInfo.getPassword().equals(userRegisterInfo.getConformationPwd())){
    		result.rejectValue("conformationPwd", ErrorCode.PASSWORD_UNMATCH.getCode(), ErrorCode.PASSWORD_UNMATCH.getDesc());
        	return "register";
    	}
        
        // input information check
        if(result.hasErrors()){
            List<ObjectError>  list = result.getAllErrors();
            for(ObjectError error: list){
            	System.out.println(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
            }
            return "register";
        }
        
		idUserTbl = new IdUserTbl();
		idUserTbl.setUsername(userRegisterInfo.getUsername());
		idUserTbl.setPassword(HashUtils.hash(userRegisterInfo.getPassword(), "SHA1"));
		idUserTbl.setName(userRegisterInfo.getName());
		idUserTbl.setEmail(userRegisterInfo.getEmail());
		idUserTbl.setPhone(userRegisterInfo.getPhone());
		idUserTbl.setWeixin(userRegisterInfo.getWeixin());
		idUserTbl.setAddress(userRegisterInfo.getAddress());
		idUserTbl.setDeleted("0");
		
		idUserTblRepository.save(idUserTbl);
        
        IndexPageInfo indexPageInfo = new IndexPageInfo();
    	indexPageInfo.setUsername(userRegisterInfo.getName());
        
        model.addAttribute("indexPageInfo", indexPageInfo);
        return "index";
		
	}
}
