/**
 * Clase principal de la biblioteca.
 */
package frontend;

import java.sql.*;

import javax.swing.*;

import backend.Biblioteca;

/**
 * @author Nicol�s Londo�o
 */
public class InterfazBiblioteca extends JFrame 
{
	//----------------------------------------------------------------------------------
	//Atributos y Constantes
	//----------------------------------------------------------------------------------

	/**
	 * Constante de serializaci�n
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Asociaci�n con el Back End.
	 */
	private Biblioteca principal;

	//----------------------------------------------------------------------------------
	//M�todos
	//----------------------------------------------------------------------------------
	
	/**
	 * M�todo constructor de la interf�z
	 * @param biblo Back End de la aplicaci�n.
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
	 * M�todo principal de la aplicaci�n
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
     * Cierra la ventana y la aplicaci�n.
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
