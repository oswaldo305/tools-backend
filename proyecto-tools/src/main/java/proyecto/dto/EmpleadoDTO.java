package proyecto.dto;

public class EmpleadoDTO {
	
	private Integer idEmpleado;
	private String apellido;
	private String correo;
	private String nombre;
	private Integer telefono;
	private Integer idSucursal;
	public EmpleadoDTO(Integer idEmpleado, String apellido, String correo, String nombre, Integer telefono,
			Integer idSucursal) {
		super();
		this.idEmpleado = idEmpleado;
		this.apellido = apellido;
		this.correo = correo;
		this.nombre = nombre;
		this.telefono = telefono;
		this.idSucursal = idSucursal;
	}
	public EmpleadoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
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
	public Integer getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}
	
	

}
