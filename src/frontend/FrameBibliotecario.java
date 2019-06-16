package frontend;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import backend.Usuario;
import backend.Libro;
import backend.Prestamo;

/**
 * Frame del bibliotecario.
 * @author Nicolás Londoño
 *
 */
public class FrameBibliotecario extends JFrame implements ActionListener, ListSelectionListener
{

	//-----------------------------------------------------------------
		//Atributos y constantes
	//-----------------------------------------------------------------
	/**
	 * Constante de serializacion.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Asocioacion con la ventana principal.
	 */
	private InterfazBiblioteca principal;
	
	/**
	 * Usuario que usa el servicio.
	 */
	private Usuario user;
	
	private JTextField txtTitulo;
	
	private JTextField txtAutor;
	
	private JTextField txtGenero;
	
	private JTextArea txtSinopsis;
	
	private JTextField txtEditorial;
	
	private JList<Libro> libros;
	
	private JList<Prestamo> prestamos;
	
	private Collection<Libro> listaLibros;
	
	

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
		listaLibros = new LinkedList<>();
		user = pUsuario;
		principal = pPrincipal;
		setTitle("Biblioteca Virtual - Bienvenido");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setLayout(new BorderLayout());
		
		JPanel infoLibro = new JPanel();
		infoLibro.setBorder(new TitledBorder("Información del Libro"));
		infoLibro.setLayout(new GridLayout(5, 2));
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
		
		txtTitulo.setEditable(false);
		txtAutor.setEditable(false);
		txtGenero.setEditable(false);
		txtSinopsis.setEditable(false);
		txtEditorial.setEditable(false);
		
		infoLibro.add(titulo);
		infoLibro.add(txtTitulo);
		infoLibro.add(autor);
		infoLibro.add(txtAutor);
		infoLibro.add(genero);
		infoLibro.add(txtGenero);
		infoLibro.add(sinopsis);
		infoLibro.add(txtSinopsis);
		infoLibro.add(editorial);
		infoLibro.add(txtEditorial);
		add(infoLibro, BorderLayout.CENTER);
		
		JPanel listas = new JPanel();
		listas.setLayout(new GridLayout(2, 1));
		libros = new JList<>();
		prestamos = new JList<>();
		prestamos.setBorder(new TitledBorder("Lista de prestamos"));
		prestamos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		libros.setBorder(new TitledBorder("Lista de libros"));
		libros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		prestamos.addListSelectionListener(this);
		libros.addListSelectionListener(this);
		
		prestamos.setListData((Prestamo[]) user.darPrestamos().toArray());
		
	}


	public void actualizarLibros()
	{
		listaLibros = principal.darBack().darAdmin().consultarLibros();
	}
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

}
