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

	/**
	 * Constructor del administrador.
	 * @param config Archivo con las propiedades de JDBC
	 */
	public Administrador(Properties config) 
	{
		this.config = config;
		File data = new File( config.getProperty( "admin.db.path" ) );
		System.setProperty( "derby.system.home", data.getAbsolutePath( ) );
	}
	
	/**
	 * Metodo para la conexion a la BD.
	 * @throws SQLException si encuentra un error de SQL.
	 * @throws Exception si hay un error con el driver.
	 */
	public void conectarABD() throws SQLException, Exception
	{
		String driver = config.getProperty( "admin.db.driver" );
		Class.forName( driver ).newInstance();

		String url = config.getProperty( "admin.db.url" );
		conexion = DriverManager.getConnection( url );
		verificarInvariante();

	}

	/**
	 * Metodo para la desconexion de la BD.
	 * @throws SQLException si encuentra un error de SQL.
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

	/**
	 * Metodo de aserción de invariante.
	 */
	private void verificarInvariante() 
	{
		assert config != null : "Conjunto de propiedades inválidas";
	
	}
	
	/**
	 * Método que inicia la tabla de usuarios.
	 * @throws SQLException si hay un error de SQL.
	 */
	public void iniciarTablaUsuarios() throws SQLException
	{
		Statement s = conexion.createStatement( );

		boolean crearTabla = false;
		try
		{
			s.executeQuery( "SELECT * FROM usuarios WHERE 1=2" );
		}
		catch( SQLException se )
		{
			crearTabla = true;
		}

		if( crearTabla )
		{
			s.execute( "CREATE TABLE usuarios (nombre varchar(50), login varchar(32), contrasena varchar(32), PRIMARY KEY (login))" );
			String sql = "INSERT INTO usuarios (login, nombre, contrasena) VALUES ('admin', 'admin','admin')";
			Statement st = conexion.createStatement();
			st.execute(sql);
		}

		s.close( );
		verificarInvariante();
	}
	
	/**
	 * Método que inicia la tabla de prestamos.
	 * @throws SQLException si hay un error de SQL.
	 */
	public void iniciarTablaPrestamos() throws SQLException
	{
		Statement s = conexion.createStatement( );

		boolean crearTabla = false;
		try
		{
			s.executeQuery( "SELECT * FROM prestamos WHERE 1=2" );
		}
		catch( SQLException se )
		{
			crearTabla = true;
		}
		if( crearTabla )
		{
			s.execute( "CREATE TABLE prestamos (nombre varchar(32), titulo varchar(100), PRIMARY KEY (login, titulo))" );
		}

		s.close( );
		verificarInvariante();
	}
	
	/**
	 * Método que inicia la tabla de libros.
	 * @throws SQLException si ocurre un problema de SQL.
	 */
	public void iniciarTablaLibros() throws SQLException
	{
		Statement s = conexion.createStatement( );

		boolean crearTabla = false;
		try
		{
			s.executeQuery( "SELECT * FROM libros WHERE 1=2" );
		}
		catch( SQLException se )
		{
			crearTabla = true;
		}
		if( crearTabla )
		{
			s.execute( "CREATE TABLE libros (titulo varchar(100), autor varchar(64), genero varchar(32), sinopsis varchar(10000), editorial varchar(32)), PRIMARY KEY (titulo))" );
		}

		s.close( );
		verificarInvariante();
	}
	

	/**
	 * Método que consulta la BD por los usuarios.
	 * @param login Login a buscar.
	 * @param contrasena Contraseña del usuario.
	 * @return Usuario encontrado. Si no encuentra retorna null.
	 */
	public Usuario consultarUsuario(String login, String contrasena) 
	{
		Usuario registro = null;
		try 
		{
			String sql = "SELECT * FROM usuarios WHERE login ='" + login + "' AND contrasena ='" + contrasena +"'" ;

			Statement st = conexion.createStatement( );
			ResultSet resultado = st.executeQuery( sql );

			if( resultado.next( ) )
			{
				String nombre =  resultado.getString(1);
				registro = new Usuario( nombre, login, contrasena);
				resultado.close( );
			}
			else
			{
				resultado.close( );
				return null;
			}

			st.close( );
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
		verificarInvariante();
		return registro;
		
	}
	
	/**
	 * Inserta un usuario a la BD.
	 * @param login Login del usuario.
	 * @param nombre Nombre del usuario.
	 * @param contrasena Contraseña del usuario
	 * @return true si se pudo registrar usuario.
	 * @throws SQLException si ocurre un error de SQL.
	 */
	public boolean registrarUsuario(String login, String nombre, String contrasena) throws SQLException
	{
		if(consultarUsuario(login, contrasena) == null)
		{
		String sql = "INSERT INTO usuarios (login, nombre, contrasena) VALUES ('" + login + "', '" + nombre + "','" + contrasena + "')";
		Statement st = conexion.createStatement();
		st.execute(sql);
		return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Método que consulta la BD por los libros.
	 * @param titulo Titulo del libro a buscar.
	 * @return Libro consultado, retorna null de no encontrarlo.
	 */
	public Libro consultarLibro(String titulo)
	{
		Libro registro = null;
		try 
		{
			String sql = "SELECT * FROM libros WHERE titulo ='" + titulo + "'" ;
	
			Statement st = conexion.createStatement( );
			ResultSet resultado = st.executeQuery( sql );
	
			if( resultado.next( ) )
			{
				String autor =  resultado.getString(2);
				String genero =  resultado.getString(3);
				String sinopsis =  resultado.getString(4);
				String editorial =  resultado.getString(5);
				
				registro = new Libro( titulo, autor, genero, sinopsis, editorial);
				resultado.close( );
			}
			else
			{
				resultado.close( );
				return null;
			}
	
			st.close( );
		} 
		catch (SQLException e) 
		{
	
			e.printStackTrace();
		}
		verificarInvariante();
		return registro;
	}

	/**
	 * Método que registra un libro a la BD.
	 * @param titulo Titulo del libro.
	 * @param autor Autor del libro.
	 * @param genero Genero del libro.
	 * @param sinopsis Sinopsis del libro.
	 * @param editorial Editorial del libro.
	 * @return true si se pudo registrar el libro.
	 * @throws SQLException si ocurrio un error de SQL.
	 */
	public boolean registrarLibro(String titulo, String autor, String genero, String sinopsis, String editorial) throws SQLException
	{
		if(consultarLibro(titulo) == null)
		{
			String sql = "INSERT INTO libros (titulo, autor, genero, sinopsis, editorial) VALUES ('"+ titulo +"','"+ autor +"','"+ genero +"','"+ sinopsis +"','"+ editorial +"')";
			Statement st = conexion.createStatement();
			st.execute(sql);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Método que consulta la tabla de prestamos.
	 * @param nombre Login del usuario al que se le presta.
	 * @param titulo Titulo del libro prestado.
	 * @return Prestamo consultado, retorna null si no se encuentra.
	 */
	public Prestamo consultarPrestamo(String nombre, String titulo)
	{
		Prestamo registro = null;
		try 
		{
			String sql = "SELECT * FROM prestamos WHERE nombre ='" + nombre + "' AND titulo = '" + titulo + "'" ;
	
			Statement st = conexion.createStatement( );
			ResultSet resultado = st.executeQuery( sql );
	
			if( resultado.next( ) )
			{
				registro = new Prestamo( nombre, titulo);
				resultado.close( );
			}
			else
			{
				resultado.close( );
				return null;
			}
	
			st.close( );
		} 
		catch (SQLException e) 
		{
	
			e.printStackTrace();
		}
		verificarInvariante();
		return registro;
	}
	
	/**
	 * Método que registra un prestamo.
	 * @param nombre Login del usuario al que se le presta.
	 * @param titulo Titulo del libro prestado.
	 * @return true si se pudo registrar el prestamo.
	 * @throws SQLException si ocurre un error de SQL.
	 */
	public boolean registrarPrestamo(String nombre, String titulo) throws SQLException
	{
		if(consultarLibro(titulo) == null)
		{
			String sql = "INSERT INTO prestamos (nombre, titulo) VALUES ('"+ nombre +"','"+ titulo +"')";
			Statement st = conexion.createStatement();
			st.execute(sql);
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * @return Todos los libros de la BD.
	 */
	public Collection<Libro> consultarLibros() 
	{
		Collection<Libro> registros = new LinkedList<>();
		String sql = "SELECT * FROM libros";
		try
		{
			Statement st = conexion.createStatement();
			ResultSet resultado = st.executeQuery(sql);

			while(resultado.next())
			{
				String titulo = resultado.getString(1);
				String autor =  resultado.getString(2);
				String genero =  resultado.getString(3);
				String sinopsis =  resultado.getString(4);
				String editorial =  resultado.getString(5);
				Libro registroLibro = new Libro( titulo, autor, genero, sinopsis, editorial);
				registros.add(registroLibro);
			}
			resultado.close( );
			st.close( );
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return registros;
	}
	
	/**
	 * @return Todos los libros de la DB.
	 */
	public Collection<Prestamo> consultarPrestamos()
	{
		Collection<Prestamo> registros = new LinkedList<>();
		String sql = "SELECT * FROM prestamos";
		try
		{
			Statement st = conexion.createStatement( );
			ResultSet resultado = st.executeQuery( sql );
	
			while( resultado.next( ) )
			{
				String nombre = resultado.getString(1);
				String titulo = resultado.getString(2);
				Prestamo registroPrestamo = new Prestamo( nombre, titulo);
				registros.add(registroPrestamo);
			}
			resultado.close();
			st.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return registros;
	}
}
