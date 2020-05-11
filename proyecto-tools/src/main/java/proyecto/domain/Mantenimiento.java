package proyecto.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mantenimiento database table.
 * 
 */
@Entity
@NamedQuery(name="Mantenimiento.findAll", query="SELECT m FROM Mantenimiento m")
public class Mantenimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_mantenimiento")
	private Integer idMantenimiento;

	private String insumos;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="id_empleado")
	private Empleado empleado;

	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name="id_sucursal")
	private Sucursal sucursal;

	public Mantenimiento() {
	}

	public Integer getIdMantenimiento() {
		return this.idMantenimiento;
	}

	public void setIdMantenimiento(Integer idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}

	public String getInsumos() {
		return this.insumos;
	}

	public void setInsumos(String insumos) {
		this.insumos = insumos;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

}