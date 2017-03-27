package com.pastateam.model;

import java.util.Date;

public class Commento {
    private Integer ID;
    private String commento;
    private Date date;

    private Integer ID_Prodotto;
    private Integer ID_Utente;

    public Commento(Integer ID, String commento, Date date, Integer ID_Prodotto, Integer ID_Utente) {
        this.ID = ID;
        this.commento = commento;
        this.date = date;
        this.ID_Prodotto = ID_Prodotto;
        this.ID_Utente = ID_Utente;
    }

    public Integer getID() {
        return ID;
    }

    public String getCommento() {
        return commento;
    }

    public Date getDate() {
        return date;
    }

    public Integer getID_Prodotto() {
        return ID_Prodotto;
    }

    public Integer getID_Utente() {
        return ID_Utente;
    }
}
