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
	private Biblioteca principal;
	
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
		principal = biblo;
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
            principal.darAdmin( ).desconectarBD( );
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
	 * @param esBiblio Booleano si el usuario es un bibliotecario.
	 */
	public void registrarUsuario(String login, String nombre, String contrasena, boolean esBiblio) 
	{
		try 
		{
			principal.darAdmin().registrarUsuario(login, nombre, contrasena, esBiblio);
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
	 * @return Usuario con el login dado.
	 */
	public Usuario consultarUsuario(String login, String contrasena) 
	{
		return principal.darAdmin().consultarUsuario(login, contrasena);
		
	}

}
