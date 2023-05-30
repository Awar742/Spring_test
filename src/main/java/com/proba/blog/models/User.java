package com.proba.blog.models;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {


    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    private Long cart;
    private Long fav;
    private Long phone;
    private String password;
    @Id
    private String  username;

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






    public Long getCart() {
        return cart;
    }

    public void setCart(Long cart) {
        this.cart = cart;
    }

    public Long getFav() {
        return fav;
    }

    public void setFav(Long fav) {
        this.fav = fav;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getPasword() {
        return password;
    }

    public void setPasword(String password) {
        this.password = password;
    }


}
