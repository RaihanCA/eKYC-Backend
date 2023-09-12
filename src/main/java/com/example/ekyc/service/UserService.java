package com.example.ekyc.service;

import com.example.ekyc.DTO.UserDTO;
import com.example.ekyc.entity.UserEntity;
import com.example.ekyc.repository.UserRepository;
import com.example.ekyc.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserEntity userEntity = new UserEntity();

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String addUser(UserDTO userdto){
        userEntity.setUserId(ConstantUtil.getUUID());
        userEntity.setEmail(userdto.getEmail());
        userEntity.setUserName(userdto.getUserName());
        userEntity.setUserRole(userdto.getUserRole());
        userEntity.setPhoneNumber(userdto.getPhoneNumber());
        userEntity.setSalt(userdto.getSalt());
        userEntity.setSaltedPasswordHash(userdto.getSaltedPasswordHash());
        userEntity.setSurName(userdto.getSurName());
        userEntity.setGivenName(userdto.getGivenName());
        userEntity.setFathersName(userdto.getFathersName());
        userEntity.setMothersName(userdto.getMothersName());
        userEntity.setGender(userdto.getGender());
        userEntity.setNationality(userdto.getNationality());
        userEntity.setNidNumber(userdto.getNidNumber());
        userEntity.setDateOfBirth(userdto.getDateOfBirth());
        userEntity.setUserPhotoDocumentId(userdto.getUserPhotoDocumentId());
        userEntity.setNidFrontDocumentId(userdto.getNidFrontDocumentId());
        userEntity.setNidBackDocumentId(userdto.getNidBackDocumentId());
        userRepository.save(userEntity);
        return userEntity.getUserId();
    }

    public UserDTO getUserById(String userId) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            // Convert userEntity to UserDTO and return it
            UserDTO userDTO = new UserDTO();
            // Set userDTO properties using userEntity
            // ...
            userDTO.setUserName(userEntity.getUserName());
            userDTO.setUserRole(userEntity.getUserRole());
            userDTO.setEmail(userEntity.getEmail());
            userDTO.setPhoneNumber(userEntity.getPhoneNumber());
            userDTO.setSurName(userEntity.getSurName());
            userDTO.setGivenName(userEntity.getGivenName());
            userDTO.setFathersName(userEntity.getFathersName());
            userDTO.setMothersName(userEntity.getMothersName());
            userDTO.setGender(userEntity.getGender());
            userDTO.setNationality(userEntity.getNationality());
            userDTO.setNidNumber(userEntity.getNidNumber());
            userDTO.setDateOfBirth(userEntity.getDateOfBirth());
            userDTO.setUserPhotoDocumentId(userEntity.getUserPhotoDocumentId());
            userDTO.setNidFrontDocumentId(userEntity.getNidFrontDocumentId());
            userDTO.setNidBackDocumentId(userEntity.getNidBackDocumentId());


            return userDTO;
        } else {
            return null;
        }
    }

    public boolean updateUser(String userId, UserDTO userdto) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            // Update userEntity properties using userdto
            // ...
            userEntity.setEmail(userdto.getEmail());
            userEntity.setUserName(userdto.getUserName());
            userEntity.setUserRole(userdto.getUserRole());
            userEntity.setPhoneNumber(userdto.getPhoneNumber());
            //userentity.setSalt(userdto.getSalt());
            //userentity.setSaltedPasswordHash(userdto.getSaltedPasswordHash());
            userEntity.setSurName(userdto.getSurName());
            userEntity.setGivenName(userdto.getGivenName());
            userEntity.setFathersName(userdto.getFathersName());
            userEntity.setMothersName(userdto.getMothersName());
            userEntity.setGender(userdto.getGender());
            userEntity.setNationality(userdto.getNationality());
            //userentity.setNidNumber(userdto.getNidNumber());
            //userentity.setDateOfBirth(userdto.getDateOfBirth());
            userEntity.setUserPhotoDocumentId(userdto.getUserPhotoDocumentId());
            userEntity.setNidFrontDocumentId(userdto.getNidFrontDocumentId());
            userEntity.setNidBackDocumentId(userdto.getNidBackDocumentId());

            userRepository.save(userEntity);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteUser(String userId) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
        if (optionalUserEntity.isPresent()) {
            userRepository.deleteById(userId);
            return true;
        } else {
            return false;
        }
    }
}
