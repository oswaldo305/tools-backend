package proyecto.repository;

import java.util.List;

import proyecto.domain.Empleado;
import proyecto.domain.Estado;

public interface EstadoRepository {
	public Estado findById(Integer id);
	public void save(Estado estado);
	public void update(Estado estado);
	public void delete(Estado estado);
	public List<Estado> findAll();
}
