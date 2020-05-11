package proyecto.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_dano database table.
 * 
 */
@Entity
@Table(name="tipo_dano")
@NamedQuery(name="TipoDano.findAll", query="SELECT t FROM TipoDano t")
public class TipoDano implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_dano")
	private Integer idTipoDano;

	private String nombre;

	//bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="tipoDano")
	private List<Reporte> reportes;

	public TipoDano() {
	}

	public Integer getIdTipoDano() {
		return this.idTipoDano;
	}

	public void setIdTipoDano(Integer idTipoDano) {
		this.idTipoDano = idTipoDano;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Reporte addReporte(Reporte reporte) {
		getReportes().add(reporte);
		reporte.setTipoDano(this);

		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setTipoDano(null);

		return reporte;
	}

}