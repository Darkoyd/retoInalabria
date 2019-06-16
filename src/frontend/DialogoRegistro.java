package frontend;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Diálogo para registrar un nuevo usuario al blog.
 */
public class DialogoRegistro extends JDialog implements ActionListener
{


	// -----------------------------------------------------------------
	// Constantes y atributos
	// -----------------------------------------------------------------

	/**
	 * Constante que representa el comando para registrar el usuario.
	 */
	private static final String REGISTRAR_USUARIO = "Registrar";

	/**
	 * Constante de serializacion.
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Ventana principal de la aplicación.
	 */
	private InterfazBiblioteca principal;

	/**
	 * Campo de texto para el login del usuario.
	 */
	private JTextField txtLogin;

	/**
	 * Campo de texto para el nombre del usuario.
	 */
	private JTextField txtNombre;

	/**
	 * Campo de texto para la contraseña del usuario.
	 */
	private JTextField txtContrasena;

	/**
	 * Botón de ingreso.
	 */
	private JButton btnIngresar;



	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye un diálogo para registrar un usuario.<br>
	 * <b> post: </b> Se crea el diálogo con todos sus elementos gráficos.
	 * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
	 */
	public DialogoRegistro( InterfazBiblioteca pPrincipal )
	{
		principal = pPrincipal;

		setTitle( "Registrar usuario" );
		setSize( 300, 200 );
		setLayout( new BorderLayout( ) );

		setLocationRelativeTo( null );

		JPanel panelCampos = new JPanel( );
		panelCampos.setLayout( new GridLayout( 3, 2, 10, 10 ) );
		panelCampos.setBorder( new TitledBorder( "Campos" ) );

		JLabel labNombreUsuario = new JLabel( "Login:" );
		txtLogin = new JTextField( );
		panelCampos.add( labNombreUsuario );
		panelCampos.add( txtLogin );

		JLabel labNombres = new JLabel( "Nombre:" );
		txtNombre = new JTextField( );
		panelCampos.add( labNombres );
		panelCampos.add( txtNombre );

		JLabel labContrasena = new JLabel( "Contraseña:" );
		txtContrasena = new JPasswordField( );
		panelCampos.add( labContrasena );
		panelCampos.add( txtContrasena );


		add( panelCampos, BorderLayout.CENTER );

		btnIngresar = new JButton( REGISTRAR_USUARIO );
		btnIngresar.setActionCommand( REGISTRAR_USUARIO );
		btnIngresar.addActionListener( this );
		add( btnIngresar, BorderLayout.SOUTH );
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Manejo de los eventos de los botones.
	 * @param pEvento Acción que generó el evento. pEvento != null.
	 */
	public void actionPerformed( ActionEvent pEvento )
	{
		String comando = pEvento.getActionCommand( );
		if( comando.equals( REGISTRAR_USUARIO ) )
		{
			String login = txtLogin.getText( );
			String nombre = txtNombre.getText( );
			String contrasena = txtContrasena.getText( );
			if( login != null && !login.equals( "" ) && nombre != null && !nombre.equals( "" ) && contrasena != null && !contrasena.equals( "" ))
			{
				principal.registrarUsuario( login, nombre, contrasena);
				this.dispose( );
			}
			else
			{
				JOptionPane.showMessageDialog( this, "Por favor ingrese todos los datos.", "Registrar usuario", JOptionPane.INFORMATION_MESSAGE );
			}
		}
	}
}
