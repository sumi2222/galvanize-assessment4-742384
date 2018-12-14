package com.galvanize4.galvanizeassessment4742384.repository;

import com.galvanize4.galvanizeassessment4742384.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


}
