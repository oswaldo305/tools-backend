package proyecto.repository;

import java.util.List;

import proyecto.domain.Mantenimiento;
import proyecto.domain.Maquinaria;

public interface MaquinariaRepository {

	public Maquinaria findById(Integer id);
	public void save(Maquinaria maquinaria);
	public void update(Maquinaria maquinaria);
	public void delete(Maquinaria maquinaria);
	public List<Maquinaria> findAll();
}
