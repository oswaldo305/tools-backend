package proyecto.mapper;

import java.util.List;

import proyecto.domain.Maquinaria;
import proyecto.dto.MaquinariaDTO;

public interface MaquinariaMapper {


	 public MaquinariaDTO maquinariaToMaquinariaDTO(Maquinaria maquinaria)throws Exception;

	 public Maquinaria maquinariaDTOToMaquinaria(MaquinariaDTO maquinariaDTO)throws Exception;
	 
	 public List<MaquinariaDTO> listMaquinariaToListMaquinariaDTO(List<Maquinaria> maquinarias)throws Exception;

	 public List<Maquinaria> listMaquinariaDTOToListMaquinaria(List<MaquinariaDTO> maquinariaDTOs)throws Exception;
}
