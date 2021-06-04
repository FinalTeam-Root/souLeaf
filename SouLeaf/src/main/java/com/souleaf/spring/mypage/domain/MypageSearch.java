package com.souleaf.spring.mypage.domain;

public class MypageSearch {
	private String searchCondition;
	private String searchValue;
	
	public MypageSearch() {}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	@Override
	public String toString() {
		return "MypageSearch [searchCondition=" + searchCondition + ", searchValue=" + searchValue + "]";
	}
	
}
