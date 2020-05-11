package proyecto.repository;

import java.util.List;

import proyecto.domain.TipoDano;
import proyecto.domain.TipoUsuario;

public interface TipoUsuarioRepository {

	
	public TipoUsuario findById(Integer id);
	public void save(TipoUsuario tipoUsuario);
	public void update(TipoUsuario tipoUsuario);
	public void delete(TipoUsuario tipoUsuario);
	public List<TipoUsuario> findAll();
}
