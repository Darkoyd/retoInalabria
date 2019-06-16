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
	private String libro;
	
	/*
	 * Usuario que hace el prestamo.
	 */
	private String user;
	
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
		libro = pLibro;
		user = pUser;
		plazo = pPlazo;
	}

	/**
	 * @return libro del prestamo.
	 */
	public String darLibro() 
	{
		return libro;
	}

	/**
	 * @return usuario del prestamo.
	 */
	public String darUser() 
	{
		return user;
	}

	/**
	 * @return plazo de la clase
	 */
	public String darPlazo() 
	{
		return plazo;
	}

}
