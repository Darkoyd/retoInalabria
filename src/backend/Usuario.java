package backend;

import java.util.Collection;
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
	 * Atributo que revisa si el usuario es un bibliotecario.
	 */
	private boolean bibliotecario;
	
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
	 * @return true si el usuario es un bibliotecario. false de lo contrario.
	 */
	public boolean esBibliotecario()
	{
		return bibliotecario;
	}

}
