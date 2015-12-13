package org.coffee.barva;

import org.coffee.barva.domain.ProductVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController3 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);
	
	@RequestMapping("doD")
	public String doA(Model model) {

		//make sample data
		ProductVO product = new ProductVO("Sample Product", 10000);
		
		logger.info("doD called.......");

		//이름을 지정하지 않은 경우 자동으로 저장되는 객체의 클래스명 소문자로 처리한 클래스명 이름으로 간주.
		//뷰에서는 productVO로 EL Tag 사용 가능.
		model.addAttribute(product);
		
		return "productDetail";
	}
}
