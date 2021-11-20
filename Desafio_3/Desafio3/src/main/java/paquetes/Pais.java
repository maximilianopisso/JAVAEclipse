package paquetes;

public class Pais {

	private String id;
	private String nombre;
	private Integer codigoArea;
	
	public Pais(String id, String nombre, Integer codigoArea) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigoArea = codigoArea;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(Integer codigoArea) {
		this.codigoArea = codigoArea;
	}

	@Override
	public String toString() {
		return "Este Pais tiene como identificador "+ id +" tiene por nombre " + nombre + " y su codigo de area es +" + codigoArea;
	}
	
}


