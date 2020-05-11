package proyecto.repository;

import java.util.List;

import proyecto.domain.Maquinaria;
import proyecto.domain.Reporte;

public interface ReporteRepository {

	public Reporte findById(Integer id);
	public void save(Reporte reporte);
	public void update(Reporte reporte);
	public void delete(Reporte reporte);
	public List<Reporte> findAll();
}
