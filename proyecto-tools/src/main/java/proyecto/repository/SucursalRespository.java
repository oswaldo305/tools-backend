package proyecto.repository;

import java.util.List;

import proyecto.domain.Reporte;
import proyecto.domain.Sucursal;

public interface SucursalRespository {

	public Sucursal findById(Integer id);
	public void save(Sucursal sucursal);
	public void update(Sucursal Sucursal);
	public void delete(Sucursal Sucursal);
	public List<Sucursal> findAll();

}
