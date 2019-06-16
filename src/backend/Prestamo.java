package backend;

/**
 * Clase que representa un prestamo.
 * @author Nicolas Londoño
 */
public class Prestamo 
{

	//-----------------------------------------------------------------
		//Atributos y constantes
	//-----------------------------------------------------------------
	
	/**
	 * Libro a prestar.
	 */
	private String tituloLibro;
	
	/*
	 * Nomnre de quien hace el prestamo.
	 */
	private String userName;
	
	/*
	 * Fecha de entrega.
	 */
	private String plazo;

	//-----------------------------------------------------------------
		//Métodos
	//-----------------------------------------------------------------
	
	/**
	 * Método constructor de un prestamo.
	 * @param pLibro Libro a prestar.
	 * @param name Usuario que presta
	 * @param pPlazo Fecha de entrega del libro.
	 */
	public Prestamo(String name, String pLibro, String pPlazo) 
	{
		tituloLibro = pLibro;
		userName = name;
		plazo = pPlazo;
	}

	/**
	 * @return libro del prestamo.
	 */
	public String darTituloLibro() 
	{
		return tituloLibro;
	}

	/**
	 * @return usuario del prestamo.
	 */
	public String darUserLogin() 
	{
		return userName;
	}

	/**
	 * @return plazo de la clase
	 */
	public String darPlazo() 
	{
		return plazo;
	}

}
