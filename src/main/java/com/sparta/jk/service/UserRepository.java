package com.sparta.jk.service;

import com.sparta.jk.entity.UserEntity;

import javax.persistence.*;

import java.util.Collection;
import java.util.HashMap;

public class UserRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public HashMap<String, UserEntity> getAllUsersMap(){
        HashMap<String, UserEntity> users = new HashMap<>();
        for(UserEntity user : getAllUsers()){
            users.put(user.getUsername(), user);
        }
        return users;
    }

    public Collection<UserEntity> getAllUsers(){
            return entityManager.createNamedQuery("user.getAll", UserEntity.class).getResultList();
    }

    public UserEntity getUserByID(int id){
            return entityManager.createNamedQuery("user.getById", UserEntity.class).setParameter("id", id).getSingleResult();
    }

    public UserEntity getUserByUsername(String username){
        return entityManager.createNamedQuery("user.getByUsername", UserEntity.class).setParameter("username", username).getSingleResult();
    }

    public void addUser(UserEntity user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.flush();
        entityManager.refresh(user);
        entityManager.getTransaction().commit();
    }


    public void updatePermission(String role, UserEntity user){
        entityManager.getTransaction().begin();
        user.setRole(role);
        entityManager.flush();
        entityManager.refresh(user);
        entityManager.getTransaction().commit();
    }



}
