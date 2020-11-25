package com.sparta.jk.bean;

import com.sparta.jk.entity.UserEntity;
import com.sparta.jk.service.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;

@Named
@RequestScoped
public class RegistrationBean {

    @Inject
    UserEntity userEntity;

    @Inject
    UserRepository userRepository;

    @Inject
    FacesContext facesContext;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String register(){
        UserEntity newUserEntity = new UserEntity();
        if(!validateNewUser(userEntity)){
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "User was not added because one or more inputs are not valid.", null));
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Each input must be of size of at least 2.", null));
            return "registration";
        } else {
            try{
                userRepository.getUserByUsername(userEntity.getUsername());
            }  catch (NoResultException | ArrayIndexOutOfBoundsException | NullPointerException e){
                newUserEntity.setUsername(userEntity.getUsername());
                newUserEntity.setPassword(userEntity.getPassword());
                newUserEntity.setFirstName(userEntity.getFirstName());
                newUserEntity.setLastName(userEntity.getLastName());
                newUserEntity.setRole(userEntity.getRole());
                userRepository.addUser(newUserEntity);
                return "registrationSuccess";
            }
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "User was not added because the user with the same username already exists", null));
            return "registration";
        }
    }

    private boolean validateNewUser(UserEntity user){
        return isFieldValid(user.getUsername()) &&
                isFieldValid(user.getPassword()) &&
                isFieldValid(user.getFirstName()) &&
                isFieldValid(user.getLastName());
    }

    private boolean isFieldValid(String fieldInput){
        return fieldInput.length() > 1;
    }

}
