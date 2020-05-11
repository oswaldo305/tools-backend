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
import proyecto.domain.TipoUsuario;
import proyecto.domain.Sucursal;
import proyecto.domain.TipoDano;
import proyecto.domain.TipoUsuario;
import proyecto.repository.TipoUsuarioRepository;
@Service
@Scope("singleton")
public class TipoUsuarioServiceImpl implements TipoUsuarioService {
private static final Logger log=LoggerFactory.getLogger(TipoUsuarioServiceImpl.class);
	
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;
	
	
	

	public void validarTipoUsuarios(TipoUsuario tipoUsuario) throws Exception{
		try {
			Set<ConstraintViolation<TipoUsuario>> constraintViolations = validator.validate(tipoUsuario);
			if (constraintViolations.size()>0) {
				StringBuilder strMessage = new StringBuilder();
				for(ConstraintViolation<TipoUsuario> constraintViolation : constraintViolations) {
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
	public TipoUsuario findById(Integer id) {
		return tipoUsuarioRepository.findById(id);
	}

	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void save(TipoUsuario tipoUsuario) throws Exception {
		if(tipoUsuario==null) {
			throw new Exception("TipoUsuario es nulo");	
		}
		validarTipoUsuarios(tipoUsuario);
		
		tipoUsuarioRepository.save(tipoUsuario);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void update(TipoUsuario tipoUsuario) throws Exception {
		if(tipoUsuario==null) {
			throw new Exception("TipoUsuario es nulo");	
		}
		validarTipoUsuarios(tipoUsuario);
		
		tipoUsuarioRepository.update(tipoUsuario);

	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void delete(TipoUsuario tipoUsuario) throws Exception {
		if(tipoUsuario==null) {
			throw new Exception("TipoUsuario es nulo");	
		}
		TipoUsuario entityRemove=findById(tipoUsuario.getIdTipoUsuario());
		
		tipoUsuarioRepository.delete(entityRemove);


	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<TipoUsuario> findAll() {
		return tipoUsuarioRepository.findAll();
	}

}
