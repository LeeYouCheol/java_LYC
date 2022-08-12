package kr.green.springtest.pagination;

import lombok.Data;

@Data
public class Criteria {
	//현재 페이지
		private int page; 
		//한 페이지 당 컨텐츠 갯수
		private int perPageNum;
		//검색어
		private String search;
		//검색 타입
		private String searchType;
		//Criteria 디폴트 생성자 : 현재 페이지를 1페이지로, 한 페이지에 10개의 컨텐츠
		/* 쿼리문에서 limit에 사용되는 인덱스를 계산하는 getter */
		public int getPageStart() {
			return (this.page -1) * perPageNum;
		}
		public Criteria() {
			page = 1;
			perPageNum = 10;
			search = "";
			searchType = "all";
		}
}
