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
	


	//-----------------------------------------------------------------
		//Métodos
	//-----------------------------------------------------------------
	
	/**
	 * Método constructor de un prestamo.
	 * @param pLibro Libro a prestar.
	 * @param name Usuario que presta
	 */
	public Prestamo(String name, String pLibro) 
	{
		tituloLibro = pLibro;
		userName = name;
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
	public String darUserName() 
	{
		return userName;
	}

	
	public String toString()
	{
		return tituloLibro + " Prestado a: " + userName;
	}

}
