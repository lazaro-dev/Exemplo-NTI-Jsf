package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Usuario;
import dao.Banco;

public class ModelUsuario {
	

	public ArrayList<Usuario> getUsuarios(Banco con) {
			
			Usuario usuario;
			
			Connection conn = null;
			String sql = null;
			
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			
			try {
				
				conn = con.connection();
				if (conn != null) {
					
					sql = "SELECT * FROM USUARIO ASC ";
					PreparedStatement st = conn.prepareStatement(sql);
					
					ResultSet result = st.executeQuery();
					
					while(result.next()) {
						
						usuario = new Usuario();
						
						usuario.setId(result.getString("ID"));
						usuario.setNome(result.getString("NOME"));
						usuario.setIdade(result.getString("IDADE"));
						
						usuarios.add(usuario);
					}
					
					st.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return usuarios;
			
		}
}
