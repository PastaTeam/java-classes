/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbclasses;

import com.pastateam.dbinterface.IAziende;
import com.pastateam.model.Azienda;
import com.pastateam.utils.DatabaseConnection;
import com.pastateam.utils.SHA1;
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
public class AziendaRepository implements IAziende{

    @Override
    public List<Azienda> getListaAziende() {
      Connection conn = DatabaseConnection.getConnection();
      Statement stmt;
      ArrayList<Azienda> aziende = new ArrayList();
      try{
          stmt = conn.createStatement();
          String sql = "SELECT * FROM `aziende`";
          ResultSet rs = stmt.executeQuery(sql);
          while (rs.next()){
              aziende.add(new Azienda(rs.getInt("ID"),rs.getString("email"), rs.getString("nome"), rs.getString("password") ));
          }
      }
      catch(SQLException e){
          e.printStackTrace();
      }
        return aziende;
    }

    @Override
    public Azienda getAziendaFromID(Integer ID) {
      Connection conn = DatabaseConnection.getConnection();
      PreparedStatement stmt;
      Azienda azienda = null;
      try{
          String sql = "SELECT * FROM aziende WHERE ID = ?";
          stmt = conn.prepareStatement(sql);
          stmt.setInt(1, ID);
          ResultSet rs = stmt.executeQuery();
          if(rs.next()){
              azienda = (new Azienda(rs.getInt("ID"),rs.getString("email"), rs.getString("nome"), rs.getString("password") ));
          }
          else{
              rs.close();
          }
      }
      catch(SQLException e){
          e.printStackTrace();
      }
      return azienda;
    }

    @Override
    public Azienda getAziendaFromEmail(String email) {
      Connection conn = DatabaseConnection.getConnection();
      PreparedStatement stmt;
      Azienda azienda = null;
      try{
          String sql = "SELECT * FROM aziende WHERE email = ?";
          stmt = conn.prepareStatement(sql);
          stmt.setString(1, email);
          ResultSet rs = stmt.executeQuery();
          if(rs.next()){
              azienda = (new Azienda(rs.getInt("ID"),rs.getString("email"), rs.getString("nome"), rs.getString("password") ));
          }
          else{
              rs.close();
          }
      }
      catch(SQLException e){
          e.printStackTrace();
      }
      return azienda;
    }

    @Override
    public Integer addAzienda(String nome, String email, String password) {
      Connection conn = DatabaseConnection.getConnection();
      PreparedStatement stmt; 
      int risultato = 0;
      try{
          String sql = "INSERT INTO aziende (email, nome, password) VALUES (?,?,?)";
          stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
          stmt.setString(1, email);
          stmt.setString(2, nome);
          stmt.setString(3, SHA1.hash(password));
          stmt.executeUpdate(); 
          ResultSet rs = stmt.getGeneratedKeys();
          if(rs.next()){
              risultato = rs.getInt(1);
          }
      }
      catch(SQLException e){
          return null;
      }
      return risultato;
    }

}
