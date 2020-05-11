package proyecto.repository;

import java.util.List;

import proyecto.domain.TipoUsuario;
import proyecto.domain.Usuario;

public interface UsuarioRepository {

	public Usuario findById(String user);
	public void save(Usuario usuario);
	public void update(Usuario usuario);
	public void delete(Usuario usuario);
	public List<Usuario> findAll();
}
