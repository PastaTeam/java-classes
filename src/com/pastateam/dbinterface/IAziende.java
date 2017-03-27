package com.pastateam.dbinterface;

import com.pastateam.model.Azienda;

import java.util.List;

public interface IAziende {
    public List<Azienda> getListaAziende();
    public Azienda getAziendaFromID(Integer ID);
    public Azienda getAziendaFromEmail(String email);

    /**
     * Aggiunge un'azienda
     * @param nome nome dell'azienda
     * @param email email per il login
     * @param password hash della password (sha1)
     * @return null in caso di errore, altrimenti nuovo id dell'azienda
     */

    public Integer addAzienda(String nome, String email, String password);
}
