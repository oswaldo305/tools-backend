package proyecto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import proyecto.domain.Empleado;
import proyecto.domain.Sucursal;
import proyecto.dto.EmpleadoDTO;
import proyecto.servicio.SucursalService;
@Component
@Scope("singleton")
public class EmpleadoMapperImpl implements EmpleadoMapper {

	@Autowired
	SucursalService sucursalService;
	
	@Override
	@Transactional(readOnly = true)
	public EmpleadoDTO empleadoToEmpleadoDTO(Empleado empleado) throws Exception {
		try {
            EmpleadoDTO empleadoDTO = new EmpleadoDTO();

            empleadoDTO.setIdEmpleado(empleado.getIdEmpleado());
           
            empleadoDTO.setApellido((empleado.getApellido() !=null)
            		? empleado.getApellido() : null);
            empleadoDTO.setCorreo((empleado.getCorreo() !=null)
            		? empleado.getCorreo() : null);
            empleadoDTO.setNombre((empleado.getNombre() !=null)
            		? empleado.getNombre() : null);
            empleadoDTO.setIdSucursal((empleado.getSucursal().getIdSucursal() !=null)
            		? empleado.getSucursal().getIdSucursal() : null);
            empleadoDTO.setTelefono((empleado.getTelefono() !=0)
            		? empleado.getTelefono()  : null);
            
            
          

            return empleadoDTO;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado empleadoDTOToEmpleado(EmpleadoDTO empleadoDTO) throws Exception {
		try {
            Empleado empleado = new Empleado();

            empleado.setIdEmpleado(empleadoDTO.getIdEmpleado());
           
            empleado.setApellido((empleadoDTO.getApellido() !=null)
            		? empleadoDTO.getApellido() : null);
            empleado.setCorreo((empleadoDTO.getCorreo() !=null)
            		? empleadoDTO.getCorreo() : null);
            empleado.setNombre((empleadoDTO.getNombre() !=null)
            		? empleadoDTO.getNombre() : null);
            
            empleado.setTelefono((empleadoDTO.getTelefono() !=0)
            		? empleadoDTO.getTelefono()  : null);
            Sucursal sucursal=new Sucursal();
           
           
            if (empleadoDTO.getIdSucursal() != null) {
                sucursal = sucursalService.findById(empleadoDTO.getIdSucursal());
            }

            if (sucursal != null) {
                empleado.setSucursal(sucursal);
            }

            return empleado;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmpleadoDTO> listEmpleadoToListEmpleadoDTO(List<Empleado> listEmpleado) throws Exception {
		try {
            List<EmpleadoDTO> empleadoDTOs = new ArrayList<EmpleadoDTO>();

            for (Empleado empleado : listEmpleado) {
            	EmpleadoDTO empleadoDTO = empleadoToEmpleadoDTO(empleado);

                empleadoDTOs.add(empleadoDTO);
            }

            return empleadoDTOs;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> listEmpleadoDTOToListEmpleado(List<EmpleadoDTO> listEmpleadoDTO) throws Exception {
		try {
            List<Empleado> listEmpleado = new ArrayList<Empleado>();

            for (EmpleadoDTO empleadoDTO : listEmpleadoDTO) {
                Empleado empleado = empleadoDTOToEmpleado(empleadoDTO);

                listEmpleado.add(empleado);
            }

            return listEmpleado;
        } catch (Exception e) {
            throw e;
        }
	}

}
