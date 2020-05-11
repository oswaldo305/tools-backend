package proyecto.mapper;

import java.util.List;

import proyecto.domain.Estado;
import proyecto.dto.EstadoDTO;

public interface EstadoMapper {


	 public EstadoDTO estadoToEstadoDTO(Estado estado)throws Exception;

	 public Estado estadoDTOToEstado(EstadoDTO estadoDTO)throws Exception;
	 
	 public List<EstadoDTO> listEstadoToListEstadoDTO(List<Estado> estados)throws Exception;

	 public List<Estado> listEstadoDTOToListEstado(List<EstadoDTO> estadoDTOs)throws Exception;
}
