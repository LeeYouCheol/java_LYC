package kr.green.springpr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/main/home")
	public ModelAndView openTilesView(ModelAndView mv) {
		mv.setViewName("/main/home");
		mv.addObject("setHeader", "타일즈");
		return mv;
	}
	
}
