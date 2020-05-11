package proyecto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import proyecto.domain.TipoUsuario;
import proyecto.domain.TipoUsuario;
import proyecto.dto.TipoUsuarioDTO;
import proyecto.dto.TipoUsuarioDTO;
import proyecto.servicio.SucursalService;
@Component
@Scope("singleton")
public class TipoUsuarioMapperImpl implements TipoUsuarioMapper {
	@Autowired
	SucursalService sucursalService;
	
	@Override
	@Transactional(readOnly = true)
	public TipoUsuarioDTO tipoUsuarioToTipoUsuarioDTO(TipoUsuario tipoUsuario) throws Exception {
		try {
            TipoUsuarioDTO tipoUsuarioDTO = new TipoUsuarioDTO();

            tipoUsuarioDTO.setIdTipoUsuario(tipoUsuario.getIdTipoUsuario());
           
    

            tipoUsuarioDTO.setNombre((tipoUsuario.getNombre() !=null)
            		? tipoUsuario.getNombre() : null);
  
            
          

            return tipoUsuarioDTO;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public TipoUsuario tipoUsuarioDTOToTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) throws Exception {
		try {
            TipoUsuario tipoUsuario = new TipoUsuario();

            tipoUsuario.setIdTipoUsuario(tipoUsuarioDTO.getIdTipoUsuario());
           

            tipoUsuario.setNombre((tipoUsuarioDTO.getNombre() !=null)
            		? tipoUsuarioDTO.getNombre() : null);
            


            return tipoUsuario;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoUsuarioDTO> listTipoUsuarioToListTipoUsuarioDTO(List<TipoUsuario> listTipoUsuario) throws Exception {
		try {
            List<TipoUsuarioDTO> tipoUsuarioDTOs = new ArrayList<TipoUsuarioDTO>();

            for (TipoUsuario tipoUsuario : listTipoUsuario) {
            	TipoUsuarioDTO tipoUsuarioDTO = tipoUsuarioToTipoUsuarioDTO(tipoUsuario);

                tipoUsuarioDTOs.add(tipoUsuarioDTO);
            }

            return tipoUsuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoUsuario> listTipoUsuarioDTOToListTipoUsuario(List<TipoUsuarioDTO> listTipoUsuarioDTO) throws Exception {
		try {
            List<TipoUsuario> listTipoUsuario = new ArrayList<TipoUsuario>();

            for (TipoUsuarioDTO tipoUsuarioDTO : listTipoUsuarioDTO) {
                TipoUsuario tipoUsuario = tipoUsuarioDTOToTipoUsuario(tipoUsuarioDTO);

                listTipoUsuario.add(tipoUsuario);
            }

            return listTipoUsuario;
        } catch (Exception e) {
            throw e;
        }
	}


}
