package com.training.devo.springbootjersey.services;

import com.training.devo.springbootjersey.database.DatabaseStub;
import com.training.devo.springbootjersey.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ws.rs.QueryParam;


@Service
public class MessageService {
	

    private Map<Long, Message> messages= DatabaseStub.getMessages();

    public MessageService() {
    }

	@PostConstruct
	public void loadMessage() {
		this.messages.put(1L, new Message(1L,"Hello Welcome to Spring boot","Devi"));
	}

	public List<Message> getAllMessages(){
	   return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		return null;
	}
	public List<Message> getAllMessagesPaginated(int start,int size){
		return null;
	}
	
	
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		message.setCreated(new Date());
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId()<=0) {
			return null;
		}

		messages.put(message.getId(),message);
		return message;
	}
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
}

