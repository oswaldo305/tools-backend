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
import proyecto.domain.Sucursal;
import proyecto.domain.TipoDano;
import proyecto.repository.SucursalRespository;;
@Service
@Scope("singleton")
public class SucursalServiceImpl implements SucursalService {
private static final Logger log=LoggerFactory.getLogger(SucursalServiceImpl.class);
	
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private SucursalRespository sucursalRepository;
	
	

	

	public void validarSucursals(Sucursal sucursal) throws Exception{
		try {
			Set<ConstraintViolation<Sucursal>> constraintViolations = validator.validate(sucursal);
			if (constraintViolations.size()>0) {
				StringBuilder strMessage = new StringBuilder();
				for(ConstraintViolation<Sucursal> constraintViolation : constraintViolations) {
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
	public Sucursal findById(Integer id) {
		return sucursalRepository.findById(id);
	}

	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void save(Sucursal sucursal) throws Exception {
		if(sucursal==null) {
			throw new Exception("Sucursal es nulo");	
		}
		validarSucursals(sucursal);
		
		sucursalRepository.save(sucursal);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void update(Sucursal sucursal) throws Exception {
		if(sucursal==null) {
			throw new Exception("Sucursal es nulo");	
		}
		validarSucursals(sucursal);
		
		sucursalRepository.update(sucursal);

	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void delete(Sucursal sucursal) throws Exception {
		if(sucursal==null) {
			throw new Exception("Sucursal es nulo");	
		}
		Sucursal entityRemove=findById(sucursal.getIdSucursal());
		
		sucursalRepository.delete(entityRemove);


	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<Sucursal> findAll() {
		return sucursalRepository.findAll();
	}


}
