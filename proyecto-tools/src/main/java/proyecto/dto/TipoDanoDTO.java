package proyecto.dto;

public class TipoDanoDTO {

	
	private Integer idTipoDano;
	private String nombre;
	public TipoDanoDTO(Integer idTipoDano, String nombre) {
		super();
		this.idTipoDano = idTipoDano;
		this.nombre = nombre;
	}
	public TipoDanoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdTipoDano() {
		return idTipoDano;
	}
	public void setIdTipoDano(Integer idTipoDano) {
		this.idTipoDano = idTipoDano;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
