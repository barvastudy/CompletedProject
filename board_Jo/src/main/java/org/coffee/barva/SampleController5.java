package org.coffee.barva;

import org.coffee.barva.domain.ProductVO;
import org.coffee.barva.domain.UserVO;
import org.coffee.barva.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController5 {

	@Autowired
	UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController5.class);
	
	@RequestMapping("doJSON")
	public @ResponseBody ProductVO doJSON() {
		
		ProductVO vo = new ProductVO("샘플상품", 30000);
		
		return vo;
	}
	
	@RequestMapping("userinfo")
	public String userinfo(UserVO userVO, Model model) {
	
		logger.info("userinfo called.......");
		
		userVO = userService.userinfo();
		System.out.println(userVO.toString());
		model.addAttribute(userVO);
		
		return "result";
	}
}
