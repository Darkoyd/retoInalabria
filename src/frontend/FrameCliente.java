package frontend;

import javax.swing.JFrame;

import backend.Usuario;

/**
 * @author Nicol�s Londo�o
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
			//M�todos
	//-----------------------------------------------------------------
	
	/**
	 * M�todo constructor del frame del cliente.
	 * @param pUsuario Informaci�n del usuario.
	 * @param pPrincipal Ventana principal de la aplicaci�n.
	 */
	public FrameCliente(Usuario pUsuario, InterfazBiblioteca pPrincipal) 
	{
		setTitle("Biblioteca Virtual - Cliente");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
	}

}
