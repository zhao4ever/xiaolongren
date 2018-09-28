package jp.xiaolongren.chinese.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegisterController {
    @RequestMapping(value="/register")
    public ModelAndView register(ModelAndView mav) {
        mav.setViewName("register");
        return mav;
    }
}
