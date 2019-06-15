/**
 * Clase principal de la biblioteca.
 */
package frontend;

import java.sql.*;

import javax.swing.*;

import backend.Biblioteca;

/**
 * @author Nicolás Londoño
 */
public class InterfazBiblioteca extends JFrame 
{
	//----------------------------------------------------------------------------------
	//Atributos y Constantes
	//----------------------------------------------------------------------------------

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Asociación con el Back End.
	 */
	private Biblioteca principal;

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
		setSize(1000, 1000);
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

}
