package jp.xiaolongren.chinese.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
//	@Autowired
//    private IdUserTblRepository idUserTblRepository;
	
	@GetMapping("/homework")
    public String login(Model model){
    	//model.addAttribute("registerPageInfo", new RegisterPageInfo());
    	return "homework";
    }
}
