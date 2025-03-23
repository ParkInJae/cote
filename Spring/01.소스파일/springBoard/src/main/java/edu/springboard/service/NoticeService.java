package edu.springboard.service;

import java.util.List;

import edu.springboard.vo.NoticeVO;
import edu.springboard.vo.SearchVO;

public interface NoticeService {
	
	public List<NoticeVO> list(SearchVO searchVO);
	public int selectTotal(SearchVO searchVO);
	public int insert(NoticeVO vo);
	/* public int selectMaxNo(); */
	public NoticeVO selectOne(int nno);
	
	public int changeState(int nno);
	
	public int selectCntFreeByUid(String uid);
	
}
