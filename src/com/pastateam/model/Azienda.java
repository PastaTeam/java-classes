package com.pastateam.model;

import com.pastateam.utils.SHA1;

public class Azienda {
    private Integer ID;
    private String email;
    private String nome;
    private String password_hash;

    public Azienda(Integer ID, String email, String nome, String password_hash) {
        this.ID = ID;
        this.email = email;
        this.nome = nome;
        this.password_hash = password_hash;
    }

    public Integer getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public boolean checkPassword (String password) {
        return SHA1.hash(password).equals(password_hash);
    }
}
