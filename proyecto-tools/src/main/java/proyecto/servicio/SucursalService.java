package proyecto.servicio;

import java.util.List;

import proyecto.domain.Sucursal;

public interface SucursalService {

	public Sucursal findById(Integer id);

	public void save(Sucursal sucursal) throws Exception;

	public void update(Sucursal sucursal) throws Exception;

	public void delete(Sucursal  sucursal) throws Exception;


	public List<Sucursal> findAll();
}
