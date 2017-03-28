/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbclasses;

import com.pastateam.dbinterface.IProdotti;
import com.pastateam.model.Prodotto;
import com.pastateam.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FVD
 */
public class ProdottiRepository implements IProdotti{

    @Override
    public List<Prodotto> getListaProdotti() {
      Connection conn = DatabaseConnection.getConnection();
      Statement stmt;   
      ArrayList<Prodotto> prodotti = new ArrayList();
      try{
          stmt = conn.createStatement();
          String sql = "SELECT * FROM prodotti";
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              prodotti.add(new Prodotto(rs.getInt("ID"), rs.getString("nome"), rs.getString("descrizione"), rs.getInt("azienda")));
          }
      }
      catch(SQLException e){
          e.printStackTrace();
      }
      return prodotti;
    }

    @Override
    public List<Prodotto> getListaProdottiAzienda(Integer ID_Azienda) {
      Connection conn = DatabaseConnection.getConnection();
      PreparedStatement stmt;  
      ArrayList<Prodotto> prodotti = new ArrayList();
      try{
         String sql = "SELECT * FROM prodotti WHERE azienda = ?";
         stmt = conn.prepareStatement(sql);
         stmt.setInt(1, ID_Azienda);
         ResultSet rs = stmt.executeQuery();
         while(rs.next()){
             prodotti.add(new Prodotto (rs.getInt("ID"), rs.getString("nome"), rs.getString("descrizione"), rs.getInt("azienda")));
         }
      }
      catch(SQLException e){
          e.printStackTrace();
      }
        return prodotti;
    }

    @Override
    public Prodotto getProdottoFromID(Integer ID) {
      Connection conn = DatabaseConnection.getConnection();
      PreparedStatement stmt;  
      Prodotto prodotto = null;
      try{
         String sql = "SELECT * FROM prodotti WHERE ID = ?";
         stmt = conn.prepareStatement(sql);
         stmt.setInt(1, ID);
         ResultSet rs = stmt.executeQuery();
         while(rs.next()){
             prodotto = (new Prodotto (rs.getInt("ID"), rs.getString("nome"), rs.getString("descrizione"), rs.getInt("azienda")));
         }
      }
      catch(SQLException e){
          e.printStackTrace();
      }
        return prodotto;
    }

    /*aggiunge un prodotto al db, ritorna l'id del prodotto appena aggiunto*/
    @Override
    public Integer addProdotto(String nome, String descrizione, Integer azienda) 
    {
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt;
            String sql = "INSERT INTO prodotti(nome,descrizione,azienda)\n" +
                         "VALUES (?,?,?)";
            stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,nome);
            stmt.setString(2,descrizione);
            stmt.setInt(3,azienda);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            Integer risultato = null;
            if (rs.next()){
                risultato=rs.getInt(1);
            }
            return risultato;
        } catch (SQLException ex) {
            return null;
        }
    }
}
    

