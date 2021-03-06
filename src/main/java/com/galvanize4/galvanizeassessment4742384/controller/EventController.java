package com.galvanize4.galvanizeassessment4742384.controller;

import com.galvanize4.galvanizeassessment4742384.entity.FrontEndUser;
import com.galvanize4.galvanizeassessment4742384.entity.FrontEndUserEvent;
import com.galvanize4.galvanizeassessment4742384.entity.User;
import com.galvanize4.galvanizeassessment4742384.entity.UserEvent;
import com.galvanize4.galvanizeassessment4742384.service.UserEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/event")
public class EventController {

    private final UserEventService service;

    @Autowired
    public EventController(UserEventService service) {
        this.service = service;
    }

    @PostMapping("/saveuser")
    public void saveUser(@RequestBody FrontEndUser user) {
        service.saveUser(user);
    }

    @PostMapping("/saveuserevent")
    public void saveUserEvent(@RequestBody FrontEndUserEvent userEvent) {
        service.saveUserEvent(userEvent);
    }

    @GetMapping("/type/{type}")
    public Iterable<UserEvent> findByType(@PathVariable String type) {
        return service.findByType(type);
    }

    @GetMapping("/userid/{userid}")
    public Iterable<UserEvent> specificUserDetails(@PathVariable Long userid) {
        return service.specificUserDetails(userid);
    }

    @GetMapping("/context/{context}")
    public Iterable<UserEvent> findByContext(@PathVariable String context) {
        return service.findByContext(context);
    }
    @GetMapping("/eventHappenedTime/{date1}/{date2}")
    public Iterable<UserEvent> findByTimeFrame(@PathVariable String date1, @PathVariable String date2 ) {
        return service.findByTimeFrame(date1, date2);
    }
}