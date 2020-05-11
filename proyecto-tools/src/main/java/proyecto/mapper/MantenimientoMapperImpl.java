package proyecto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import proyecto.domain.Empleado;
import proyecto.domain.Mantenimiento;
import proyecto.domain.Mantenimiento;
import proyecto.domain.Sucursal;
import proyecto.dto.MantenimientoDTO;
import proyecto.dto.MantenimientoDTO;
import proyecto.servicio.EmpleadoService;
import proyecto.servicio.SucursalService;
@Component
@Scope("singleton")
public class MantenimientoMapperImpl implements MantenimientoMapper {
	@Autowired
	SucursalService sucursalService;
	
	@Autowired
	EmpleadoService empleadoService;
	
	@Override
	@Transactional(readOnly = true)
	public MantenimientoDTO mantenimientoToMantenimientoDTO(Mantenimiento mantenimiento) throws Exception {
		try {
            MantenimientoDTO mantenimientoDTO = new MantenimientoDTO();

            mantenimientoDTO.setIdMantenimiento(mantenimiento.getIdMantenimiento());
           
            mantenimientoDTO.setInsumos((mantenimiento.getInsumos() !=null)
            		? mantenimiento.getInsumos() : null);
            mantenimientoDTO.setIdEmpleado((mantenimiento.getEmpleado().getIdEmpleado() !=null)
            		? mantenimiento.getEmpleado().getIdEmpleado() : null);

            mantenimientoDTO.setIdSucursal((mantenimiento.getSucursal().getIdSucursal() !=null)
            		? mantenimiento.getSucursal().getIdSucursal() : null);

            
            
          

            return mantenimientoDTO;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public Mantenimiento mantenimientoDTOToMantenimiento(MantenimientoDTO mantenimientoDTO) throws Exception {
		try {
            Mantenimiento mantenimiento = new Mantenimiento();

            mantenimiento.setIdMantenimiento(mantenimientoDTO.getIdMantenimiento());
           
            mantenimiento.setInsumos((mantenimientoDTO.getInsumos() !=null)
            		? mantenimientoDTO.getInsumos() : null);
          
            Sucursal sucursal=new Sucursal();
            Empleado empleado =new Empleado();
           
           
            if (mantenimientoDTO.getIdSucursal() != null) {
                sucursal = sucursalService.findById(mantenimientoDTO.getIdSucursal());
            }
            if (mantenimientoDTO.getIdEmpleado() != null) {
                empleado = empleadoService.findById(mantenimientoDTO.getIdEmpleado());
            }

            if (sucursal != null) {
                mantenimiento.setSucursal(sucursal);
            }

            if (empleado != null) {
                mantenimiento.setEmpleado(empleado);
            }
            return mantenimiento;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<MantenimientoDTO> listMantenimientoToListMantenimientoDTO(List<Mantenimiento> listMantenimiento) throws Exception {
		try {
            List<MantenimientoDTO> mantenimientoDTOs = new ArrayList<MantenimientoDTO>();

            for (Mantenimiento mantenimiento : listMantenimiento) {
            	MantenimientoDTO mantenimientoDTO = mantenimientoToMantenimientoDTO(mantenimiento);

                mantenimientoDTOs.add(mantenimientoDTO);
            }

            return mantenimientoDTOs;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mantenimiento> listMantenimientoDTOToListMantenimiento(List<MantenimientoDTO> listMantenimientoDTO) throws Exception {
		try {
            List<Mantenimiento> listMantenimiento = new ArrayList<Mantenimiento>();

            for (MantenimientoDTO mantenimientoDTO : listMantenimientoDTO) {
                Mantenimiento mantenimiento = mantenimientoDTOToMantenimiento(mantenimientoDTO);

                listMantenimiento.add(mantenimiento);
            }

            return listMantenimiento;
        } catch (Exception e) {
            throw e;
        }
	}


}
