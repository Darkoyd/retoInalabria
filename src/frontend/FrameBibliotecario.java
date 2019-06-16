package frontend;

import javax.swing.JFrame;

import backend.Usuario;

public class FrameBibliotecario extends JFrame
{

	//-----------------------------------------------------------------
		//Atributos y constantes
	//-----------------------------------------------------------------
	
	/**
	 * Asocioacion con la ventana principal.
	 */
	private InterfazBiblioteca principal;
	
	/**
	 * Usuario que usa el servicio.
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
	public FrameBibliotecario(Usuario pUsuario, InterfazBiblioteca pPrincipal) 
	{
		user = pUsuario;
		principal = pPrincipal;
		setTitle("Biblioteca Virtual - Cliente");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
	}

}
