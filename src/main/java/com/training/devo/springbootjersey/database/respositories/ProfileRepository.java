package com.training.devo.springbootjersey.database.respositories;

import com.training.devo.springbootjersey.model.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DK05478 on 7/17/2017.
 */

@Repository
public interface  ProfileRepository extends CrudRepository<Profile, String> {

/**
    @Query("Select * from Profile p where p.firstName=:firstName and lastName=:lastName")
    List<Profile> findDistinctProfileByLastName(@Param("lastName") String lastName,
                                                @Param("firstName") String firstName);
 */
    Profile findByFirstName(String firstName);
}
