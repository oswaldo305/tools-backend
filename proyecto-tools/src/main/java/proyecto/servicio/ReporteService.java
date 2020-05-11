package proyecto.servicio;

import java.util.List;

import proyecto.domain.Reporte;

public interface ReporteService {

	public Reporte findById(Integer id);

	public void save(Reporte reporte) throws Exception;

	public void update(Reporte reporte) throws Exception;

	public void delete(Reporte  reporte) throws Exception;


	public List<Reporte> findAll();
}
