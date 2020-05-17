package proyecto.dto;

import java.util.Date;

public class ReporteDTO {

	private Integer idReporte;
	private Date fechaCita;
	private Date fechaReporte;
	private Integer idEmpleado;
	private Integer idSucursal;
	private Integer idMaquina;
	private Integer idTipoDano;
	
	public ReporteDTO(Integer idReporte, Date fechaCita, Date fechaReporte, Integer idEmpleado,
			Integer idSucursal, Integer idMaquina, Integer idTipoDano) {
		super();
		this.idReporte = idReporte;
		this.fechaCita = fechaCita;
		this.fechaReporte = fechaReporte;
		this.idEmpleado = idEmpleado;
		this.idSucursal = idSucursal;
		this.idMaquina=idMaquina;
		this.idTipoDano = idTipoDano;
	}
	public ReporteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(Integer idReporte) {
		this.idReporte = idReporte;
	}
	public Date getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}
	public Date getFechaReporte() {
		return fechaReporte;
	}
	public void setFechaReporte(Date fechaReporte) {
		this.fechaReporte = fechaReporte;
	}

	public Integer getIdMaquina() {
		return idMaquina;
	}
	public void setIdMaquina(Integer idMaquina) {
		this.idMaquina = idMaquina;
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
	public Integer getIdTipoDano() {
		return idTipoDano;
	}
	public void setIdTipoDano(Integer idTipoDano) {
		this.idTipoDano = idTipoDano;
	}
	
	
}
