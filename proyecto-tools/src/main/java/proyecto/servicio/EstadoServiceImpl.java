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

import proyecto.domain.Estado;
import proyecto.domain.Estado;
import proyecto.domain.Sucursal;
import proyecto.repository.EstadoRepository;

@Service
@Scope("singleton")
public class EstadoServiceImpl implements EstadoService {
private static final Logger log=LoggerFactory.getLogger(EstadoServiceImpl.class);
	
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private EstadoRepository estadoRepository;
	

	
	

	public void validarEstados(Estado estado) throws Exception{
		try {
			Set<ConstraintViolation<Estado>> constraintViolations = validator.validate(estado);
			if (constraintViolations.size()>0) {
				StringBuilder strMessage = new StringBuilder();
				for(ConstraintViolation<Estado> constraintViolation : constraintViolations) {
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
	public Estado findById(Integer id) {
		return estadoRepository.findById(id);
	}

	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void save(Estado estado) throws Exception {
		if(estado==null) {
			throw new Exception("Estado es nulo");	
		}
		validarEstados(estado);
		
		estadoRepository.save(estado);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void update(Estado estado) throws Exception {
		if(estado==null) {
			throw new Exception("Estado es nulo");	
		}
		validarEstados(estado);
		
		estadoRepository.update(estado);

	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void delete(Estado estado) throws Exception {
		if(estado==null) {
			throw new Exception("Estado es nulo");	
		}
		Estado entityRemove=findById(estado.getIdEstado());
		
		estadoRepository.delete(entityRemove);


	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<Estado> findAll() {
		return estadoRepository.findAll();
	}

}
