package com.training.devo.springbootjersey.database;

import java.util.HashMap;
import java.util.Map;
import com.training.devo.springbootjersey.model.*;

public class DatabaseStub {
	
	private static Map<Long,Message> messages= new HashMap<>();
	private static Map<String,Profile> profiles= new HashMap<>();
	
	public static Map<Long,Message> getMessages(){
		return messages;
	}
	public static Map<String,Profile> getProfiles(){
		return profiles;
	}

}
