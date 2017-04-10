package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnagrammaDAO {

	
	/**
	 * Tramite una query SQL permette di verificare se l’anagramma calcolato è presente nel dizionario
	 * @param anagramma
	 * @return
	 */
	public boolean isCorrect(String anagramma){
		return true;
	}
	public boolean cercaSeCoretto(String parola){
		
		final String sql = "SELECT nome "+
							"FROM parola "+
							"WHERE nome = ?";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, parola);

			ResultSet rs = st.executeQuery();
			boolean trovato = false;
			
			while (rs.next()) {
				
				trovato = true;
			}
			
			return trovato;
			}
			catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Errore Db");
			}
		}
}
