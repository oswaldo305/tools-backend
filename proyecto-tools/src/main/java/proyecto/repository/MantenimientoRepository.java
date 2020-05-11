package proyecto.repository;

import java.util.List;


import proyecto.domain.Mantenimiento;

public interface MantenimientoRepository {

	public Mantenimiento findById(Integer id);
	public void save(Mantenimiento mantenimiento);
	public void update(Mantenimiento mantenimiento);
	public void delete(Mantenimiento mantenimiento);
	public List<Mantenimiento> findAll();
}
