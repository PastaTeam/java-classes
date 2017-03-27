package com.pastateam.model;

public class Prodotto {
    private Integer ID;
    private String nome;
    private String descrizione;
    private Integer ID_Azienda;

    public Prodotto(Integer ID, String nome, String descrizione, Integer id_azienda) {
        this.ID = ID;
        this.nome = nome;
        this.descrizione = descrizione;
        ID_Azienda = id_azienda;
    }

    public Integer getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Integer getID_Azienda() {
        return ID_Azienda;
    }
}
