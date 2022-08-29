package com.example.Shop.form;

import com.example.Shop.entity.UserEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForm {

    @NotNull
    @Size(min=2, max=30)
    String username;
    @NotNull
    @Size(min=5, max=30)
    String password;

    public static UserEntity toEntity(UserForm form) {
        UserEntity entity = new UserEntity();
        entity.setUsername(form.getUsername());
        entity.setPassword(entity.getPassword());
        return entity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "User(Name: " + this.username + ", Password: " + this.password + ")";
    }
}
