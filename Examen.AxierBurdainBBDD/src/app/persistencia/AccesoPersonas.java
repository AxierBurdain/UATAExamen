package app.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.modelo.Personas;
import app.persistencia.Conexion;

public class AccesoPersonas extends Conexion {

	public boolean altaContacto(Personas p1) throws ClassNotFoundException, SQLException {

		// Declaracion de variables
		String sql = "insert into contactos values( 0, ?, ?, ?);";
		PreparedStatement cmd;
		// abrir Conexion
		abrirConexion();
		cmd = miConexion.prepareStatement(sql);
		cmd.setString(1, p1.getNombre());
		cmd.setString(2, p1.getEmail());
		cmd.setString(3, p1.getTelefono());

		return cmd.executeUpdate() > 0;
	}

	public String consultarContacto(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "Select nombre, email, telefono from contactos where id=?";
		PreparedStatement cmd;
		ResultSet rs;
		Personas p1 = null;
		abrirConexion();
		cmd = miConexion.prepareStatement(sql);

		cmd.setInt(1, id);

		rs = cmd.executeQuery();
		if (rs.next()) {
			p1 = new Personas(rs.getString("nombre"), rs.getString("email"), rs.getString("telefono"));
		}
		cerrarConexion();
		if (p1 == null) {
			return " Inexistentes";
		} else
			return p1.toString();
	}

	public ArrayList<Personas> consultarTodos() throws ClassNotFoundException, SQLException {
//			Declaracion variables
		String sql = "Select id, nombre, email, telefono from contactos";
		PreparedStatement cmd;
		ArrayList<Personas> lista = new ArrayList();
		ResultSet rs;

//			Abrir la conexion
		abrirConexion();

//			Obtener el comando de la conexion
		cmd = miConexion.prepareStatement(sql);

//			Obtener la información de la BBDD
		rs = cmd.executeQuery();

		while (rs.next()) {
			Personas p = new Personas(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"),
					rs.getString("telefono"));
			lista.add(p);
		}
//			Cerrar conexion
		cerrarConexion();

		return lista;
	}

	public boolean cambiarDatos(Personas p1) throws ClassNotFoundException, SQLException {

		// Declaracion de variables

		String sql = "Update contactos set nombre=?, email=?, telefono = ? where id = ?;";
		PreparedStatement cmd;
		// abrir Conexion
		abrirConexion();
		cmd = miConexion.prepareStatement(sql);
		cmd.setString(1, p1.getNombre());
		cmd.setString(2, p1.getEmail());
		cmd.setString(3, p1.getTelefono());
		cmd.setInt(4, p1.getId());

		return cmd.executeUpdate() > 0;
	}

	public boolean borrarContacto(int id) throws ClassNotFoundException, SQLException {

		// Declaracion de variables

		String sql = "Delete from contactos where id = ?;";
		PreparedStatement cmd;
		// abrir Conexion
		abrirConexion();
		cmd = miConexion.prepareStatement(sql);

		cmd.setInt(1, id);

		return cmd.executeUpdate() > 0;
	}

}
