package conexionBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBD {
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://viaduct.proxy.rlwy.net:10633/birbumaxi?useSSL=false&serverTimezone=UTC";
    public static final String user = "root";
    public static final String password = "iEMZEvADfGxWysRTQfPGRwXfiPbEGuad";

    public static Connection conexion() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
        }
        return conn;
    }
}
