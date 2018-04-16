package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utilidades.GestorArchivos;
import constantesSQL.ConstantesSQL;
import modelo.Producto;
import daos.GenericDAO;
import daos.ProductosDAO;

public class ProductosDAOImpl extends GenericDAO implements ProductosDAO{

	@Override
	public void registrarProducto(Producto p) {
		conectar();
		try {
			PreparedStatement ps = miConnection.prepareStatement(ConstantesSQL.SQL_INSERCION_PRODUCTOS, Statement.RETURN_GENERATED_KEYS);
		
			ps.setString(1, p.getNombre());
			ps.setDouble(2, p.getPrecio());
			ps.execute();
			
			//una vez insertado el registro vamos a pedir un id que se ha autogenerado
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()){
				int idGenerado = rs.getInt(1);
				System.out.println("id generado en bd: " + idGenerado);
				
				// guardar  la imagen del producto en una carpeta nombrada
				// con el mismo id generado
				GestorArchivos.guardarArchivo(p.getImagenSubida(), idGenerado + ".jpg");
			}
			ps.close();
		
		} catch (SQLException e) {
			System.out.println("error en la sql o similar");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		desconectar();
		
	}

	@Override
	public List<Producto> obtenerProductos() {
		conectar();
		List<Producto> productos = new ArrayList<Producto>();
		try {
			PreparedStatement ps = miConnection.prepareStatement(ConstantesSQL.SQL_SELECION_PRODUCTOS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Producto p = new Producto();
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getDouble("precio"));
				p.setRutaImagen(GestorArchivos.rutaArchivo(rs.getInt("id")));
				productos.add(p);
			}// end while
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("posiblemente la sql esta mal");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		desconectar();
		return productos;
	}

}
