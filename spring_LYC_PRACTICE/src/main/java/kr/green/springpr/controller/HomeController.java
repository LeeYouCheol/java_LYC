package kr.green.springpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springpr.service.MemberService;
import kr.green.springpr.vo.MemberVO;


@Controller
public class HomeController {
	
	@Autowired
    MemberService memberService;
    
    @RequestMapping(value="/")
    public ModelAndView main(ModelAndView mv) {
        mv.setViewName("/main/home");
        return mv;
    }
    //회원가입 메소드
    @RequestMapping(value="/signup", method=RequestMethod.GET)
    public ModelAndView signupGet(ModelAndView mv) {
    	mv.setViewName("/main/signup");
    	return mv;
    }
    @RequestMapping(value="/signup", method=RequestMethod.POST)
    public ModelAndView signupPost(ModelAndView mv, MemberVO member) {
    	if(memberService.signup(member)) {
    		mv.setViewName("redirect:/");
    	}else {
    		mv.setViewName("redirect:/signup");
    	}
    	return mv;
    }
    //로그인 메소드
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public ModelAndView loginGet(ModelAndView mv) {
    	mv.setViewName("/main/login");
    	return mv;
    }
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public ModelAndView loginPost(ModelAndView mv, MemberVO member) {
    	MemberVO dbMember = memberService.login(member);
    	System.out.println(member.getMe_id()+"가 로그인되었습니다.");
    	mv.setViewName("redirect:/");
    	return mv;
    }
}
