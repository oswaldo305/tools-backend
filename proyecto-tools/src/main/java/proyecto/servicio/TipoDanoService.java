package proyecto.servicio;

import java.util.List;

import proyecto.domain.TipoDano;

public interface TipoDanoService {

	public TipoDano findById(Integer id);

	public void save(TipoDano tipoDano) throws Exception;

	public void update(TipoDano tipoDano) throws Exception;

	public void delete(TipoDano  tipoDano) throws Exception;


	public List<TipoDano> findAll();
}
