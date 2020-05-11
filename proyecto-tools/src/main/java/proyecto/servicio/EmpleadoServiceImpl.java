package proyecto.servicio;

import java.util.List;
import java.util.Set;


import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import proyecto.domain.Empleado;
import proyecto.domain.Sucursal;
import proyecto.repository.EmpleadoRespository;
import proyecto.repository.SucursalRespository;
@Service
@Scope("singleton")
public class EmpleadoServiceImpl implements EmpleadoService {

	private static final Logger log=LoggerFactory.getLogger(EmpleadoServiceImpl.class);
	
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private EmpleadoRespository empleadoRepository;
	
	@Autowired
	private SucursalService sucursalService;
	
	

	public void validarEmpleados(Empleado empleado) throws Exception{
		try {
			Set<ConstraintViolation<Empleado>> constraintViolations = validator.validate(empleado);
			if (constraintViolations.size()>0) {
				StringBuilder strMessage = new StringBuilder();
				for(ConstraintViolation<Empleado> constraintViolation : constraintViolations) {
					throw new Exception(constraintViolation.getPropertyPath().toString()+" "+constraintViolation.getMessage());
					
					
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e);
		}
	}
	
	@Override
   @Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public Empleado findById(Integer id) {
		return empleadoRepository.findById(id);
	}

	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void save(Empleado empleado) throws Exception {
		if(empleado==null) {
			throw new Exception("Empleado es nulo");	
		}
		validarEmpleados(empleado);
		Sucursal sucursal=sucursalService.findById(empleado.getSucursal().getIdSucursal());
		if(sucursal==null) {
			throw new Exception("sucursal es nulo");	
		}
		
		empleado.setSucursal(sucursal);
		empleadoRepository.save(empleado);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void update(Empleado empleado) throws Exception {
		if(empleado==null) {
			throw new Exception("Empleado es nulo");	
		}
		validarEmpleados(empleado);
		Sucursal sucursal=sucursalService.findById(empleado.getSucursal().getIdSucursal());
		if(sucursal==null) {
			throw new Exception("sucursal es nulo");	
		}
		
		empleado.setSucursal(sucursal);
		empleadoRepository.update(empleado);

	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void delete(Empleado empleado) throws Exception {
		if(empleado==null) {
			throw new Exception("Empleado es nulo");	
		}
		Empleado entityRemove=findById(empleado.getIdEmpleado());
		
		empleadoRepository.delete(entityRemove);


	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<Empleado> findAll() {
		return empleadoRepository.findAll();
	}

}
