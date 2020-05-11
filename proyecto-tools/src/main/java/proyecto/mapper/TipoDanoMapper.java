package proyecto.mapper;

import java.util.List;

import proyecto.domain.TipoDano;
import proyecto.dto.TipoDanoDTO;

public interface TipoDanoMapper {


	 public TipoDanoDTO tipoDanoToTipoDanoDTO(TipoDano tipoDano)throws Exception;

	 public TipoDano tipoDanoDTOToTipoDano(TipoDanoDTO tipoDanoDTO)throws Exception;
	 
	 public List<TipoDanoDTO> listTipoDanoToListTipoDanoDTO(List<TipoDano> tipoDanos)throws Exception;

	 public List<TipoDano> listTipoDanoDTOToListTipoDano(List<TipoDanoDTO> tipoDanoDTOs)throws Exception;
}
