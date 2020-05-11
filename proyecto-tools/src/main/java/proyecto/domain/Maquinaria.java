package proyecto.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the maquinaria database table.
 * 
 */
@Entity
@NamedQuery(name="Maquinaria.findAll", query="SELECT m FROM Maquinaria m")
public class Maquinaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_maquinaria")
	private Integer idMaquinaria;

	private String detalle;

	@Column(name="nombre_maquina")
	private String nombreMaquina;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado estado;

	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name="id_sucursal")
	private Sucursal sucursal;

	public Maquinaria() {
	}

	public Integer getIdMaquinaria() {
		return this.idMaquinaria;
	}

	public void setIdMaquinaria(Integer idMaquinaria) {
		this.idMaquinaria = idMaquinaria;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getNombreMaquina() {
		return this.nombreMaquina;
	}

	public void setNombreMaquina(String nombreMaquina) {
		this.nombreMaquina = nombreMaquina;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

}