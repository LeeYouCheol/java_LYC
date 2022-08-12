package kr.green.springtest.pagination;

import lombok.Data;

@Data
public class PageMaker {
	//멤버변수
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum;
	private Criteria cri;
	
	/* endPage, startPage, prev, next 값 계산 */
	public void calcData() {
		endPage = (int) (Math.ceil(cri.getPage()/(double) displayPageNum)*displayPageNum);
		startPage = (endPage - displayPageNum)+1;
		int tempEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		prev = startPage == 1 ? false : true;
		next = endPage * cri.getPerPageNum() >= totalCount ? false:true;
	}
	//totlaCount, displayPageNum, Criteria cri를 이용한 생성자 추가후 생성자에서 calcData()호출
	//
	public PageMaker(int totalCount, int displayPageNum, Criteria cri) {
		this.cri = cri;
		this.displayPageNum = displayPageNum;
		this.totalCount = totalCount;
		calcData();
	}
}
