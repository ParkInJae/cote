package edu.springboard.service;

import java.util.List;
import java.util.Map;

import edu.springboard.vo.UserVO;

public interface UserService {
	
	public int insert(UserVO userVO);
	public int update(UserVO userVO);
	public UserVO selectByLogin(UserVO userVO);
	public List<UserVO> selectAll(Map<String,Integer> pagingParam);
	public UserVO selectOne(int uno);
	public int selectTotal();
	public int selectCntByUid(String uid);
	
}
