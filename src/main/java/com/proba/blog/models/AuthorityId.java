package com.proba.blog.models;

import java.io.Serializable;

public class AuthorityId implements Serializable {

    private String username;

    private String authority;

    public AuthorityId() {
    }

    public AuthorityId(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}