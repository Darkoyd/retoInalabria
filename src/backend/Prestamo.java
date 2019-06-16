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
	 * Usuario que hace el prestamo.
	 */
	private String userLogin;
	
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
	 * @param pUser Usuario que presta
	 * @param pPlazo Fecha de entrega del libro.
	 */
	public Prestamo(String pLibro, String pUser, String pPlazo) 
	{
		tituloLibro = pLibro;
		userLogin = pUser;
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
		return userLogin;
	}

	/**
	 * @return plazo de la clase
	 */
	public String darPlazo() 
	{
		return plazo;
	}

}
