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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@Service
public class UserEventService {

    private UserEventRepository repositoryEvent;
    private UserRepository userRepository;

    @Autowired
    public UserEventService(UserEventRepository repositoryEvent, UserRepository userRepository) {
        this.repositoryEvent = repositoryEvent;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(FrontEndUser user) {
        userRepository.save(User.builder().userName(user.getUserName()).build());
    }

    @Transactional
  public void saveUserEvent(FrontEndUserEvent userEvent) {
        repositoryEvent.save(UserEvent.builder().userid(userEvent.getUserid()).type(userEvent.getType()).context(userEvent.getContext()).eventHappenedTime(new Date()).build());
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
    public List<UserEvent> specificUserDetails(Long userid) {
        return repositoryEvent.getAllByUserid(userid);
    }
    @Transactional
    public List<UserEvent> findByTimeFrame(String date1, String date2) {
        try {
            return repositoryEvent.getAllByEventHappenedTimeBetween(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(date1).getTime()), new Date(new SimpleDateFormat("yyyy-MM-dd").parse(date2).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}