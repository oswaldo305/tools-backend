package proyecto.servicio;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import proyecto.domain.Empleado;
import proyecto.domain.Sucursal;
import proyecto.domain.TipoUsuario;
import proyecto.domain.Usuario;
import proyecto.domain.Usuario;
import proyecto.repository.UsuarioRepository;
@Service
@Scope("singleton")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private Validator validator;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private TipoUsuarioService tipoUsuarioService;
	
	
	

	public void validarUsuarios(Usuario usuario) throws Exception{
		try {
			Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);
			if (constraintViolations.size()>0) {
				StringBuilder strMessage = new StringBuilder();
				for(ConstraintViolation<Usuario> constraintViolation : constraintViolations) {
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
	public Usuario findById(String id) {
		return usuarioRepository.findById(id);
	}

	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void save(Usuario usuario) throws Exception {
		if(usuario==null) {
			throw new Exception("Usuario es nulo");	
		}
		validarUsuarios(usuario);
		Empleado empleado=empleadoService.findById(usuario.getEmpleado().getIdEmpleado());
		TipoUsuario tipoUsuario=tipoUsuarioService.findById(usuario.getTipoUsuario().getIdTipoUsuario());
		
		if(empleado==null) {
			throw new Exception("empleado es nulo");	
		}
		if(tipoUsuario==null) {
			throw new Exception("tipoUsuario es nulo");	
		}
		
		usuario.setEmpleado(empleado);
		usuario.setTipoUsuario(tipoUsuario);
		
		usuarioRepository.save(usuario);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void update(Usuario usuario) throws Exception {
		if(usuario==null) {
			throw new Exception("Usuario es nulo");	
		}
		validarUsuarios(usuario);
		Empleado empleado=empleadoService.findById(usuario.getEmpleado().getIdEmpleado());
		TipoUsuario tipoUsuario=tipoUsuarioService.findById(usuario.getTipoUsuario().getIdTipoUsuario());
		
		if(empleado==null) {
			throw new Exception("empleado es nulo");	
		}
		if(tipoUsuario==null) {
			throw new Exception("tipoUsuario es nulo");	
		}
		
		usuario.setEmpleado(empleado);
		usuario.setTipoUsuario(tipoUsuario);
		
		usuarioRepository.update(usuario);

	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void delete(Usuario usuario) throws Exception {
		if(usuario==null) {
			throw new Exception("Usuario es nulo");	
		}
		Usuario entityRemove=findById(usuario.getUsername());
		
		usuarioRepository.delete(entityRemove);


	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

}

