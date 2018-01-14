package com.youtube.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.dao.BaseDAO;
import com.youtube.dao.ContactDAO;
import com.youtube.domain.Contact;
import com.youtube.rm.ContactRowMapper;
import com.youtube.utility.StringUtility;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {

	@Autowired
	ContactDAO contactDAO;
	
	@Override
	public void save(Contact c) {
		contactDAO.save(c);

	}

	@Override
	public void update(Contact c) {
		contactDAO.update(c);

	}

	@Override
	public void delete(Integer contactId) {
		contactDAO.delete(contactId);

	}

	@Override
	public void delete(Integer[] contactIds) {
		String ids = StringUtility.toCommaSeperatedString(contactIds);
		String sql = "DELETE FROM contact WHERE contactId IN ("+ids+")";
		getJdbcTemplate().update(sql);
	}

	@Override
	public List<Contact> findUserContact(Integer userId) {
		return contactDAO.findByProperty("userId", userId);
	}

	@Override
	public List<Contact> findUserContact(Integer userId, String txt) {
		String sql = "SELECT contactId, userId, name, phone, email, address, remark"
				+ " FROM contact WHERE userId=? AND ( name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR "
						+ " phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%' )";
		return getJdbcTemplate().query(sql, new ContactRowMapper(), userId);
	}

	@Override
	public Contact findById(Integer contactId) {
		
		return contactDAO.findById(contactId);
	}

}
