package proyecto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import proyecto.domain.Empleado;
import proyecto.domain.Usuario;
import proyecto.domain.Sucursal;
import proyecto.domain.TipoUsuario;
import proyecto.domain.Usuario;
import proyecto.dto.EmpleadoDTO;
import proyecto.dto.UsuarioDTO;
import proyecto.dto.UsuarioDTO;
import proyecto.servicio.EmpleadoService;
import proyecto.servicio.SucursalService;
import proyecto.servicio.TipoUsuarioService;
@Component
@Scope("singleton")
public class UsuarioMapperImpl implements UsuarioMapper {
	@Autowired
	TipoUsuarioService tipoUsuarioService;
	
	@Autowired
	EmpleadoService empleadoService;
	
	@Override
	@Transactional(readOnly = true)
	public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) throws Exception {
		try {
            UsuarioDTO usuarioDTO = new UsuarioDTO();

            usuarioDTO.setUsername(usuario.getUsername());
           
            usuarioDTO.setClave((usuario.getClave() !=null)
            		? usuario.getClave() : null);
            usuarioDTO.setIdEmpleado((usuario.getEmpleado().getIdEmpleado() !=null)
            		? usuario.getEmpleado().getIdEmpleado() : null);

            usuarioDTO.setIdTipoUsuario((usuario.getTipoUsuario().getIdTipoUsuario() !=null)
            		? usuario.getTipoUsuario().getIdTipoUsuario() : null);

            
            
          

            return usuarioDTO;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO) throws Exception {
		try {
            Usuario usuario = new Usuario();

            usuario.setUsername(usuarioDTO.getUsername());
           
            usuario.setClave((usuarioDTO.getClave() !=null)
            		? usuarioDTO.getClave() : null);
          
            TipoUsuario tipoUsuario=new TipoUsuario();
            Empleado empleado =new Empleado();
           
           
            if (usuarioDTO.getIdTipoUsuario() != null) {
                tipoUsuario = tipoUsuarioService.findById(usuarioDTO.getIdTipoUsuario());
            }
            if (usuarioDTO.getIdEmpleado() != null) {
                empleado = empleadoService.findById(usuarioDTO.getIdEmpleado());
            }

            if (tipoUsuario != null) {
                usuario.setTipoUsuario(tipoUsuario);
            }

            if (empleado != null) {
                usuario.setEmpleado(empleado);
            }
            return usuario;
        } catch (Exception e) {
            throw e;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public List<UsuarioDTO> listUsuarioToListUsuarioDTO(List<Usuario> listUsuario) throws Exception {
		try {
            List<UsuarioDTO> usuarioDTOs = new ArrayList<UsuarioDTO>();

            for (Usuario usuario : listUsuario) {
            	UsuarioDTO usuarioDTO = usuarioToUsuarioDTO(usuario);

                usuarioDTOs.add(usuarioDTO);
            }

            return usuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
	}
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listUsuarioDTOToListUsuario(List<UsuarioDTO> listUsuarioDTO) throws Exception {
		try {
            List<Usuario> listUsuario = new ArrayList<Usuario>();

            for (UsuarioDTO usuarioDTO : listUsuarioDTO) {
                Usuario usuario = usuarioDTOToUsuario(usuarioDTO);

                listUsuario.add(usuario);
            }

            return listUsuario;
        } catch (Exception e) {
            throw e;
        }
	}
}
