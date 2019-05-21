package com.isa.action;

import com.isa.service.IUserService;
import com.isa.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserAction {
    @Autowired
    IUserService userService;
    @RequestMapping("/login.do")
    @ResponseBody
    public String login(String uname,String upwd) {
        //System.out.println(uname+","+upwd);
        /*硬编码
         */
        IUserService userService=new UserServiceImpl();
        //从那边拿过来
        String str=userService.login(uname,upwd);
        return str;

    }

    @RequestMapping("/register.do")
    @ResponseBody
    public String register(String uname,String upwd,String email) {
        //System.out.println(uname+","+upwd);
        /*硬编码
         */

        boolean temp=userService.register(uname,upwd,email);
        if(temp)
            return "success";
        else
            return "fault";

    }
}
