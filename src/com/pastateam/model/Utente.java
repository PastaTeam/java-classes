package com.pastateam.model;

import com.pastateam.utils.SHA1;

public class Utente {
    private Integer ID;
    private String email;
    private String nome;
    private String cognome;
    private String password_hash;

    public Utente(int id, String email, String nome, String cognome, String password_hash) {
        ID = id;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.password_hash = password_hash;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public Integer getID() {
        return ID;
    }

    public boolean checkPassword (String password) {
        return SHA1.hash(password).equals(password_hash);
    }
}
