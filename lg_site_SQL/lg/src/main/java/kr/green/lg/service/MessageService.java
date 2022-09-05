package kr.green.lg.service;

import javax.servlet.http.HttpServletResponse;

public interface MessageService {
	//카테고리에서 사용할 메세지
	void CategoryMessage(HttpServletResponse response, int res);
	//일반적으로 사용할 메세지
	void message(HttpServletResponse response, String content, String redirectUrl);

}
