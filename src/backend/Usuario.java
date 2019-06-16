package backend;

import java.util.Collection;
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
	 * M�todo que agrega un prestamo al usuario.
	 * @param pLibro Libro a prestar
	 * @param nombre Nombre a quien se le presta el libro.
	 * @throws Exception si ya se tiene el libro en los prestamos.
	 */
	public void agregarPrestamo(String nombre, String pLibro) throws Exception
	{
		Iterator<Prestamo> iter = prestamos.iterator();
		while(iter.hasNext())
		{
			if(iter.next().darTituloLibro().equals(pLibro))
			{
				throw new Exception("Ya se prest� este libro.");
			}
		}
		Prestamo x = new Prestamo(nombre, pLibro);
		prestamos.add(x);
	}
	
	/**
	 * @param p Prestamo a eliminar.
	 */
	public void eliminarPrestamo(Prestamo p)
	{
		prestamos.remove(p);
	}

}
