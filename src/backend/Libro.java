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
	 * G�nero al que pertenece el libro.
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
	 * Calificaci�n del libro.
	 */
	private int calificacion;
	
	//-----------------------------------------------------------------
		//M�todos
	//-----------------------------------------------------------------
	
	/** M�todo constructor del libro.
	 * @param pTitulo Titulo del libro.
	 * @param pAutor Autor(es) del libro.
	 * @param pGenero G�nero literario del libro.
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
	
	

}
