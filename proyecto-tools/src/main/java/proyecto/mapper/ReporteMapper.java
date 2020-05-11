package proyecto.mapper;

import java.util.List;

import proyecto.domain.Reporte;
import proyecto.dto.ReporteDTO;

public interface ReporteMapper {


	 public ReporteDTO reporteToReporteDTO(Reporte reporte)throws Exception;

	 public Reporte reporteDTOToReporte(ReporteDTO reporteDTO)throws Exception;
	 
	 public List<ReporteDTO> listReporteToListReporteDTO(List<Reporte> reportes)throws Exception;

	 public List<Reporte> listReporteDTOToListReporte(List<ReporteDTO> reporteDTOs)throws Exception;
}
