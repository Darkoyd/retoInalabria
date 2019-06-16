/**
 * Clase principal de la biblioteca.
 */
package frontend;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import backend.Biblioteca;
import backend.Libro;
import backend.Prestamo;
import backend.Usuario;

/**
 * @author Nicolás Londoño
 */
public class InterfazBiblioteca extends JFrame implements ActionListener
{
	//----------------------------------------------------------------------------------
	//Atributos y Constantes
	//----------------------------------------------------------------------------------

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Asociación con el Back End.
	 */
	private Biblioteca backEnd;
	
	/**
	 * Botón de ingreso.
	 */
	private JButton btnIngreso;
	
	/**
	 * Constante para el ingreso.
	 */
	private final static String INGRESO = "Ingresar";
	
	/**
	 * Constante para la salida.
	 */
	private final static String SALIR = "Salir";
	
	/*
	 * Botón de salida.
	 */
	private JButton btnSalida;

	//----------------------------------------------------------------------------------
	//Métodos
	//----------------------------------------------------------------------------------
	
	/**
	 * Método constructor de la interfáz
	 * @param biblo Back End de la aplicación.
	 */
	public InterfazBiblioteca(Biblioteca biblo)
	{
		backEnd = biblo;
		setTitle("Biblioteca Virtual");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		
		setLayout(new BorderLayout());
		
		JPanel botones = new JPanel();
		botones.setLayout(new GridLayout(1,2));
		
		
		btnIngreso = new JButton(INGRESO);
		btnSalida = new JButton(SALIR);
		
		btnIngreso.addActionListener(this);
		btnSalida.addActionListener(this);
		
		btnIngreso.setActionCommand(INGRESO);
		btnSalida.setActionCommand(SALIR);
		
		botones.setBorder(new TitledBorder("Ingresar:"));
		botones.add(btnIngreso);
		botones.add(btnSalida);
		
		add(botones, BorderLayout.SOUTH);
	}
	
	/**
	 * @return El backend del programa.
	 */
	public Biblioteca darBack()
	{
		return backEnd;
	}
	
	/**
	 * Método principal de la aplicación
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try
		{
			String archivoPropiedades = "./data/config.properties";
			Biblioteca biblioteca = new Biblioteca(archivoPropiedades);
			InterfazBiblioteca interfaz = new InterfazBiblioteca(biblioteca);
			interfaz.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
	/**
     * Cierra la ventana y la aplicación.
     */
    public void dispose( )
    {
        super.dispose( );
        try
        {
            backEnd.darAdmin( ).desconectarBD( );
        }
        catch( SQLException e )
        {
            e.printStackTrace( );
        }
        System.exit( 0 );
    }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand() == INGRESO)
		{
			new DialogoIngreso(this);
		}
		if(e.getActionCommand() == SALIR)
		{
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea salir?");
			if(respuesta == 0)
			{
				dispose();
			}
			else
			{
				
			}
		}
	}

	/**
	 * Método que registra al usuario.
	 * @param login Login del usuario.
	 * @param nombre Nombre del usuario.
	 * @param contrasena Contraseña de ingreso.
	 */
	public void registrarUsuario(String login, String nombre, String contrasena) 
	{
		try 
		{
			backEnd.darAdmin().registrarUsuario(login, nombre, contrasena);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Método que consulta en la DB por el usuario.
	 * @param login Login del usuario.
	 * @param contrasena Contraseña de ingreso.
	 * @return Usuario con el login dado, de no encontrarlo retorna null.
	 */
	public Usuario consultarUsuario(String login, String contrasena) 
	{
		return backEnd.darAdmin().consultarUsuario(login, contrasena);
	}
	
	/**
	 * Método que registra un libro.
	 * @param titulo Titulo del libro.
	 * @param autor Autor del libro.
	 * @param genero Género literario del libro.
	 * @param sinopsis Resumen breve del libro.
	 * @param editorial Editorial del libro.
	 */
	public void registrarLibro(String titulo, String autor, String genero, String sinopsis, String editorial)
	{
		try
		{
			backEnd.darAdmin().registrarLibro(titulo, autor, genero, sinopsis, editorial);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que consulta la BD por el libro
	 * @param titulo Titulo del libro a buscar.
	 * @return Libro con el titulo dado, de no encontrarlo retorna null.
	 */
	public Libro consultarLibro(String titulo)
	{
		return backEnd.darAdmin().consultarLibro(titulo);
	}
	
	/**
	 * Método que registra un prestamo.
	 * @param tituloLibro Titulo del libro a registrar
	 * @param userName 
	 * @param plazo
	 */
	public void registrarPrestamo(String tituloLibro, String userName, Date plazo)
	{
		try
		{
			backEnd.darAdmin().registrarPrestamo(userName, tituloLibro,  plazo);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que consulta la BD por el prestamo.
	 * @param nombre Nombre de quien prestó el libro.
	 * @param titulo Titulo del libro.
	 * @return Prestamo con los parametros anteriores, de no encontrar retorna null.
	 */
	public Prestamo consultarPrestamo(String nombre, String titulo)
	{
		return backEnd.darAdmin().consultarPrestamo(nombre, titulo);
	}

}
