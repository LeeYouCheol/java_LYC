package kr.green.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.serveice.MemberService;
import kr.green.spring.vo.MemberVO;


@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	// http://localhost:8080/spring/main/home
	/*	접근제한자 : public 고정
	 * 	리턴타입 : ajax를 이용한 경우는 제외하고는 기본적으로 ModelAndView 고정
	 * 	메소드명 : url 경로에서 따오는게 편함
	 * 	예외처리 : 안해도됨
	 * */
	/* mv.setViewName(문자열)
	 *  - ViewResolver로 보낼 문자열을 설정
	 *  - redirect, forward가 있는 경우는 url로 이동
	 *    예 : "redirect:/" 또는 "forward:/"
	 * mv.addObject("화면에서 사용할 이름", 변수/객체)
	 * 	- 화면에서 사용할 데이터를 이름과 함께 추가
	 * */
	/* @RequestMapping
	 * value : 처리할 url, {"url1", "url2"}을 이용하여 여러 url을 하나로 처리할 수 있다
	 * method : url요청방식, RequestMethod.GET/RequestMethod.POST
	 * 	- 생략하면 둘다 처리
	 * */
	/*	화면에서 hobby와 time을 안보내면, null이 자동으로 들어감
	 * 	이 때, hobby와 time의 타입이 null을 처리할 수 없는 타입이면 에러가 발생
	 * */
	@RequestMapping(value= "/", method=RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, String hobby, Integer time) throws Exception{
		mv.setViewName("/main/home");
		mv.addObject("name", "홍길동");
		mv.addObject("age", 20);
		System.out.println("취미는 " + hobby + "이고, " + time + "시간씩 합니다.");
		return mv;
	}
	@RequestMapping(value= "/", method=RequestMethod.POST)
	public ModelAndView homePost(ModelAndView mv, String hobby, Integer time) throws Exception{
		mv.setViewName("redirect:/");
		System.out.println("취미는 " + hobby + "이고, " + time + "시간씩 합니다.");
		return mv;
	}
	@RequestMapping(value= "/hobby/{hobby1}/{time1}")
	public ModelAndView hobby(ModelAndView mv,
		@PathVariable("hobby1") String hobby,
		@PathVariable("time1") Integer time) throws Exception{
		System.out.println("취미는 " + hobby + "이고, " + time + "시간씩 합니다.");
		return mv;
	}
	@RequestMapping(value= "/login", method=RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) throws Exception{
		mv.setViewName("/main/login");
		return mv;
	}
	@RequestMapping(value= "/login", method=RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member) throws Exception{
		mv.setViewName("redirect:/login");
		System.out.println(member);
		//아이디가 주어지면 이메일을 가져오는 작업
		String email = memberService.getEmail(member.getMe_id());
		System.out.println("이메일 : "+email);
		//아이디가 주어지면 회원정보를 가져오는 작업
		MemberVO dbMember1 = memberService.getMember(member.getMe_id());
		System.out.println(dbMember1);
		//아이디와 비번이 주어지면 아이디와 비번이 일치하는 회원정보를 가져오는 작업
		MemberVO dbMember2 = memberService.getMember(member);
		System.out.println(dbMember2);
		return mv;
	}
}
