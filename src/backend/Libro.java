package backend;

/**
 * Clase que representa un libro.
 * @author Nicol�s Londo�o
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
	 * Editorial del libro.
	 */
	private String editorial;

	
	//-----------------------------------------------------------------
		//M�todos
	//-----------------------------------------------------------------
	
	/** M�todo constructor del libro.
	 * @param pTitulo Titulo del libro.
	 * @param pAutor Autor(es) del libro.
	 * @param pGenero G�nero literario del libro.
	 * @param pEditorial Editorial del libro.

	 */
	
	public Libro(String pTitulo, String pAutor, String pGenero, String pEditorial) 
	{
		titulo = pTitulo;
		autor = pAutor;
		genero = pGenero;
		editorial = pEditorial;
		
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
	 * @return editorial del libro
	 */
	public String darEditorial() 
	{
		return editorial;
	}


	public String toString()
	{
		return titulo + " por: " +autor;
	}
	
	

}
