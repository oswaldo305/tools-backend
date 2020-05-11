package proyecto.dto;

public class UsuarioDTO {
	
	private String username;
	private String clave;
	private Integer idEmpleado;
	private Integer idTipoUsuario;
	
	public UsuarioDTO(String username, String clave, Integer idEmpleado, Integer idTipoUsuario) {
		super();
		this.username = username;
		this.clave = clave;
		this.idEmpleado = idEmpleado;
		this.idTipoUsuario = idTipoUsuario;
	}
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public Integer getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(Integer idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	
	

}
