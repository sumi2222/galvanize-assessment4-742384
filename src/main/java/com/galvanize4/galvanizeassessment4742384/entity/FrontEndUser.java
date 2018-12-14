package com.galvanize4.galvanizeassessment4742384.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FrontEndUser {

    Long userid;
    private String userName;

    @Builder
    public FrontEndUser(Long userid, String userName) {
        this.userid = userid;
        this.userName = userName;
    }

}
