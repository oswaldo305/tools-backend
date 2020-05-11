package proyecto.dto;

public class SucursalDTO {

	private Integer idSucursal;
	private String direccion;
	private String nombre;
	private Integer telefono;
	public SucursalDTO(Integer idSucursal, String direccion, String nombre, Integer telefono) {
		super();
		this.idSucursal = idSucursal;
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	public SucursalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
	
}
