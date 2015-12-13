package org.coffee.barva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController4.class);
	
	@RequestMapping("doE")
	public String doE(RedirectAttributes rttr) {

		logger.info("doE called but redirect to doF.......");
		
		//임시 데이터 전달. URI에 보이지 않게 데이터를 전달. View에 전달.
		rttr.addFlashAttribute("msg", "This is the Message!! with redirected");
		//URI나 console에 나타내려면 아래와 같이 사용한다.
		return "redirect:doF?msg=This is the Message!! Controller";
	}
	
	@RequestMapping("doF")
	public void doF(String msg) {
		logger.info("doF called......."+ msg);
	}
}
