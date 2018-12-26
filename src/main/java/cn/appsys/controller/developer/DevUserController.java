package cn.appsys.controller.developer;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.DevUserService;

@Controller
@RequestMapping(value="/dev")
public class DevUserController {
	@Resource
	private DevUserService devUserService;
	
	@RequestMapping("/login")
	public String DevLogin(){
		return "/developer/devlogin";
	}
	
	@RequestMapping("/toLogin")
	public String DevToLogin(String devCode,String password,HttpSession session){
		DevUser devUser=devUserService.getLoginUser(devCode, password);
		if(devUser!=null){
			session.setAttribute("devUser", devUser);
		}else{
			return "/developer/devlogin";
		}
		return "/developer/devShow";
	}
	
	@RequestMapping("/toDevShow")
	public String DevShowManu(){
		
		return "/developer/showMeun";
	}
	
	@RequestMapping("/loginout")
	public String LoginOut(HttpSession session){
		session.removeAttribute("devUser");
		return "redirect:dev/login";
	}
	

}
