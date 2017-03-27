package com.pastateam.dbinterface;

import com.pastateam.model.Azienda;

import java.util.List;

public interface IAziende {
    public List<Azienda> getListaAziende();
    public Azienda getAziendaFromID(Integer ID);
    public Azienda getAziendaFromEmail(String email);
}
