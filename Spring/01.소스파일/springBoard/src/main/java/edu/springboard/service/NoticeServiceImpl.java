package edu.springboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.springboard.dao.NoticeDAO;
import edu.springboard.vo.NoticeVO;
import edu.springboard.vo.SearchVO;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	public NoticeDAO noticeDAO;
	
	@Override
	public List<NoticeVO> list(SearchVO searchVO) {
		return noticeDAO.list(searchVO);
	}

	@Override
	public int selectTotal(SearchVO searchVO) {
		return noticeDAO.total(searchVO);
	}

	@Override
	public int insert(NoticeVO vo) {
		return noticeDAO.insert(vo);
	}

	@Override
	public NoticeVO selectOne(int nno) {
		return noticeDAO.selectOne(nno);
	}

	@Override
	public int changeState(int nno) {
		return noticeDAO.changeState(nno);
	}

	@Override
	public int selectCntFreeByUid(String uid) {
		return noticeDAO.selectCntFreeByUid(uid);
	}

	/*
	 * @Override public int selectMaxNo() { return noticeDAO.selectMaxNno(); }
	 */

}
