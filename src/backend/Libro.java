/*
 * Clase que representa los libros para prestar.
 */
package backend;

/**
 * @author userrrrr
 *
 */
public class Libro 
{
	//-----------------------------------------------------------------
		//Atributos y constantes
	//-----------------------------------------------------------------

	/*
	 * Titulo del libro.
	 */
	private String titulo;
	
	/*
	 * Autor del libro.
	 */
	private String autor;
	
	/*
	 * Género al que pertenece el libro.
	 */
	private String genero;
	
	/*
	 * Breve resumen del libro.
	 */
	private String sinopsis;
	
	/*
	 * Editorial del libro.
	 */
	private String editorial;
	
	/*
	 * Numero de unidades disponibles
	 */
	private int cantidad;
	
	/*
	 * Calificación del libro.
	 */
	private int calificacion;
	
	//-----------------------------------------------------------------
		//Métodos
	//-----------------------------------------------------------------
	
	/** Método constructor del libro.
	 * @param pTitulo Titulo del libro.
	 * @param pAutor Autor(es) del libro.
	 * @param pGenero Género literario del libro.
	 * @param pSinopsis Resumen breve del libro.
	 * @param pEditorial Editorial del libro.
	 * @param pCantidad Cantidad disponible para prestamo.
	 */
	
	public Libro(String pTitulo, String pAutor, String pGenero, String pSinopsis, String pEditorial, int pCantidad) 
	{
		titulo = pTitulo;
		autor = pAutor;
		genero = pGenero;
		sinopsis = pSinopsis;
		editorial = pEditorial;
		cantidad = pCantidad;
		calificacion = 0;
	}

	/**
	 * @return titulo del libro
	 */
	public String darTitulo() 
	{
		return titulo;
	}

	/**
	 * @return autor del libro
	 */
	public String darAutor() 
	{
		return autor;
	}

	/**
	 * @return genero del libro
	 */
	public String darGenero()
	{
		return genero;
	}

	/**
	 * @return sinopsis del libro
	 */
	public String darSinopsis() 
	{
		return sinopsis;
	}

	/**
	 * @return editorial del libro
	 */
	public String darEditorial() 
	{
		return editorial;
	}

	/**
	 * @return cantidad de libros disponibles
	 */
	public int darCantidad() 
	{
		return cantidad;
	}

	/**
	 * @return calificacion de la clase
	 */
	public int darCalificacion() 
	{
		return calificacion;
	}

	
	

}
