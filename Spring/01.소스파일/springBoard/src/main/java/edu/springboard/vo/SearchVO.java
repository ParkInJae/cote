package edu.springboard.vo;

import edu.springboard.util.PagingUtil;

public class SearchVO extends PagingUtil {
	private String searchType;
	private String searchValue;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	
	
}
