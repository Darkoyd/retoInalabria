package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

	private final static String PRESTAR = "Prestar Libro";

	private final static String REGISTRAR = "Registrar Usuario";

	private final static String AGREGAR = "Agregar Libro";

	private final static String ELIMINAR = "Eliminar prestamo";

	private final static String GOLDY_BORRE_TODO = "Goldy, borre todo!";

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


	private JTextField txtEditorial;

	private JList<Object> libros;

	private JList<Object> prestamos;

	private Collection<Libro> listaLibros;
	
	private Collection<Prestamo> listaPrestamos;

	private JButton prestar;

	private JButton registrar;

	private JButton agregar;

	private JButton eliminar;

	private Libro libroActual;

	private Prestamo prestamoActual;

	private JButton goldyBorreTodo;


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
		listaPrestamos = new LinkedList<>();
		
		user = pUsuario;
		principal = pPrincipal;
		setTitle("Biblioteca Virtual - Bienvenido");
		setVisible(true);
		setSize(820, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		BorderLayout lo = new BorderLayout();
		lo.setHgap(20);
		lo.setVgap(20);
		setLayout(lo);


		//Banner
		JLabel banner = new JLabel();
		ImageIcon img = new ImageIcon("./data/Banner.png");
		banner.setIcon(img);
		add(banner, BorderLayout.NORTH);

		//Libro
		JPanel infoLibro = new JPanel();
		infoLibro.setBorder(new TitledBorder("Información del Libro"));
		infoLibro.setLayout(new GridLayout(4, 2, 0, 50));
		JLabel titulo = new JLabel("Titulo: ");
		JLabel autor = new JLabel("Autor: ");
		JLabel genero = new JLabel("Genero: ");
		JLabel editorial = new JLabel("Editorial: ");

		txtTitulo = new JTextField();
		txtAutor = new JTextField();
		txtGenero = new JTextField();
		txtEditorial = new JTextField();



		txtTitulo.setEditable(false);
		txtAutor.setEditable(false);
		txtGenero.setEditable(false);

		txtEditorial.setEditable(false);

		infoLibro.add(titulo);
		infoLibro.add(txtTitulo);
		infoLibro.add(autor);
		infoLibro.add(txtAutor);
		infoLibro.add(genero);
		infoLibro.add(txtGenero);
		infoLibro.add(editorial);
		infoLibro.add(txtEditorial);
		add(infoLibro, BorderLayout.CENTER);


		//listas
		JPanel listas = new JPanel();
		listas.setPreferredSize(new Dimension(300, 600));
		listas.setLayout(new GridLayout(2, 1, 0, 30));

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
		goldyBorreTodo = new JButton(GOLDY_BORRE_TODO);
		prestar = new JButton(PRESTAR);
		registrar = new JButton(REGISTRAR);
		agregar = new JButton(AGREGAR);
		eliminar = new JButton(ELIMINAR);

		goldyBorreTodo.addActionListener(this);
		prestar.addActionListener(this);
		registrar.addActionListener(this);
		agregar.addActionListener(this);
		eliminar.addActionListener(this);

		goldyBorreTodo.setActionCommand(GOLDY_BORRE_TODO);
		prestar.setActionCommand(PRESTAR);
		registrar.setActionCommand(REGISTRAR);
		agregar.setActionCommand(AGREGAR);
		eliminar.setActionCommand(ELIMINAR);

		//Botón para borrar toda la BD, usar en caso de emergencia o en caso de modificar la BD :^]
		//opciones.add(goldyBorreTodo);
		
		opciones.add(prestar);
		opciones.add(agregar);
		opciones.add(eliminar);
		opciones.add(registrar);

		add(opciones, BorderLayout.SOUTH);
		actualizarLibros();
		actualizarListaPrestamos();
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
		
		else if(e.getActionCommand().equals(PRESTAR))
		{
			if(libroActual == null)
			{
				JOptionPane.showMessageDialog(this, "Seleccione un libro a prestar.", "Error", JOptionPane.ERROR_MESSAGE);
				
			} 
			else
				try 
			{
					String x = JOptionPane.showInputDialog(this, "Inserte nombre del cliente.").trim();
					if(x == null || x.equals(""))
					{
						JOptionPane.showMessageDialog(this, "Nombre invalido.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						user.agregarPrestamo(x, libroActual.darTitulo());
						principal.darBack().darAdmin().registrarPrestamo(x, libroActual.darTitulo());
						actualizarListaPrestamos();
					}
			} 
			catch (Exception e1) 
			{
				JOptionPane.showMessageDialog(this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getActionCommand().equals(AGREGAR))
		{
			new DialogoNuevoLibro(principal, this);
		}
		else if(e.getActionCommand().equals(ELIMINAR))
		{
			if( prestamoActual != null)
			{
				user.eliminarPrestamo(prestamoActual);
				principal.darBack().darAdmin().borrarRegistroPrestamo(prestamoActual.darUserName(), prestamoActual.darTituloLibro());
				JOptionPane.showMessageDialog(this, "Se ha eliminado el prestamo.", "Prestamo", JOptionPane.INFORMATION_MESSAGE);
				actualizarListaPrestamos();
			}
			else
				JOptionPane.showMessageDialog(this, "No hay un prestamo seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if(e.getActionCommand().equals((GOLDY_BORRE_TODO)))
		{
			principal.darBack().darAdmin().borrarTodo();
		}

	}


	private void actualizarPanelLibro() 
	{
		txtTitulo.setText(libroActual.darTitulo());
		txtAutor.setText(libroActual.darAutor());
		txtGenero.setText(libroActual.darGenero());
		txtEditorial.setText(libroActual.darEditorial());
	}


	/**
	 * Actualiza la lista de libros
	 */
	public void actualizarLibros()
	{
		listaLibros = principal.darBack().darAdmin().consultarLibros();
		libros.setListData(listaLibros.toArray());
	}

	private void actualizarListaPrestamos() 
	{
		listaPrestamos = principal.darBack().darAdmin().consultarPrestamos();
		prestamos.setListData( listaPrestamos.toArray());
	}

}
