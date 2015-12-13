package org.coffee.barva;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContraolPageController {
	@RequestMapping(value="/control.do", method = RequestMethod.GET)
	public String controlPage(){
		return "controlPage";
	}
}
