package proyecto.mapper;

import java.util.List;

import proyecto.domain.Usuario;
import proyecto.dto.UsuarioDTO;

public interface UsuarioMapper {


	 public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario)throws Exception;

	 public Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO)throws Exception;
	 
	 public List<UsuarioDTO> listUsuarioToListUsuarioDTO(List<Usuario> usuarios)throws Exception;

	 public List<Usuario> listUsuarioDTOToListUsuario(List<UsuarioDTO> usuarioDTOs)throws Exception;
}
