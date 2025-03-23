package edu.springboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.springboard.vo.NoticeVO;
import edu.springboard.vo.SearchVO;

@Repository
public class NoticeDAO {
	
	@Autowired
	public SqlSession sqlSession;
	
	private final String namespace = "edu.springboard.mapper.noticeMapper";
	
	public List<NoticeVO> list(SearchVO searchVO){
		return sqlSession.selectList(namespace+".selectAll",searchVO);
	}
	
	public int total(SearchVO searchVO){
		return sqlSession.selectOne(namespace+".selectTotal",searchVO);
	}
	
	public int insert(NoticeVO vo) {
		return sqlSession.insert(namespace+".insert", vo);
	}
	
	/*
	 * public int selectMaxNno() { return
	 * sqlSession.selectOne(namespace+".selectMaxNno"); }
	 */
	public NoticeVO selectOne(int nno) {
		return sqlSession.selectOne(namespace+".selectOne", nno);
	}
	
	
	public int changeState(int nno) {
		return sqlSession.update(namespace+".changeState",nno);
	}
	
	public int selectCntFreeByUid(String uid) {
		return sqlSession.selectOne(namespace+".selectCntFreeByUid", uid);
	}
	
}








