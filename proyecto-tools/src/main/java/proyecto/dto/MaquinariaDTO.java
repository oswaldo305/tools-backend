package proyecto.dto;

public class MaquinariaDTO {

	
	private Integer idMaquinaria;
	private String detalle;
	private String nombreMaquina;
	private Integer idEstado;
	private Integer idSucursal;
	
	public MaquinariaDTO(Integer idMaquinaria, String detalle, String nombreMaquina, Integer idEstado,
			Integer idSucursal) {
		super();
		this.idMaquinaria = idMaquinaria;
		this.detalle = detalle;
		this.nombreMaquina = nombreMaquina;
		this.idEstado = idEstado;
		this.idSucursal = idSucursal;
	}
	public MaquinariaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdMaquinaria() {
		return idMaquinaria;
	}
	public void setIdMaquinaria(Integer idMaquinaria) {
		this.idMaquinaria = idMaquinaria;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getNombreMaquina() {
		return nombreMaquina;
	}
	public void setNombreMaquina(String nombreMaquina) {
		this.nombreMaquina = nombreMaquina;
	}
	public Integer getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
	public Integer getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}
	
	
}
