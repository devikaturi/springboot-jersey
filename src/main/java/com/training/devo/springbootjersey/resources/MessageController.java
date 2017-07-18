package com.training.devo.springbootjersey.resources;

import com.training.devo.springbootjersey.model.Message;
import com.training.devo.springbootjersey.services.MessageService;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Component
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageController {
	

	private MessageService msgService;
	private CommentResource commentResource;

	public MessageController(MessageService msgService) {
		this.msgService = msgService;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year") int year,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size){
		
		return msgService.getAllMessages();
	}
	
	@POST
	public Message addMessage(Message message) {
		return msgService.addMessage(message);
	}
    
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return msgService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long messageId) {
		
	  msgService.removeMessage(messageId);
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId) {
		return msgService.getMessage(messageId);
	}


	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
      return new CommentResource();
	}

    
	
	
}
