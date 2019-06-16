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
import javax.swing.JTextArea;
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

	private InterfazBiblioteca principal;

	private JTextField txtTitulo;

	private JTextField txtAutor;

	private JTextField txtGenero;

	private JTextArea txtSinopsis;

	private JTextField txtEditorial;

	private JButton agregar;

	private final static String AGREGAR = "Agregar";

	//-----------------------------------------------------------------
	//Métodos
	//-----------------------------------------------------------------

	/**
	 * Método constructod del dialogo.
	 * @param pPrincipal Ventana principal de la aplicación.
	 */
	public DialogoNuevoLibro(InterfazBiblioteca pPrincipal) 
	{
		principal = pPrincipal;
		
		setTitle( "Registrar libro" );
		setSize( 300, 800 );
		setLayout( new BorderLayout( ) );
		setVisible(true);

		setLocationRelativeTo( null );
		
		JPanel panelCampos = new JPanel( );
		panelCampos.setLayout( new GridLayout( 5, 2, 20, 20 ) );
		panelCampos.setBorder( new TitledBorder( "Campos" ) );
		
		JLabel titulo = new JLabel("Titulo: ");
		JLabel autor = new JLabel("Autor: ");
		JLabel genero = new JLabel("Genero: ");
		JLabel sinopsis = new JLabel("Sinopsis: ");
		JLabel editorial = new JLabel("Editorial: ");
		
		txtTitulo = new JTextField();
		txtAutor = new JTextField();
		txtGenero = new JTextField();
		txtSinopsis = new JTextArea();
		txtEditorial = new JTextField();
		
		txtTitulo.setEditable(true);
		txtAutor.setEditable(true);
		txtGenero.setEditable(true);
		txtSinopsis.setEditable(true);
		txtEditorial.setEditable(true);
		
		panelCampos.add(titulo);
		panelCampos.add(txtTitulo);
		panelCampos.add(autor);
		panelCampos.add(txtAutor);
		panelCampos.add(genero);
		panelCampos.add(txtGenero);
		panelCampos.add(sinopsis);
		panelCampos.add(txtSinopsis);
		panelCampos.add(editorial);
		panelCampos.add(txtEditorial);
		add(panelCampos, BorderLayout.CENTER);
		
		agregar = new JButton(AGREGAR);
		agregar.addActionListener(this);
		agregar.setActionCommand(AGREGAR);
		add(agregar, BorderLayout.SOUTH);
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(AGREGAR))
		{
			String titulo = txtTitulo.getText();
			String autor = txtAutor.getText();
			String genero = txtGenero.getText();
			String sinopsis = txtTitulo.getText();
			String editorial = txtTitulo.getText();
			if(titulo == null || titulo.equals(" ") || autor == null || autor.equals(" ") || genero == null || 
					genero.equals(" ") || sinopsis == null || sinopsis.equals(" ") || editorial == null || editorial.equals(" "))
			{
				JOptionPane.showMessageDialog( this, "Por favor ingrese todos los datos.", "Registrar libro", JOptionPane.INFORMATION_MESSAGE );
			}
			else
			{
				principal.registrarLibro( titulo, autor, genero, sinopsis, editorial);
				this.dispose( );
			}
		}
	}
}
