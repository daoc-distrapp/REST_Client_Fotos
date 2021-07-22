package dordonez.clients.fotos_rest_cli;

public class Foto {
	private long id;
	private String titulo;
	private String descripcion;
	private float latitud;
	private float longitud;
	private long timestamp;
	private String fotoB64;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getFotoB64() {
		return fotoB64;
	}
	public void setFotoB64(String fotoB64) {
		this.fotoB64 = fotoB64;
	}
	@Override
	public String toString() {
		return "Foto [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion 
				+ ", latitud=" + latitud + ", longitud=" + longitud + ", timestamp=" + timestamp 
				+ ", fotoB64=" + (fotoB64.length() < 20 ? fotoB64 : fotoB64.substring(0, 19)+"...") + "]";
	}
	
}
