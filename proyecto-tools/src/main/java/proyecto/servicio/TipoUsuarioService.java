package proyecto.servicio;

import java.util.List;

import proyecto.domain.TipoUsuario;

public interface TipoUsuarioService {

	public TipoUsuario findById(Integer id);

	public void save(TipoUsuario tipoUsuario) throws Exception;

	public void update(TipoUsuario tipoUsuario) throws Exception;

	public void delete(TipoUsuario  tipoUsuario) throws Exception;


	public List<TipoUsuario> findAll();
}
