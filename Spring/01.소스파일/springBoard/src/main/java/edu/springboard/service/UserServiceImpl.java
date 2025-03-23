package edu.springboard.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.springboard.dao.UserDAO;
import edu.springboard.vo.UserVO;

@Service //업무로직을 담당하는 구현 객체를 스프링이 생성하여 관리
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDAO userDAO;
	
	@Override
	public int insert(UserVO userVO) {
		
		int result = 0;
		
		result = userDAO.insert(userVO);
		
		return result;
	}

	@Override
	public int update(UserVO userVO) {
		return userDAO.update(userVO);
	}

	@Override
	public UserVO selectByLogin(UserVO userVO) {
		return userDAO.selectbyLogin(userVO);
	}

	@Override
	public List<UserVO> selectAll(Map<String,Integer> pagingParam) {
		return userDAO.selectAll(pagingParam);
	}

	@Override
	public UserVO selectOne(int uno) {
		return userDAO.selectOne(uno);
	}

	@Override
	public int selectTotal() {
		return userDAO.seletcTotal();
	}

	@Override
	public int selectCntByUid(String uid) {
		return userDAO.selectCntByUid(uid);
	}
}





