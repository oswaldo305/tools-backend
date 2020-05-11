package proyecto.servicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import proyecto.domain.Usuario;



@Service
@Scope("singleton")
public class LoginServiceImpl implements LoginService {

	private static final Logger log=LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	UsuarioService usuarioService;
	
	@Override
	public boolean login(String usuario, String clave) throws Exception {
		
		Usuario user;

		if (usuario==null) {
			throw new Exception("El usuario es nulo");

		}

		if (usuario.trim().isEmpty()) {
			throw new Exception("Usuario vacio");
		}

		if (clave == null) {
			throw new Exception("La clave es nula");
		}

		if (clave.trim().isEmpty()) {
			throw new Exception("clave Con Espacios");
		}

	

		user=usuarioService.findById(usuario);


		if (!user.getUsername().equals(usuario)) {
			throw new Exception("Usuario Erroneo");
		}

		if (!user.getClave().equals(clave)) {
			throw new Exception("Clave Erronea");
		}

		

		return true;

	}

}
