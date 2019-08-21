package com.sapient.data.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.data.dao.DataDao;
import com.sapient.data.model.User;

@Service
public class DataService {

	@Autowired
	DataDao dataDao;

	public Optional<User> getUserForAuthentication(User loginUser) {

		Optional<User> optional;
		if (loginUser.getEmailID() == null) {
			optional = dataDao.findByUserID(loginUser.getUserID());
		} else {
			optional = dataDao.findByEmailID(loginUser.getEmailID());
		}
		return optional;
	}

	@Transactional
	public int changePassword(User user) {
		return dataDao.updatePassword(user.getPasswordHistory().getPassId(), user.getPasswordHistory().getPwd1(), user.getPasswordHistory().getSalt1());
	}

	public boolean checkEmailFlag(User user) {
		return dataDao.getEmailFlag(user.getUserID());
	}
}
