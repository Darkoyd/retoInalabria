package frontend;

import javax.swing.JFrame;

import backend.Usuario;

/**
 * Frame del cliente.
 * @author Nicolás Londoño
 *
 */
public class FrameCliente extends JFrame 
{

	

	//-----------------------------------------------------------------
		//Atributos y constantes
	//-----------------------------------------------------------------
	/**
	 * Constante de serializacion.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Asosiacion con la ventana principal.
	 */
	private InterfazBiblioteca principal;
	
	/**
	 * Usuario ingresado al sistema.
	 */
	private Usuario user;

	//-----------------------------------------------------------------
			//Métodos
	//-----------------------------------------------------------------
	
	/**
	 * Método constructor del frame del cliente.
	 * @param pUsuario Información del usuario.
	 * @param pPrincipal Ventana principal de la aplicación.
	 */
	public FrameCliente(Usuario pUsuario, InterfazBiblioteca pPrincipal) 
	{
		principal = pPrincipal;
		user = pUsuario;
		setTitle("Biblioteca Virtual - Cliente");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
	}

}
