package backend;

import java.util.Date;

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
	private Libro libro;
	
	/*
	 * Usuario que hace el prestamo.
	 */
	private Usuario user;
	
	/*
	 * Fecha de entrega.
	 */
	private Date plazo;

	//-----------------------------------------------------------------
		//Métodos
	//-----------------------------------------------------------------
	
	/**
	 * Método constructor de un prestamo.
	 * @param pLibro Libro a prestar.
	 * @param pUser Usuario que presta
	 * @param pPlazo Fecha de entrega del libro.
	 */
	public Prestamo(Libro pLibro, Usuario pUser, Date pPlazo) 
	{
		libro = pLibro;
		user = pUser;
		plazo = pPlazo;
	}

	/**
	 * @return libro del prestamo.
	 */
	public Libro darLibro() 
	{
		return libro;
	}

	/**
	 * @return usuario del prestamo.
	 */
	public Usuario darUser() 
	{
		return user;
	}

	/**
	 * @return plazo de la clase
	 */
	public Date darPlazo() 
	{
		return plazo;
	}

}
