package proyecto.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reporte database table.
 * 
 */
@Entity
@NamedQuery(name="Reporte.findAll", query="SELECT r FROM Reporte r")
public class Reporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_reporte")
	private Integer idReporte;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cita")
	private Date fechaCita;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_reporte")
	private Date fechaReporte;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="id_empleado")
	private Empleado empleado;

	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name="id_sucursal")
	private Sucursal sucursal;

	//bi-directional many-to-one association to TipoDano
	@ManyToOne
	@JoinColumn(name="id_tipo_dano")
	private TipoDano tipoDano;

	public Reporte() {
	}

	public Integer getIdReporte() {
		return this.idReporte;
	}

	public void setIdReporte(Integer idReporte) {
		this.idReporte = idReporte;
	}

	public Date getFechaCita() {
		return this.fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public Date getFechaReporte() {
		return this.fechaReporte;
	}

	public void setFechaReporte(Date fechaReporte) {
		this.fechaReporte = fechaReporte;
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

	public TipoDano getTipoDano() {
		return this.tipoDano;
	}

	public void setTipoDano(TipoDano tipoDano) {
		this.tipoDano = tipoDano;
	}

}