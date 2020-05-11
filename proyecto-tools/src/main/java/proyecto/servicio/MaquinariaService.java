package proyecto.servicio;

import java.util.List;

import proyecto.domain.Maquinaria;

public interface MaquinariaService {

	
	public Maquinaria findById(Integer id);

	public void save(Maquinaria maquinaria) throws Exception;

	public void update(Maquinaria maquinaria) throws Exception;

	public void delete(Maquinaria  maquinaria) throws Exception;


	public List<Maquinaria> findAll();
}
