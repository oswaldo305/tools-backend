package proyecto.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado database table.
 * 
 */
@Entity
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado")
	private Integer idEstado;

	private String nombre;

	//bi-directional many-to-one association to Maquinaria
	@OneToMany(mappedBy="estado")
	private List<Maquinaria> maquinarias;

	public Estado() {
	}

	public Integer getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Maquinaria> getMaquinarias() {
		return this.maquinarias;
	}

	public void setMaquinarias(List<Maquinaria> maquinarias) {
		this.maquinarias = maquinarias;
	}

	public Maquinaria addMaquinaria(Maquinaria maquinaria) {
		getMaquinarias().add(maquinaria);
		maquinaria.setEstado(this);

		return maquinaria;
	}

	public Maquinaria removeMaquinaria(Maquinaria maquinaria) {
		getMaquinarias().remove(maquinaria);
		maquinaria.setEstado(null);

		return maquinaria;
	}

}