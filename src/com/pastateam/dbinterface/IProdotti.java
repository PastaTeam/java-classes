package com.pastateam.dbinterface;

import com.pastateam.model.Prodotto;

import java.util.List;

public interface IProdotti {
    /**
     * Lista di tutti i prodotti
     * @return lista prodotti
     */

    public List<Prodotto> getListaProdotti();

    /**
     * Lista prodotti di un'azienda
     * @param ID_Azienda id dell'azienda
     * @return lista prodotti
     */

    public List<Prodotto> getListaProdottiAzienda(Integer ID_Azienda);
    public Prodotto getProdottoFromID(Integer ID);

    /**
     * Aggiunge un prodotto
     * @param nome nome del prodotto
     * @param descrizione descrizione
     * @param azienda azienda
     * @return null in caso di errore, altrimenti id del commento
     */

    public Integer addProdotto(String nome, String descrizione, Integer azienda);
}
