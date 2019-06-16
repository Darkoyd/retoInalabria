package backend;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase que representa al usuario que ingresa.
 * @author Nicolas Londoño
 *
 */
public class Usuario 
{

	//-----------------------------------------------------------------
		//Atributos y constantes
	//-----------------------------------------------------------------

	/**
	 * Nombre del usuario.
	 */
	private String nombre;
	
	/**
	 * Login del usuario.
	 */
	private String login;
	
	/**
	 * Contraseña del usuario
	 */
	private String contrasena;
	
	/**
	 * Lista de prestamos.
	 */
	private Collection<Prestamo> prestamos;
	
	//-----------------------------------------------------------------
		//Métodos
	//-----------------------------------------------------------------
	
	/**
	 * Método constructor del usuario.
	 * @param pNombre Nombre del usuario.
	 * @param pLogin Login del usuario.
	 * @param pContrasena Contraseña del usuario.
	 */
	public Usuario(String pNombre, String pLogin, String pContrasena) 
	{
		nombre = pNombre;
		login = pLogin;
		contrasena = pContrasena;
		prestamos = new LinkedList<Prestamo>();
	}
	
	/**
	 * @return Nombre del usuario
	 */
	public String darNombre()
	{
		return nombre;
	}
	
	/**
	 * @return Contraseña del usuario
	 */
	public String darContrasena()
	{
		return contrasena;
	}
	
	/**
	 * @return Login del usuario.
	 */
	public String darLogin()
	{
		return login;
	}
	
	/**
	 * @return prestamos del usuario.
	 */
	public Collection<Prestamo> darPrestamos() 
	{
		return prestamos;
	}

	
	/**
	 * Método que agrega un prestamo al usuario.
	 * @param pLibro Libro a prestar
	 * @param pPlazo Plazo de entrega del libro
	 * @throws Exception si ya se tiene el libro en los prestamos.
	 */
	public void agregarPrestamo(String pLibro, String pPlazo) throws Exception
	{
		Iterator<Prestamo> iter = prestamos.iterator();
		while(iter.hasNext())
		{
			if(iter.next().darTituloLibro().equals(pLibro))
			{
				throw new Exception("Ya se prestó este libro.");
			}
		}
		Prestamo x = new Prestamo(pLibro, this.darLogin(), pPlazo);
		prestamos.add(x);
	}

}
