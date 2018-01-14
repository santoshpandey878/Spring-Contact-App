package com.youtube.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.youtube.dao.BaseDAO;
import com.youtube.dao.UserDAO;
import com.youtube.domain.User;
import com.youtube.exception.UserBlockedException;
import com.youtube.rm.UserRowMapper;

@Service
public class UserServiceImpl extends BaseDAO implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void register(User u) {
		userDAO.save(u);

	}

	@Override
	public User login(String loginName, String password)
			throws UserBlockedException {

		String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
				+ " FROM user WHERE loginName=:ln AND password =:pw";
		Map m = new HashMap();
		m.put("ln", loginName);
		m.put("pw", password);

		try {
			User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
			if(u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)){
				//BLOCKED
				throw new UserBlockedException("Your account has been locked. Contact to Admin");
			}
			else{
				//SUCCESS
				return u;
			}
		} catch (EmptyResultDataAccessException ex) {
			//FAILURE
			return null;
		}
	}

	@Override
	public List<User> getUserList() {
		return userDAO.findByProperty("role", UserService.ROLE_USER);
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		String sql = "UPDATE user "
				+ " SET loginStatus=:lst"
				+ " WHERE userId=:uid";
		
		Map m = new HashMap();
		m.put("lst", loginStatus);
		m.put("uid", userId);
		
		getNamedParameterJdbcTemplate().update(sql, m);

	}

	@Override
	public Boolean isUserNameExist(String userName) {
		String sql = "SELECT count(loginName)"
				+ " FROM user WHERE loginName=?";
		Integer count = getJdbcTemplate().queryForObject(sql, new String[]{userName}, Integer.class);
		if(count == 1){
			return true;
		}
		else{
			return false;
		}
	}

}
