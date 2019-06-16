package frontend;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import backend.Usuario;

/**
 * @author Nicol�s Londo�o
 *
 */
public class DialogoIngreso extends JDialog implements ActionListener
{


	//-----------------------------------------------------------------
	//Atributos y constantes
	//-----------------------------------------------------------------
	/**
	 * Constante de serializacion.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constante que representa el comando para ingresar con un usuario.
	 */
	private static final String INGRESAR = "Ingresar";

	/**
	 * Ventana principal de la aplicaci�n.
	 */
	private InterfazBiblioteca principal;

	/**
	 * Campo de texto para el login del usuario.
	 */
	private JTextField txtLogin;


	/**
	 * Campo de texto para la contrase�a del usuario.
	 */
	private JTextField txtContrasena;

	/**
	 * Bot�n de ingreso.
	 */
	private JButton btnIngresar;

	//-----------------------------------------------------------------
	//M�todos
	//-----------------------------------------------------------------

	/**
	 * Construye un di�logo para ingresar un usuario.<br>
	 * <b> post: </b> Se crea el di�logo con todos sus elementos gr�ficos.
	 * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
	 */
	public DialogoIngreso( InterfazBiblioteca pPrincipal )
	{
		principal = pPrincipal;

		setTitle( "Ingresar" );
		setSize( 300, 150 );
		setVisible(true);
		setLayout( new BorderLayout( ) );

		setLocationRelativeTo( null );

		JPanel panelCampos = new JPanel( );
		panelCampos.setLayout( new GridLayout( 2, 2, 5, 5) );
		panelCampos.setBorder( new TitledBorder( "Campos" ) );

		JLabel labNombreUsuario = new JLabel( "Login:" );
		txtLogin = new JTextField( );
		panelCampos.add( labNombreUsuario );
		panelCampos.add( txtLogin );

		JLabel labContrasena = new JLabel( "Contrase�a:" );
		txtContrasena = new JPasswordField( );
		panelCampos.add( labContrasena );
		panelCampos.add( txtContrasena );

		add( panelCampos, BorderLayout.CENTER );

		btnIngresar = new JButton( INGRESAR );
		btnIngresar.setActionCommand( INGRESAR );
		btnIngresar.addActionListener( this );
		add( btnIngresar, BorderLayout.SOUTH );
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand( );
		if( comando.equals( INGRESAR ) )
		{
			String login = txtLogin.getText( );
			String contrasena = txtContrasena.getText( );
			Usuario x = principal.consultarUsuario(login, contrasena);
			if( x == null)
			{
				JOptionPane.showMessageDialog( this, "No existe el usuario. Hable con el administrador.", "Ingresar", JOptionPane.ERROR_MESSAGE );
			}
			else 
			{
				new FrameBibliotecario(x, principal);
				this.dispose();
			}
		}
	}
}
