package proyecto.servicio;

import java.util.List;

import proyecto.domain.Usuario;

public interface UsuarioService {

	public Usuario findById(String id);

	public void save(Usuario usuario) throws Exception;

	public void update(Usuario usuario) throws Exception;

	public void delete(Usuario  usuario) throws Exception;


	public List<Usuario> findAll();
}
