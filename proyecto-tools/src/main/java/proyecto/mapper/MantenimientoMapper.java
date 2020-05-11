package proyecto.mapper;

import java.util.List;

import proyecto.domain.Mantenimiento;
import proyecto.dto.MantenimientoDTO;

public interface MantenimientoMapper {

	 public MantenimientoDTO mantenimientoToMantenimientoDTO(Mantenimiento mantenimiento)throws Exception;

	 public Mantenimiento mantenimientoDTOToMantenimiento(MantenimientoDTO mantenimientoDTO)throws Exception;
	 
	 public List<MantenimientoDTO> listMantenimientoToListMantenimientoDTO(List<Mantenimiento> mantenimientos)throws Exception;

	 public List<Mantenimiento> listMantenimientoDTOToListMantenimiento(List<MantenimientoDTO> mantenimientoDTOs)throws Exception;
}
