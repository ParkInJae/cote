package edu.springboard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.springboard.vo.UserVO;

@Repository
public class UserDAO {

	@Autowired
	public SqlSession sqlSession;
	
	public int insert(UserVO userVO) {
		int result = 0;
		
		result = sqlSession.insert("edu.springboard.mapper.userMapper.userInsert",userVO);
		
		return result;
	}

	public int update(UserVO userVO) {
		return sqlSession.update("edu.springboard.mapper.userMapper.userUpdate", userVO);
	}
	
	public UserVO selectbyLogin(UserVO userVO) {
		return sqlSession.selectOne("edu.springboard.mapper.userMapper.selectUserByLogin", userVO);
	}
	
	public List<UserVO> selectAll(Map<String,Integer> pagingParam){
		return sqlSession.selectList("edu.springboard.mapper.userMapper.selectAll",pagingParam);
	}
	
	public UserVO selectOne(int uno) {
		return sqlSession.selectOne("edu.springboard.mapper.userMapper.selectOne", uno);
	}
	
	public int seletcTotal() {
		return sqlSession.selectOne("edu.springboard.mapper.userMapper.selectTotal");
	}
	
	public int selectCntByUid(String uid) {
		return sqlSession.selectOne("edu.springboard.mapper.userMapper.selectCntByUid", uid);
	}
	
}





