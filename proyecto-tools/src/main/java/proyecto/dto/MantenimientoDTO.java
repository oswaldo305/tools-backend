package proyecto.dto;

public class MantenimientoDTO {

	private Integer idMantenimiento;
	private String insumos;
	private Integer idEmpleado;
	private Integer idSucursal;
	public MantenimientoDTO(Integer idMantenimiento, String insumos, Integer idEmpleado, Integer idSucursal) {
		super();
		this.idMantenimiento = idMantenimiento;
		this.insumos = insumos;
		this.idEmpleado = idEmpleado;
		this.idSucursal = idSucursal;
	}
	public MantenimientoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdMantenimiento() {
		return idMantenimiento;
	}
	public void setIdMantenimiento(Integer idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}
	public String getInsumos() {
		return insumos;
	}
	public void setInsumos(String insumos) {
		this.insumos = insumos;
	}
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public Integer getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}
	
	
}
