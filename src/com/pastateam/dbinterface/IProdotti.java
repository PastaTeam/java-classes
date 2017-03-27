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
}
