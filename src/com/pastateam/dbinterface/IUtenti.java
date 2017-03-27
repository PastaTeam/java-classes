package com.pastateam.dbinterface;

import com.pastateam.model.Utente;

import java.util.List;

public interface IUtenti {
    public List<Utente> getListaUtenti();
    public Utente getUtenteFromID(Integer ID);
    public Utente getUtenteFromEmail(String email);

    /**
     * Aggiunge un utente
     * @param nome nome della persona
     * @param cognome cognome della persona
     * @param email email per l'accesso
     * @param password password per l'accesso
     * @return null in caso di errore, altrimenti id del commento
     */

    public Integer addUtente(String nome, String cognome, String email, String password);
}
