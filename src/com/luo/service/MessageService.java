package com.luo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luo.dao.MessageDao;
import com.luo.pojo.Message;

@Service
@Transactional
public class MessageService {
	@Autowired
	private MessageDao messageDao;
	
	
	public List<Message> list() {
		return messageDao.findAll();
	}

	public void save(Message message) {
		messageDao.save(message);
	}

	public void delete(int id) {
		messageDao.del(id);
	}

}
