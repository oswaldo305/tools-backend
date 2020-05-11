package proyecto.mapper;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import proyecto.domain.Sucursal;
import proyecto.dto.SucursalDTO;

public interface SucursalMapper {


	 public SucursalDTO sucursalToSucursalDTO(Sucursal sucursal)throws Exception;

	 public Sucursal sucursalDTOToSucursal(SucursalDTO sucursalDTO)throws Exception;
	 
	 public List<SucursalDTO> listSucursalToListSucursalDTO(List<Sucursal> sucursals)throws Exception;

	 public List<Sucursal> listSucursalDTOToListSucursal(List<SucursalDTO> sucursalDTOs)throws Exception;
}
