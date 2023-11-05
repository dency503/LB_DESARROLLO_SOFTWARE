package procesos;
import java.sql.*;
public class Conexion {
    private Connection conexion;
    public synchronized Connection Conectar(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;dataBaseName=Ferreteria;"
            + "encrypt=true;trustServerCertificate=true";
            this.conexion = DriverManager.getConnection(url, "sa", "admin");
            System.out.println("conexion ok");
            return conexion;
        }catch(SQLException  | ClassNotFoundException e ){
            System.out.println("conexion not ok "+e.toString());
            return null;}
    }
    public synchronized void desconectar(){
        try {
            if (this.conexion!=null)
                this.conexion.close();
            System.out.println("conexion cerrada");
        } catch (SQLException e) {
            System.out.println("error al cerrar "+e.toString());
        }}
}
