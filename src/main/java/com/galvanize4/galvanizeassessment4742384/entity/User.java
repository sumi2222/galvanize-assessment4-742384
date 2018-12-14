package com.galvanize4.galvanizeassessment4742384.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userid;
    private String userName;

    @Builder
    public User(Long userid, String userName) {
        this.userid = userid;
        this.userName = userName;
    }
}
