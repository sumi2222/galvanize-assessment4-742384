package com.galvanize4.galvanizeassessment4742384.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor
public class UserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long eventid;
    private Long userid;
    private String type;
    private String context;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventHappenedTime;

    @Builder
    public UserEvent( Long eventid, Long userid, String type, String context, Date eventHappenedTime) {
        this.eventid = eventid;
        this.userid = userid;
        this.type = type;
        this.context = context;
        this.eventHappenedTime = eventHappenedTime;
    }
}