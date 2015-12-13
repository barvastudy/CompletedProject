package org.coffee.barva.controller;

import javax.servlet.http.HttpSession;

import org.coffee.barva.domain.UserVO;
import org.coffee.barva.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("user")
@SessionAttributes("user")
public class UserController {
	@Autowired
	private UserService userServiceImpl;
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String login(HttpSession session){
		if(session.getAttribute("user")!=null)
			return "redirect:/board/boardList.do";
		else
			return "user/loginView";
	}


	@RequestMapping(value="/join.do",method=RequestMethod.GET)
	public String join(){
		return "user/joinView";
	}

	@RequestMapping(value="/joinUser.do",method = RequestMethod.POST)
	public String joinUser(UserVO user){
		userServiceImpl.insertUser(user);
		return "user/loginView";
	}
	@RequestMapping(value="/userLogin.do",method=RequestMethod.POST)
	public String userLogin(UserVO user,Model model){
		user=userServiceImpl.loginUser(user);
		if(user!=null){
			model.addAttribute("user",user);
			return "redirect:/board/boardList.do";
		}
		else 
			return "user/loginView";

	}

}
