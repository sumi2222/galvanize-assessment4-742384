package com.galvanize4.galvanizeassessment4742384.repository;

import com.galvanize4.galvanizeassessment4742384.entity.UserEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface UserEventRepository extends CrudRepository<UserEvent, Long> {

    List<UserEvent> getAllByEventHappenedTimeBetween(Date eventHappenedTime1, Date eventHappenedTime2);
    List<UserEvent> getAllByUserid(Long userid);
    List<UserEvent> getAllByType(String type);
    List<UserEvent> getAllByContext(String context);
}
