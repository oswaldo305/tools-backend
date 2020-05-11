package proyecto.dto;

public class TipoUsuarioDTO {

	
	private Integer idTipoUsuario;
	private String nombre;
	public TipoUsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TipoUsuarioDTO(Integer idTipoUsuario, String nombre) {
		super();
		this.idTipoUsuario = idTipoUsuario;
		this.nombre = nombre;
	}
	public Integer getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(Integer idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
