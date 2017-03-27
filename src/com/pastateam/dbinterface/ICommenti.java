package com.pastateam.dbinterface;

import com.pastateam.model.Commento;

import java.util.List;

public interface ICommenti {
    /**
     * Lista commenti per un prodotto oridinati per data (dal più recente al più vecchio)
     * @param ID_Prodotto prodotto
     * @return lista commenti
     */
    public List<Commento> getCommentiForProdotto(Integer ID_Prodotto);
    public Commento getCommentoFromID(Integer ID);
}
