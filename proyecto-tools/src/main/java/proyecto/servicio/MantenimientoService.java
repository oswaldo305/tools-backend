package proyecto.servicio;

import java.util.List;

import proyecto.domain.Mantenimiento;

public interface MantenimientoService {

	public Mantenimiento findById(Integer id);

	public void save(Mantenimiento mantenimiento) throws Exception;

	public void update(Mantenimiento mantenimiento) throws Exception;

	public void delete(Mantenimiento  mantenimiento) throws Exception;


	public List<Mantenimiento> findAll();
}
