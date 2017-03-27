package dbclasses;

import com.pastateam.dbinterface.IUtenti;
import com.pastateam.model.Azienda;
import com.pastateam.model.Utente;
import com.pastateam.utils.DatabaseConnection;
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
        ArrayList<Azienda> aziende = new ArrayList();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utente getUtenteFromEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer addUtente(String nome, String cognome, String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
