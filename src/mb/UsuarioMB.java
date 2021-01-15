package mb;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.Usuario;
import dao.Banco;
import model.ModelUsuario;

@ManagedBean(name = "UsuarioMB")
@ViewScoped
public class UsuarioMB {	
	
	private ArrayList<Usuario> usuarios;
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	@PostConstruct
	public void listar() {
		try {
			Banco con = new Banco();
			ModelUsuario modelUsuario = new ModelUsuario();
			this.usuarios = modelUsuario.getUsuarios(con);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
