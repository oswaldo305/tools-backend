package proyecto.mapper;

import java.util.List;

import proyecto.domain.Empleado;
import proyecto.dto.EmpleadoDTO;

public interface EmpleadoMapper {

	 public EmpleadoDTO empleadoToEmpleadoDTO(Empleado empleado)throws Exception;

	 public Empleado empleadoDTOToEmpleado(EmpleadoDTO empleadoDTO)throws Exception;
	 
	 public List<EmpleadoDTO> listEmpleadoToListEmpleadoDTO(List<Empleado> empleados)throws Exception;

	 public List<Empleado> listEmpleadoDTOToListEmpleado(List<EmpleadoDTO> empleadoDTOs)throws Exception;
}
