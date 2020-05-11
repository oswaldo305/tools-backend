package proyecto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import proyecto.domain.Empleado;
import proyecto.domain.Sucursal;
import proyecto.domain.Sucursal;
import proyecto.domain.TipoDano;
import proyecto.dto.SucursalDTO;
import proyecto.dto.SucursalDTO;
import proyecto.servicio.EmpleadoService;
import proyecto.servicio.SucursalService;
import proyecto.servicio.TipoDanoService;
@Component
@Scope("singleton")
public class SucursalMapperImpl implements SucursalMapper {


	
	
	@Override
	@Transactional(readOnly = true)
	public SucursalDTO sucursalToSucursalDTO(Sucursal sucursal) throws Exception {
		try {
            SucursalDTO sucursalDTO = new SucursalDTO();

            sucursalDTO.setIdSucursal(sucursal.getIdSucursal());
            
            sucursalDTO.setNombre((sucursal.getNombre() !=null)
            		? sucursal.getNombre() : null);
            
            sucursalDTO.setDireccion((sucursal.getDireccion() != null)
            		? sucursal.getDireccion() : null);
            
            sucursalDTO.setTelefono((sucursal.getTelefono() !=null)
            		? sucursal.getTelefono() : null);
            
           
  

            
            
          

            return sucursalDTO;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public Sucursal sucursalDTOToSucursal(SucursalDTO sucursalDTO) throws Exception {
		try {
            Sucursal sucursal = new Sucursal();

            sucursal.setIdSucursal(sucursalDTO.getIdSucursal());
            sucursal.setNombre((sucursalDTO.getNombre() !=null)
            		? sucursalDTO.getNombre() : null);
            
            sucursal.setDireccion((sucursalDTO.getDireccion() != null)
            		? sucursalDTO.getDireccion() : null);
            sucursal.setTelefono((sucursalDTO.getTelefono() !=null)
            		? sucursalDTO.getTelefono() : null);
            
            return sucursal;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<SucursalDTO> listSucursalToListSucursalDTO(List<Sucursal> listSucursal) throws Exception {
		try {
            List<SucursalDTO> sucursalDTOs = new ArrayList<SucursalDTO>();

            for (Sucursal sucursal : listSucursal) {
            	SucursalDTO sucursalDTO = sucursalToSucursalDTO(sucursal);

                sucursalDTOs.add(sucursalDTO);
            }

            return sucursalDTOs;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sucursal> listSucursalDTOToListSucursal(List<SucursalDTO> listSucursalDTO) throws Exception {
		try {
            List<Sucursal> listSucursal = new ArrayList<Sucursal>();

            for (SucursalDTO sucursalDTO : listSucursalDTO) {
                Sucursal sucursal = sucursalDTOToSucursal(sucursalDTO);

                listSucursal.add(sucursal);
            }

            return listSucursal;
        } catch (Exception e) {
            throw e;
        }
	}

}
