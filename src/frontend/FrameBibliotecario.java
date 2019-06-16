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

	private final static String ACTUALIZAR = "Actualizar";

	private final static String PRESTAR = "Prestar Libro";

	private final static String REGISTRAR = "Registrar Usuario";

	private final static String AGREGAR = "Agregar Libro";

	private final static String ELIMINAR = "Eliminar prestamo";

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

	private JList<Object> libros;

	private JList<Object> prestamos;

	private Collection<Libro> listaLibros;

	private JButton actualizar;

	private JButton prestar;

	private JButton registrar;

	private JButton agregar;

	private JButton eliminar;

	private Libro libroActual;

	private Prestamo prestamoActual;


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
		setSize(1000, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		//libro
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


		//listas
		JPanel listas = new JPanel();
		listas.setLayout(new GridLayout(2, 1));
		
		libros = new JList<Object>();
		prestamos = new JList<Object>();
		
		libros.setVisible(true);
		prestamos.setVisible(true);
		
		prestamos.setBorder(new TitledBorder("Lista de prestamos"));
		prestamos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		libros.setBorder(new TitledBorder("Lista de libros"));
		libros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		prestamos.addListSelectionListener(this);
		libros.addListSelectionListener(this);

		prestamos.setListData(user.darPrestamos().toArray());

		listas.add(libros);
		listas.add(prestamos);

		add(listas, BorderLayout.WEST);

		//opciones
		JPanel opciones = new JPanel();
		opciones.setLayout(new GridLayout(1, 5));
		actualizar = new JButton(ACTUALIZAR);
		prestar = new JButton(PRESTAR);
		registrar = new JButton(REGISTRAR);
		agregar = new JButton(AGREGAR);
		eliminar = new JButton(ELIMINAR);

		actualizar.addActionListener(this);
		prestar.addActionListener(this);
		registrar.addActionListener(this);
		agregar.addActionListener(this);
		eliminar.addActionListener(this);

		actualizar.setActionCommand(ACTUALIZAR);
		prestar.setActionCommand(PRESTAR);
		registrar.setActionCommand(REGISTRAR);
		agregar.setActionCommand(AGREGAR);
		eliminar.setActionCommand(ELIMINAR);

		opciones.add(actualizar);
		opciones.add(prestar);
		opciones.add(registrar);
		opciones.add(agregar);
		opciones.add(eliminar);

		add(opciones, BorderLayout.SOUTH);
	}


	/**
	 * Actualiza la lista de libros
	 */
	public void actualizarLibros()
	{
		listaLibros = principal.darBack().darAdmin().consultarLibros();
		libros.setListData(listaLibros.toArray());
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) 
	{
		Libro x = (Libro) libros.getSelectedValue();
		Prestamo y = (Prestamo) prestamos.getSelectedValue();
		if(x != null)
		{
			libroActual = x;
			actualizarPanelLibro();
		}
		if(y != null)
		{
			prestamoActual = y;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(REGISTRAR))
		{
			new DialogoRegistro(principal);
		}
		else if(e.getActionCommand().equals(ACTUALIZAR))
		{
			actualizarLibros();
		}
		else if(e.getActionCommand().equals(PRESTAR))
		{
			if(libroActual == null)
			{
				JOptionPane.showMessageDialog(this, "Seleccione un libro a prestar.", "Error", JOptionPane.ERROR_MESSAGE);
			} 
			else
				try 
			{
					String x = JOptionPane.showInputDialog(this, "Inserte nombre del cliente.");
					if(x == null || x.equals(" "))
					{
						JOptionPane.showMessageDialog(this, "Nombre invalido.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
						user.agregarPrestamo(libroActual.darTitulo(), x);
			} 
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals(AGREGAR))
		{
			new DialogoNuevoLibro(principal);
		}
		else if(e.getActionCommand().equals(ELIMINAR))
		{
			if( prestamoActual != null)
			{
				user.eliminarPrestamo(prestamoActual);
				actualizarListaPrestamos();
			}
			else
				JOptionPane.showMessageDialog(this, "No hay un prestamo seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}


	private void actualizarPanelLibro() 
	{
		txtTitulo.setText(libroActual.darTitulo());
		txtAutor.setText(libroActual.darAutor());
		txtGenero.setText(libroActual.darGenero());
		txtSinopsis.setText(libroActual.darSinopsis());
		txtEditorial.setText(libroActual.darEditorial());
	}


	private void actualizarListaPrestamos() 
	{
		prestamos.setListData((Prestamo[]) user.darPrestamos().toArray());
	}

}
