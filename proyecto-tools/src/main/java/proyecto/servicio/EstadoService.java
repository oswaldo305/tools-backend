package proyecto.servicio;

import java.util.List;

import proyecto.domain.Estado;

public interface EstadoService {

	public Estado findById(Integer id);

	public void save(Estado estado) throws Exception;

	public void update(Estado estado) throws Exception;

	public void delete(Estado  estado) throws Exception;


	public List<Estado> findAll();
}
