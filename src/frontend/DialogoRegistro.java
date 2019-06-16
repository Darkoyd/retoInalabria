package frontend;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Di�logo para registrar un nuevo usuario al blog.
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
     * Ventana principal de la aplicaci�n.
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
     * Campo de texto para la contrase�a del usuario.
     */
    private JTextField txtContrasena;

    /**
     * Bot�n de ingreso.
     */
    private JButton btnIngresar;
    
    /*
     * Bot�n del bibliotecario
     */
    private JRadioButton btnBiblio;
    
    /*
     * Bot�n del cliente
     */
    private JRadioButton btnCliente;
    
    /*
     * Grupo de botones
     */
    private ButtonGroup tipo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un di�logo para registrar un usuario.<br>
     * <b> post: </b> Se crea el di�logo con todos sus elementos gr�ficos.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public DialogoRegistro( InterfazBiblioteca pPrincipal )
    {
        principal = pPrincipal;

        setTitle( "Registrar usuario" );
        setSize( 300, 200 );
        setLayout( new BorderLayout( ) );

        setLocationRelativeTo( null );

        JPanel panelCampos = new JPanel( );
        panelCampos.setLayout( new GridLayout( 4, 2, 10, 10 ) );
        panelCampos.setBorder( new TitledBorder( "Campos" ) );

        JLabel labNombreUsuario = new JLabel( "Login:" );
        txtLogin = new JTextField( );
        panelCampos.add( labNombreUsuario );
        panelCampos.add( txtLogin );

        JLabel labNombres = new JLabel( "Nombre:" );
        txtNombre = new JTextField( );
        panelCampos.add( labNombres );
        panelCampos.add( txtNombre );

        JLabel labContrasena = new JLabel( "Contrase�a:" );
        txtContrasena = new JPasswordField( );
        panelCampos.add( labContrasena );
        panelCampos.add( txtContrasena );
        
        JLabel labTipo = new JLabel("Tipo de usuario");
        tipo = new ButtonGroup();
        btnBiblio = new JRadioButton("Bibliotecario");
        btnCliente = new JRadioButton("Cliente");
        tipo.add(btnBiblio);
        tipo.add(btnCliente);
        panelCampos.add(labTipo);
        
        JPanel temp = new JPanel();
        temp.setLayout(new GridLayout(1, 2));
        temp.add(btnBiblio);
        temp.add(btnCliente);
        panelCampos.add(temp);

        add( panelCampos, BorderLayout.CENTER );

        btnIngresar = new JButton( REGISTRAR_USUARIO );
        btnIngresar.setActionCommand( REGISTRAR_USUARIO );
        btnIngresar.addActionListener( this );
        add( btnIngresar, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    	// M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento. pEvento != null.
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
                try
                {
            	principal.registrarUsuario( login, nombre, contrasena, esBiblio());
                this.dispose( );
                }
                catch(Exception e)
                {
                	JOptionPane.showMessageDialog( this, "Por favor ingrese todos los datos.", "Registrar usuario", JOptionPane.INFORMATION_MESSAGE );
                }
            }
            else
            {
                JOptionPane.showMessageDialog( this, "Por favor ingrese todos los datos.", "Registrar usuario", JOptionPane.INFORMATION_MESSAGE );
            }
        }
    }
    
    private boolean esBiblio() throws Exception
    {
    	if(btnBiblio.isSelected())
    		return true;
    	else if(btnCliente.isSelected())
    		return false;
    	else
    		throw new Exception("No se seleccion� tipo de usuario");
    }
}
