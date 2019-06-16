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
		//Métodos
	//-----------------------------------------------------------------
	
	/**
	 * Método constructor del frame del cliente.
	 * @param pUsuario Información del usuario.
	 * @param pPrincipal Ventana principal de la aplicación.
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
