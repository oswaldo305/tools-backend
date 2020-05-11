package proyecto.repository;

import java.util.List;

import proyecto.domain.Sucursal;
import proyecto.domain.TipoDano;

public interface TipoDanoRepository {

	public TipoDano findById(Integer id);
	public void save(TipoDano tipoDano);
	public void update(TipoDano tipoDano);
	public void delete(TipoDano tipoDano);
	public List<TipoDano> findAll();

}
