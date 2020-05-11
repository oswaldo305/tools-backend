package proyecto.repository;

import proyecto.domain.Empleado;
import java.util.List;
public interface EmpleadoRespository {

	public Empleado findById(Integer id);
	public void save(Empleado empleado);
	public void update(Empleado empleado);
	public void delete(Empleado empleado);
	public List<Empleado> findAll();
}
