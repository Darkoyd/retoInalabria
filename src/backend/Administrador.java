/**
 * Clase que administra todas las conexiones con la BD.
 */
package backend;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * @author Nicolás Londoño
 *
 */
public class Administrador {

	/**
	 * Archivo de propiedades
	 */
	private Properties config;
	
	/*
	 * Conexión con la base de datos
	 */
	private Connection conexion;

	/*
	 * Constructor del administrador.
	 * @params config Archivo con las propiedades de JDBC
	 */
	public Administrador(Properties config) 
	{
		this.config = config;
		File data = new File( config.getProperty( "admin.db.path" ) );
		System.setProperty( "derby.system.home", data.getAbsolutePath( ) );
	}
	
	/*
	 * Metodo para la conexion a la BD.
	 */
	public void conectarABD() throws SQLException, Exception
	{
		String driver = config.getProperty( "admin.db.driver" );
		Class.forName( driver ).newInstance( );

		String url = config.getProperty( "admin.db.url" );
		conexion = DriverManager.getConnection( url );
		verificarInvariante();

	}

	/*
	 * Metodo para la desconexion de la BD.
	 */
	public void desconectarBD( ) throws SQLException
	{ 
		conexion.close( );
		String down = config.getProperty( "admin.db.shutdown" );
		try
		{
			DriverManager.getConnection( down );
		}
		catch( SQLException e )
		{

		}
		verificarInvariante();
	}

	/*
	 * Metodo de aserción de invariante.
	 */
	private void verificarInvariante() 
	{
		assert config != null : "Conjunto de propiedades inválidas";
	
	}

}
