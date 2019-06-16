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
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author Nicolás Londoño
 *
 */
public class DialogoNuevoLibro extends JDialog implements ActionListener
{


	//-----------------------------------------------------------------
	//Atributos y constantes
	//-----------------------------------------------------------------

	/**
	 * Constante de serilizacion.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Asociación con la ventana principal
	 */
	private InterfazBiblioteca principal;

	/**
	 * Campos de texto del nuevo libro.
	 */
	private JTextField txtTitulo;

	private JTextField txtAutor;

	private JTextField txtGenero;

	private JTextField txtEditorial;

	/**
	 * Botón para agregar el libro.
	 */
	private JButton agregar;

	/**
	 * Constante del botón
	 */
	private final static String AGREGAR_LIBRO = "Agregar";
	
	/**
	 * Asociación con el cuadro del bibliotecario.
	 */
	private FrameBibliotecario frameBibliotecario;

	//-----------------------------------------------------------------
	//Métodos
	//-----------------------------------------------------------------

	/**
	 * Método constructod del dialogo.
	 * @param pPrincipal Ventana principal de la aplicación.
	 * @param pFrameBibliotecario Frame principal.
	 */
	public DialogoNuevoLibro(InterfazBiblioteca pPrincipal, FrameBibliotecario pFrameBibliotecario) 
	{
		principal = pPrincipal;
		frameBibliotecario = pFrameBibliotecario;
		setTitle( "Registrar libro" );
		setSize( 300, 300 );
		setLayout( new BorderLayout( ) );
		setVisible(true);

		setLocationRelativeTo( null );
		
		JPanel panelCampos = new JPanel( );
		panelCampos.setLayout( new GridLayout( 4, 2, 20, 20 ) );
		panelCampos.setBorder( new TitledBorder( "Campos" ) );
		
		JLabel titulo = new JLabel("Titulo: ");
		JLabel autor = new JLabel("Autor: ");
		JLabel genero = new JLabel("Género: ");
		JLabel editorial = new JLabel("Editorial: ");
		
		txtTitulo = new JTextField();
		txtAutor = new JTextField();
		txtGenero = new JTextField();
		txtEditorial = new JTextField();
		
		txtTitulo.setEditable(true);
		txtAutor.setEditable(true);
		txtGenero.setEditable(true);
		txtEditorial.setEditable(true);
		
		panelCampos.add(titulo);
		panelCampos.add(txtTitulo);
		panelCampos.add(autor);
		panelCampos.add(txtAutor);
		panelCampos.add(genero);
		panelCampos.add(txtGenero);
		panelCampos.add(editorial);
		panelCampos.add(txtEditorial);
		add(panelCampos, BorderLayout.CENTER);
		
		agregar = new JButton(AGREGAR_LIBRO);
		agregar.addActionListener(this);
		agregar.setActionCommand(AGREGAR_LIBRO);
		add(agregar, BorderLayout.SOUTH);
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(AGREGAR_LIBRO))
		{
			String titulo = txtTitulo.getText().trim();
			String autor = txtAutor.getText().trim();
			String genero = txtGenero.getText().trim();
			String editorial = txtEditorial.getText().trim();
			
			if(titulo != null && !titulo.equals("") && autor != null && !autor.equals("") && genero != null && !genero.equals("") && editorial != null && !editorial.equals(""))
			{
				principal.registrarLibro( titulo, autor, genero, editorial);
				JOptionPane.showMessageDialog(this, "Se ha agregado el libro.", "Agregar libro", JOptionPane.INFORMATION_MESSAGE);
				frameBibliotecario.actualizarLibros();
				this.dispose( );
			}
			else
			{
				JOptionPane.showMessageDialog( this, "Por favor ingrese todos los datos.", "Registrar libro", JOptionPane.INFORMATION_MESSAGE );
			}
		}
	}
}
