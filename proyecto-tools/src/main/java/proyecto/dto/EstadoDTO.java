package proyecto.dto;

public class EstadoDTO {

	private Integer idEstado;
	private String nombre;
	public EstadoDTO(Integer idEstado, String nombre) {
		super();
		this.idEstado = idEstado;
		this.nombre = nombre;
	}
	public EstadoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
