package proyecto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import proyecto.domain.Estado;
import proyecto.domain.Estado;
import proyecto.domain.Sucursal;
import proyecto.dto.EstadoDTO;
import proyecto.dto.EstadoDTO;
import proyecto.servicio.SucursalService;
@Component
@Scope("singleton")
public class EstadoMapperImpl implements EstadoMapper {

	@Autowired
	SucursalService sucursalService;
	
	@Override
	@Transactional(readOnly = true)
	public EstadoDTO estadoToEstadoDTO(Estado estado) throws Exception {
		try {
            EstadoDTO estadoDTO = new EstadoDTO();

            estadoDTO.setIdEstado(estado.getIdEstado());
           
    

            estadoDTO.setNombre((estado.getNombre() !=null)
            		? estado.getNombre() : null);
  
            
          

            return estadoDTO;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public Estado estadoDTOToEstado(EstadoDTO estadoDTO) throws Exception {
		try {
            Estado estado = new Estado();

            estado.setIdEstado(estadoDTO.getIdEstado());
           

            estado.setNombre((estadoDTO.getNombre() !=null)
            		? estadoDTO.getNombre() : null);
            


            return estado;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<EstadoDTO> listEstadoToListEstadoDTO(List<Estado> listEstado) throws Exception {
		try {
            List<EstadoDTO> estadoDTOs = new ArrayList<EstadoDTO>();

            for (Estado estado : listEstado) {
            	EstadoDTO estadoDTO = estadoToEstadoDTO(estado);

                estadoDTOs.add(estadoDTO);
            }

            return estadoDTOs;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<Estado> listEstadoDTOToListEstado(List<EstadoDTO> listEstadoDTO) throws Exception {
		try {
            List<Estado> listEstado = new ArrayList<Estado>();

            for (EstadoDTO estadoDTO : listEstadoDTO) {
                Estado estado = estadoDTOToEstado(estadoDTO);

                listEstado.add(estado);
            }

            return listEstado;
        } catch (Exception e) {
            throw e;
        }
	}

}
