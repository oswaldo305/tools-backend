package proyecto.servicio;

import java.util.List;

import proyecto.domain.Empleado;

public interface EmpleadoService {
	public Empleado findById(Integer id);

	public void save(Empleado empleado) throws Exception;

	public void update(Empleado empleado) throws Exception;

	public void delete(Empleado  empleado) throws Exception;


	public List<Empleado> findAll();
}
