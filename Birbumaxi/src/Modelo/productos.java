package Modelo;

import java.sql.*;

import javax.swing.JOptionPane;

import conexionBase.conexionBD;

public class productos {
    public boolean IngresoProducto(String nombre, int tipo, double stock, double precioCompra, double precioVenta, int categoria, String proveedor, String telefono) {
        String sqlInsertProducto = "INSERT INTO productos (nombre, tipo, stock, precio_compra, precio_venta, categoria) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlSelectProducto = "SELECT id_producto FROM productos WHERE nombre=? AND categoria=? AND tipo=?";
        String sqlInsertPedido = "INSERT INTO Pedidos (id_producto, nombre_P, telefono) VALUES (?, ?, ?)";

        conexionBD conec = new conexionBD();
        Connection conn = conec.conexion();
        PreparedStatement psInsertProducto = null;
        PreparedStatement psSelectProducto = null;
        PreparedStatement psInsertPedido = null;
        ResultSet rsSelectProducto = null;

        try {
            psInsertProducto = conn.prepareStatement(sqlInsertProducto, Statement.RETURN_GENERATED_KEYS);
            psInsertProducto.setString(1, nombre);
            psInsertProducto.setInt(2, tipo);

            if (tipo == 1) {
            	JOptionPane.showMessageDialog(null, "En caso de ser decimal se redondea la cantidad!");
                psInsertProducto.setDouble(3, Math.round(stock));
            } else if (tipo == 2) {
                psInsertProducto.setDouble(3, stock);
            }

            psInsertProducto.setDouble(4, precioCompra);
            psInsertProducto.setDouble(5, precioVenta);
            psInsertProducto.setInt(6, categoria);

            int i = psInsertProducto.executeUpdate();

            if (i > 0) {
                rsSelectProducto = psInsertProducto.getGeneratedKeys();

                if (rsSelectProducto.next()) {
                    String id = rsSelectProducto.getString(1);

                    psInsertPedido = conn.prepareStatement(sqlInsertPedido);
                    psInsertPedido.setString(1, id);
                    psInsertPedido.setString(2, proveedor);
                    psInsertPedido.setString(3, telefono);

                    int j = psInsertPedido.executeUpdate();

                    if (j > 0) {
                        return paraElReporte(id, stock);
                    } else {
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se obtuvo el id generado");
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar el producto: " + e.getMessage());
            return false;
        } finally {
            try {
                if (rsSelectProducto != null) rsSelectProducto.close();
                if (psInsertProducto != null) psInsertProducto.close();
                if (psSelectProducto != null) psSelectProducto.close();
                if (psInsertPedido != null) psInsertPedido.close();
                if (conn != null) conn.close();
                System.out.println("Conexiones cerradas");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
	
	public boolean paraElReporte (String id, double cantidad) {
		String sql = "INSERT INTO pedidosReporte (id_producto, fecha, cantidad) VALUES (?, SYSDATE(), ?)";
	    
	    conexionBD conec = new conexionBD();
	    Connection conn = conec.conexion();
	    PreparedStatement ps = null;

	    try {
	    	ps = conn.prepareStatement(sql);
	    	ps.setString(1, id);
	    	ps.setDouble(2, cantidad);
	    	int funciona = ps.executeUpdate();
	    	if (funciona > 0) {
	    		return true;
	    	} else {
	    		return false;
	    	}
	        
	    } catch (Exception e) {
	    	e.printStackTrace();
	        //JOptionPane.showMessageDialog(null, "No se pudo ingresar el producto: " + e.getMessage());
	        return false;
	    } finally {
	        try {
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	            System.out.println("Conexiones cerradas");
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	}

}
