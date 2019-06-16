package backend;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase que representa al usuario que ingresa.
 * @author Nicolas Londo�o
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
	 * Contrase�a del usuario
	 */
	private String contrasena;
	
	/**
	 * Atributo que revisa si el usuario es un bibliotecario.
	 */
	private boolean bibliotecario;
	
	/**
	 * Lista de prestamos.
	 */
	private Collection<Prestamo> prestamos;
	
	//-----------------------------------------------------------------
		//M�todos
	//-----------------------------------------------------------------
	
	/**
	 * M�todo constructor del usuario.
	 * @param pNombre Nombre del usuario.
	 * @param pLogin Login del usuario.
	 * @param pContrasena Contrase�a del usuario.
	 * @param pBibliotecario Booleano que determina si el usuario es un bibliotecario o un cliente.
	 */
	public Usuario(String pNombre, String pLogin, String pContrasena, boolean pBibliotecario) 
	{
		nombre = pNombre;
		login = pLogin;
		contrasena = pContrasena;
		bibliotecario = pBibliotecario;
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
	 * @return Contrase�a del usuario
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
	 * @return true si el usuario es un bibliotecario. false de lo contrario.
	 */
	public boolean esBibliotecario()
	{
		return bibliotecario;
	}
	
	/**
	 * M�todo que agrega un prestamo al usuario.
	 * @param pLibro Libro a prestar
	 * @param pPlazo Plazo de entrega del libro
	 * @throws Exception si ya se tiene el libro en los prestamos.
	 */
	public void agregarPrestamo(Libro pLibro, Date pPlazo) throws Exception
	{
		Iterator<Prestamo> iter = prestamos.iterator();
		while(iter.hasNext())
		{
			if(iter.next().darLibro().darTitulo().equals(pLibro.darTitulo()))
			{
				throw new Exception("Ya tiene este libro.");
			}
		}
		Prestamo x = new Prestamo(pLibro, this, pPlazo);
		prestamos.add(x);
	}

}
