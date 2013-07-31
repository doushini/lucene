package com.luo.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.luo.pojo.Message;
import com.luo.service.MessageService;

@Scope(value="prototype")
@Namespace("/message")
@Result(name="list",type="redirectAction",location="/list.action")
public class MessageAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Autowired
	private MessageService messageService;
	private Message message;
	private List<Message> messageList;
	
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	@Action(value="list",results={@Result(name=SUCCESS,location="/WEB-INF/content/messageList.jsp")})
	@Override
	public String list() throws Exception {
		messageList = messageService.list();
		return SUCCESS;
	}
	
	@Action(value="addMessage",results={@Result(name=SUCCESS,location="/WEB-INF/content/addMessage.jsp")})
	public String add() throws Exception {
		return SUCCESS;
	}
	
	@Action(value="save")
	@Override
	public String save() throws Exception {
		message.setAddTime(new Date());
		messageService.save(message);
		return LIST;
	}

	@Override
	public String del() throws Exception {
		messageService.delete(message.getId());
		return LIST;
	}

}
