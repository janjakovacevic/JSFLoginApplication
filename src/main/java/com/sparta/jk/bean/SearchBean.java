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
public class SearchBean {

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

    public String findUserByID(){
        try {
            userEntity = userRepository.getUserByID(userEntity.getUserId());
            return "searchSuccess";
        } catch (NoResultException | NullPointerException e){
            userEntity = null;
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User was not found", null));
            return "search";
        }
    }

    public String findUserByUsername(){
        try {
            userEntity = userRepository.getUserByUsername(userEntity.getUsername());
            return "searchSuccess";
        } catch (NoResultException | ArrayIndexOutOfBoundsException | NullPointerException e){
            userEntity = null;
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User was not found", null));
            return "search";
        }

    }

}
