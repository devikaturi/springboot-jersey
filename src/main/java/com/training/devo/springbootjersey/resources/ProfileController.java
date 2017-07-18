package com.training.devo.springbootjersey.resources;

import com.training.devo.springbootjersey.database.respositories.ProfileRepository;
import com.training.devo.springbootjersey.model.Profile;
import com.training.devo.springbootjersey.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileController {

	@Autowired
	private ProfileService profService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles(){
		return profService.getAllProfiles();
	}

	@POST
	public Profile addProfile(Profile profile) {

		return profService.addProfile(profile);
	}
	
	
	@GET
	@Path("/{profileName}")
	public Profile test(@PathParam("profileName") String profileName){
		
		return profService.getProfile(profileName);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		return profService.updateProfile(profile);
	}
    
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName) {
		
	  profService.removeProfile(profileName);
	}

}
