package org.coffee.barva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	//URI가 '/doC'인 경우에 동작.
	@RequestMapping("doC")
	//@ModelAttribute("msg")는 요청에 'msg'이름의 파라미터를 문자열로 처리해 주고, 뷰에 전달함.
	public String doA(@ModelAttribute("msg") String msg) {

		logger.info("doC called......."+" msg = " + msg);
		
		return "result";
	}
}
