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
import proyecto.domain.Mantenimiento;
import proyecto.domain.Mantenimiento;
import proyecto.domain.Sucursal;
import proyecto.repository.MantenimientoRepository;
@Service
@Scope("singleton")
public class MantenimientoServiceImpl implements MantenimientoService {

private static final Logger log=LoggerFactory.getLogger(MantenimientoServiceImpl.class);
	
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private MantenimientoRepository mantenimientoRepository;
	
	@Autowired
	private SucursalService sucursalService;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	
	
	

	public void validarMantenimientos(Mantenimiento mantenimiento) throws Exception{
		try {
			Set<ConstraintViolation<Mantenimiento>> constraintViolations = validator.validate(mantenimiento);
			if (constraintViolations.size()>0) {
				StringBuilder strMessage = new StringBuilder();
				for(ConstraintViolation<Mantenimiento> constraintViolation : constraintViolations) {
					throw new Exception(constraintViolation.getPropertyPath().toString()+" "+constraintViolation.getMessage());
					
					
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e);
		}
	}
	
	@Override
	@org.springframework.transaction.annotation.Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public Mantenimiento findById(Integer id) {
		return mantenimientoRepository.findById(id);
	}

	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void save(Mantenimiento mantenimiento) throws Exception {
		if(mantenimiento==null) {
			throw new Exception("Mantenimiento es nulo");	
		}
		validarMantenimientos(mantenimiento);
		Sucursal sucursal=sucursalService.findById(mantenimiento.getSucursal().getIdSucursal());
		Empleado empleado=empleadoService.findById(mantenimiento.getEmpleado().getIdEmpleado());
		if(sucursal==null) {
			throw new Exception("sucursal es nulo");	
		}
		
		if(empleado==null) {
			throw new Exception("empleado es nulo");	
		}
		
		mantenimiento.setEmpleado(empleado);
		mantenimiento.setSucursal(sucursal);
		mantenimientoRepository.save(mantenimiento);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void update(Mantenimiento mantenimiento) throws Exception {
		if(mantenimiento==null) {
			throw new Exception("Mantenimiento es nulo");	
		}
		validarMantenimientos(mantenimiento);
		Sucursal sucursal=sucursalService.findById(mantenimiento.getSucursal().getIdSucursal());
		Empleado empleado=empleadoService.findById(mantenimiento.getEmpleado().getIdEmpleado());
		if(sucursal==null) {
			throw new Exception("sucursal es nulo");	
		}
		
		if(empleado==null) {
			throw new Exception("empleado es nulo");	
		}
		
		mantenimiento.setEmpleado(empleado);
		mantenimiento.setSucursal(sucursal);
		mantenimientoRepository.update(mantenimiento);

	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void delete(Mantenimiento mantenimiento) throws Exception {
		if(mantenimiento==null) {
			throw new Exception("Mantenimiento es nulo");	
		}
		Mantenimiento entityRemove=findById(mantenimiento.getIdMantenimiento());
		
		mantenimientoRepository.delete(entityRemove);


	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<Mantenimiento> findAll() {
		return mantenimientoRepository.findAll();
	}

}
