package com.galvanize4.galvanizeassessment4742384.service;

import com.galvanize4.galvanizeassessment4742384.entity.FrontEndUser;
import com.galvanize4.galvanizeassessment4742384.entity.FrontEndUserEvent;
import com.galvanize4.galvanizeassessment4742384.entity.User;
import com.galvanize4.galvanizeassessment4742384.entity.UserEvent;
import com.galvanize4.galvanizeassessment4742384.repository.UserEventRepository;
import com.galvanize4.galvanizeassessment4742384.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Data
@Service
public class UserEventService {

    private UserEventRepository repositoryEvent;
    private UserRepository userRepository;

    @Autowired
    public UserEventService(UserEventRepository repository, UserRepository userRepository) {
        this.repositoryEvent = repositoryEvent;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(FrontEndUser user) {
        User.builder().userName(user.getUserName());
        userRepository.save(User.builder().userName(user.getUserName()).build());
    }

    @Transactional
  public void saveUserEvent(FrontEndUserEvent userEvent) {
        repositoryEvent.save(UserEvent.builder().type(userEvent.getType()).context(userEvent.getContext()).eventHappenedTime(userEvent.getEventHappenedTime()).build());
    }

    @Transactional
    public List<UserEvent> findByType(String type) {
        return repositoryEvent.getAllByType(type);
    }

    @Transactional
    public List<UserEvent> findByContext(String context) {
        return repositoryEvent.getAllByContext(context);
    }

    @Transactional
    public List<UserEvent> findByCont(String context) {
        return repositoryEvent.getAllByType(context);
    }

    @Transactional
    public List<UserEvent> specificUserDetails(Long userid) {
        return repositoryEvent.getAllByUserid(userid);
    }
    @Transactional
    public List<UserEvent> findByTimeFrame(Date time1, Date time2) {
        return repositoryEvent.getAllByEventHappenedTimeOrEventHappenedTime(time1, time2);
    }
}