package com.eventspot.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.eventspot.userservice.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
