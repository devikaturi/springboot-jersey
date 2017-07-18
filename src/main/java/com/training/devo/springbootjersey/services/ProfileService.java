package com.training.devo.springbootjersey.services;

import com.training.devo.springbootjersey.database.respositories.ProfileRepository;
import com.training.devo.springbootjersey.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class ProfileService {


	@Autowired
	private ProfileRepository profRepository;


	public List<Profile> getAllProfiles() {
		ArrayList<Profile> profiles = new ArrayList<>();
		final Iterable<Profile> all = profRepository.findAll();
		profRepository.findAll().forEach(profiles::add);

		return profiles;
	}

	public Profile getProfile(String profileName) {
		List<Profile> allProfiles = this.getAllProfiles();
		for (Profile p : allProfiles) {
			if (p.getProfileName().equals(profileName)) {
				return p;
			}
		}

		return null;
	}

	public Profile addProfile(Profile profile) {
		List<Profile> allProfiles = this.getAllProfiles();

		profile.setId(allProfiles.size() + 1);
		profile.setCreated(new Date());
		profRepository.save(profile);

		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		List<Profile> allProfiles = this.getAllProfiles();

		if (allProfiles.contains(profile)) {
			allProfiles.set(allProfiles.indexOf(profile), profile);
		}

		return profile;
	}

	public boolean removeProfile(String profileName) {
		List<Profile> allProfiles = this.getAllProfiles();
		Profile prof = null;
		for (Profile p : allProfiles) {
				if (p.getProfileName().equals(profileName))
					return allProfiles.remove(p);
		}
		return false;
	}
}