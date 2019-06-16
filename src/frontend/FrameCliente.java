package frontend;

import javax.swing.JFrame;

import backend.Usuario;

/**
 * @author Nicolás Londoño
 *
 */
public class FrameCliente extends JFrame 
{

	//-----------------------------------------------------------------
		//Atributos y constantes
	//-----------------------------------------------------------------
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
		setTitle("Biblioteca Virtual - Cliente");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
	}

}
