package proyecto.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sucursal database table.
 * 
 */
@Entity
@NamedQuery(name="Sucursal.findAll", query="SELECT s FROM Sucursal s")
public class Sucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sucursal")
	private Integer idSucursal;

	private String direccion;

	private String nombre;

	private Integer telefono;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="sucursal")
	private List<Empleado> empleados;

	//bi-directional many-to-one association to Mantenimiento
	@OneToMany(mappedBy="sucursal")
	private List<Mantenimiento> mantenimientos;

	//bi-directional many-to-one association to Maquinaria
	@OneToMany(mappedBy="sucursal")
	private List<Maquinaria> maquinarias;

	//bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="sucursal")
	private List<Reporte> reportes;

	public Sucursal() {
	}

	public Integer getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setSucursal(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setSucursal(null);

		return empleado;
	}

	public List<Mantenimiento> getMantenimientos() {
		return this.mantenimientos;
	}

	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	public Mantenimiento addMantenimiento(Mantenimiento mantenimiento) {
		getMantenimientos().add(mantenimiento);
		mantenimiento.setSucursal(this);

		return mantenimiento;
	}

	public Mantenimiento removeMantenimiento(Mantenimiento mantenimiento) {
		getMantenimientos().remove(mantenimiento);
		mantenimiento.setSucursal(null);

		return mantenimiento;
	}

	public List<Maquinaria> getMaquinarias() {
		return this.maquinarias;
	}

	public void setMaquinarias(List<Maquinaria> maquinarias) {
		this.maquinarias = maquinarias;
	}

	public Maquinaria addMaquinaria(Maquinaria maquinaria) {
		getMaquinarias().add(maquinaria);
		maquinaria.setSucursal(this);

		return maquinaria;
	}

	public Maquinaria removeMaquinaria(Maquinaria maquinaria) {
		getMaquinarias().remove(maquinaria);
		maquinaria.setSucursal(null);

		return maquinaria;
	}

	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Reporte addReporte(Reporte reporte) {
		getReportes().add(reporte);
		reporte.setSucursal(this);

		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setSucursal(null);

		return reporte;
	}

}