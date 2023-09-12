package com.example.ekyc.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "USER_TBL")
public class UserEntity {
    @Id
    @Column(name= "userId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    @Column(name= "userName")
    private String userName;
    @Column(name= "userRole")
    private String userRole;
    @Column(name= "email")
    private String email;
    @Column(name= "phoneNumber")
    private String phoneNumber;
    @Column(name= "salt")
    private String salt;
    @Column(name= "saltedPasswordHash")
    private String saltedPasswordHash;
    @Column(name= "surName")
    private String surName;
    @Column(name= "givenName")
    private String givenName;
    @Column(name= "fathersName")
    private String fathersName;
    @Column(name= "mothersName")
    private String mothersName;
    @Column(name= "gender")
    private String gender;
    @Column(name= "nationality")
    private String nationality;
    @Column(name= "nidNumber")
    private int nidNumber;
    @Column(name= "dateOfBirth")
    private Date dateOfBirth;
    @Column(name= "userPhotoDocumentId")
    private String userPhotoDocumentId;
    @Column(name= "nidFrontDocumentId")
    private String nidFrontDocumentId;
    @Column(name= "nidBackDocumentId")
    private String nidBackDocumentId;

}
