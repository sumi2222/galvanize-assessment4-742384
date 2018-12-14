package com.galvanize4.galvanizeassessment4742384.entity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FrontEndUserEvent {

    Long eventid;
    private Long userid;
    private String type;
    private String context;

    @Builder
    public FrontEndUserEvent(Long eventid, Long userid, String type, String context) {
        this.eventid = eventid;
        this.userid = userid;
        this.type = type;
        this.context = context;
    }

}
