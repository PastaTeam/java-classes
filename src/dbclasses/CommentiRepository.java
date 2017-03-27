/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbclasses;

import com.pastateam.dbinterface.ICommenti;
import com.pastateam.model.Commento;
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
public class CommentiRepository implements ICommenti{

    @Override
    public List<Commento> getCommentiForProdotto(Integer ID_Prodotto) {
      Connection conn = DatabaseConnection.getConnection();
      PreparedStatement stmt;
      ArrayList<Commento>  commento = new ArrayList();
      try{
         String sql = "SELECT * FROM commenti WHERE prodotto = ?";
         stmt = conn.prepareStatement(sql);
         stmt.setInt(1, ID_Prodotto);
         ResultSet rs = stmt.executeQuery();
         if(rs.next()){
             commento.add(new Commento (rs.getInt("ID"), rs.getString("commento"), rs.getDate("timestamp"), rs.getInt("prodotto"), rs.getInt("utente")));
         }
         else{
             rs.close();
         }
      }
      catch(SQLException e){
          e.printStackTrace();
      }
      return commento;
    }

    @Override
    public Commento getCommentoFromID(Integer ID) {
      Connection conn = DatabaseConnection.getConnection();
      PreparedStatement stmt;
      Commento  commento = null;
      try{
         String sql = "SELECT * FROM commenti WHERE ID = ?";
         stmt = conn.prepareStatement(sql);
         stmt.setInt(1, ID);
         ResultSet rs = stmt.executeQuery();
         if(rs.next()){
             commento = (new Commento (rs.getInt("ID"), rs.getString("commento"), rs.getDate("timestamp"), rs.getInt("prodotto"), rs.getInt("utente")));
         }
         else{
             rs.close();
         }
      }
      catch(SQLException e){
          e.printStackTrace();
      }
      return commento;
    }
 }
    
