package com.pastateam.dbinterface;

import com.pastateam.model.Utente;

import java.util.List;

public interface IUtenti {
    public List<Utente> getListaUtenti();
    public Utente getUtenteFromID(Integer ID);
    public Utente getUtenteFromEmail(String email);
}
