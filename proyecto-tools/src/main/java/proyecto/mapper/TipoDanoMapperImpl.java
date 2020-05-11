package proyecto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import proyecto.domain.TipoDano;
import proyecto.domain.TipoDano;
import proyecto.dto.TipoDanoDTO;
import proyecto.dto.TipoDanoDTO;
import proyecto.servicio.SucursalService;
@Component
@Scope("singleton")
public class TipoDanoMapperImpl implements TipoDanoMapper {

	@Autowired
	SucursalService sucursalService;
	
	@Override
	@Transactional(readOnly = true)
	public TipoDanoDTO tipoDanoToTipoDanoDTO(TipoDano tipoDano) throws Exception {
		try {
            TipoDanoDTO tipoDanoDTO = new TipoDanoDTO();

            tipoDanoDTO.setIdTipoDano(tipoDano.getIdTipoDano());
           
    

            tipoDanoDTO.setNombre((tipoDano.getNombre() !=null)
            		? tipoDano.getNombre() : null);
  
            
          

            return tipoDanoDTO;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public TipoDano tipoDanoDTOToTipoDano(TipoDanoDTO tipoDanoDTO) throws Exception {
		try {
            TipoDano tipoDano = new TipoDano();

            tipoDano.setIdTipoDano(tipoDanoDTO.getIdTipoDano());
           

            tipoDano.setNombre((tipoDanoDTO.getNombre() !=null)
            		? tipoDanoDTO.getNombre() : null);
            


            return tipoDano;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoDanoDTO> listTipoDanoToListTipoDanoDTO(List<TipoDano> listTipoDano) throws Exception {
		try {
            List<TipoDanoDTO> tipoDanoDTOs = new ArrayList<TipoDanoDTO>();

            for (TipoDano tipoDano : listTipoDano) {
            	TipoDanoDTO tipoDanoDTO = tipoDanoToTipoDanoDTO(tipoDano);

                tipoDanoDTOs.add(tipoDanoDTO);
            }

            return tipoDanoDTOs;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoDano> listTipoDanoDTOToListTipoDano(List<TipoDanoDTO> listTipoDanoDTO) throws Exception {
		try {
            List<TipoDano> listTipoDano = new ArrayList<TipoDano>();

            for (TipoDanoDTO tipoDanoDTO : listTipoDanoDTO) {
                TipoDano tipoDano = tipoDanoDTOToTipoDano(tipoDanoDTO);

                listTipoDano.add(tipoDano);
            }

            return listTipoDano;
        } catch (Exception e) {
            throw e;
        }
	}

}
