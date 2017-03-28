package dbclasses;

import com.pastateam.dbinterface.IUtenti;
import com.pastateam.model.Azienda;
import com.pastateam.model.Utente;
import com.pastateam.utils.DatabaseConnection;
import com.pastateam.utils.SHA1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UtentiRepository implements IUtenti{

    @Override
    public List<Utente> getListaUtenti() {
        ArrayList<Utente> lista = new ArrayList();
        Connection conn = DatabaseConnection.getConnection();
        Statement stmt;
        try{
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `utenti`";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                lista.add(new Utente(rs.getInt("ID"), rs.getString("email"), rs.getString("nome"), rs.getString("cognome"), rs.getString("password")));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return lista;    
    }

    @Override
    public Utente getUtenteFromID(Integer ID) {
        Utente temp = null;
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt;
        try{
            String sql = "SELECT * FROM `utenti` WHERE  ID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ID);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            temp = new Utente(rs.getInt("ID"), rs.getString("email"), rs.getString("nome"), rs.getString("cognome"), rs.getString("password"));
         }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public Utente getUtenteFromEmail(String email) {
        Utente temp = null;
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt;
        try{
            String sql = "SELECT * FROM `utenti` WHERE  email = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            temp = new Utente(rs.getInt("ID"), rs.getString("email"), rs.getString("nome"), rs.getString("cognome"), rs.getString("password"));
         }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public Integer addUtente(String nome, String cognome, String email, String password) {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt;
        int risultato = 0;
        try{
            String sql = "INSERT INTO `utenti`(`nome`, `cognome`, `email`, `password`) VALUES (?,?,?,?)";
            stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, email);
            stmt.setString(4, SHA1.hash(password));
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
            risultato = rs.getInt(1);}
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return risultato;
    }

}
