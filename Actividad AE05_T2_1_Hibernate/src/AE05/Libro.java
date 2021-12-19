package AE05;


public class Libro {
	int id;
	String titulo, autor, anyoNacimiento, anyoPublicacion, editorial, numPaginas;

	public Libro() {
	}

	public Libro(int id, String titulo,String autor, String anyoNacimiento, String anyoPublicacion,String editorial, String numPaginas) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.anyoNacimiento = anyoNacimiento;
		this.anyoPublicacion = anyoPublicacion;
		this.editorial = editorial;
		this.numPaginas = numPaginas;
	}
	
	public Libro(String titulo,String autor, String anyoNacimiento, String anyoPublicacion,String editorial, String numPaginas) {
		this.titulo = titulo;
		this.autor = autor;
		this.anyoNacimiento = anyoNacimiento;
		this.anyoPublicacion = anyoPublicacion;
		this.editorial = editorial;
		this.numPaginas = numPaginas;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getanyoPublicacion() {
		return anyoPublicacion;
	}
	
	public void setanyoPublicacion(String anyoPublicacion) {
		this.anyoPublicacion = anyoPublicacion;
	}
	
	public String getanyoNacimiento() {
		return anyoNacimiento;
	}
	
	public void setanyoNacimiento(String anyoNacimiento) {
		this.anyoNacimiento = anyoNacimiento;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getnumPaginas() {
		return numPaginas;
	}
	
	public void setnumPaginas(String numPaginas) {
		this.numPaginas = numPaginas;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String toString() {
		String infoCompleta = "Libro: -Identificador: " + id + " -Titulo: " + titulo + " -Autor: "+ autor +" -anyoPublicacion: " + " -anyoNacimiento: " + anyoNacimiento + anyoPublicacion + " Editorial: "+ editorial + " -Paginas: " + numPaginas;
		return infoCompleta;
	}
}
