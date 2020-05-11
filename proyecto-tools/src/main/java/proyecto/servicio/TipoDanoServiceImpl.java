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
import proyecto.domain.TipoDano;
import proyecto.domain.Sucursal;
import proyecto.domain.TipoDano;
import proyecto.repository.TipoDanoRepository;
@Service
@Scope("singleton")
public class TipoDanoServiceImpl implements TipoDanoService {
private static final Logger log=LoggerFactory.getLogger(TipoDanoServiceImpl.class);
	
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private TipoDanoRepository tipoDanoRepository;
	

	

	public void validarTipoDanos(TipoDano tipoDano) throws Exception{
		try {
			Set<ConstraintViolation<TipoDano>> constraintViolations = validator.validate(tipoDano);
			if (constraintViolations.size()>0) {
				StringBuilder strMessage = new StringBuilder();
				for(ConstraintViolation<TipoDano> constraintViolation : constraintViolations) {
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
	public TipoDano findById(Integer id) {
		return tipoDanoRepository.findById(id);
	}

	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void save(TipoDano tipoDano) throws Exception {
		if(tipoDano==null) {
			throw new Exception("TipoDano es nulo");	
		}
		validarTipoDanos(tipoDano);
		
		tipoDanoRepository.save(tipoDano);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void update(TipoDano tipoDano) throws Exception {
		if(tipoDano==null) {
			throw new Exception("TipoDano es nulo");	
		}
		validarTipoDanos(tipoDano);
		
		tipoDanoRepository.update(tipoDano);

	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void delete(TipoDano tipoDano) throws Exception {
		if(tipoDano==null) {
			throw new Exception("TipoDano es nulo");	
		}
		TipoDano entityRemove=findById(tipoDano.getIdTipoDano());
		
		tipoDanoRepository.delete(entityRemove);


	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<TipoDano> findAll() {
		return tipoDanoRepository.findAll();
	}


}
