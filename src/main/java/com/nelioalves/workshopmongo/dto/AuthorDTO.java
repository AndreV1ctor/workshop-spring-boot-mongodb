package com.nelioalves.workshopmongo.dto;

import com.nelioalves.workshopmongo.domain.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    private String id;

    public AuthorDTO(){}

    public AuthorDTO(User obj) {
        id = obj.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
