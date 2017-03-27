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
}
    

