package com.example.ekyc.DTO;

import jakarta.persistence.Column;

import java.util.Date;


public class UserDTO {
    private String userName;

    private String userRole;

    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSaltedPasswordHash() {
        return saltedPasswordHash;
    }

    public void setSaltedPasswordHash(String saltedPasswordHash) {
        this.saltedPasswordHash = saltedPasswordHash;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getNidNumber() {
        return nidNumber;
    }

    public void setNidNumber(int nidNumber) {
        this.nidNumber = nidNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserPhotoDocumentId() {
        return userPhotoDocumentId;
    }

    public void setUserPhotoDocumentId(String userPhotoDocumentId) {
        this.userPhotoDocumentId = userPhotoDocumentId;
    }

    public String getNidFrontDocumentId() {
        return nidFrontDocumentId;
    }

    public void setNidFrontDocumentId(String nidFrontDocumentId) {
        this.nidFrontDocumentId = nidFrontDocumentId;
    }

    public String getNidBackDocumentId() {
        return nidBackDocumentId;
    }

    public void setNidBackDocumentId(String nidBackDocumentId) {
        this.nidBackDocumentId = nidBackDocumentId;
    }

    private String phoneNumber;

    private String salt;

    private String saltedPasswordHash;

    private String surName;

    private String givenName;

    private String fathersName;

    private String mothersName;

    private String gender;

    private String nationality;

    private int nidNumber;

    private Date dateOfBirth;

    private String userPhotoDocumentId;

    private String nidFrontDocumentId;

    private String nidBackDocumentId;
}

