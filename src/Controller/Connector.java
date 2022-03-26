package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
	private static Connection con = null;
	
	public Connection getConnection()
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ciclistas","root","8860012");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
		
		
	}
	
	public void getCiclistas() {
		
		
		Statement st;
		ResultSet rs = null;
		String consulta= "SELECT * FROM ciclistas ORDER BY TIEMPO";
		String[] dat = new String [3];
		System.out.println(" ID --- NOMBRE --- DORSAL --- TIEMPO --- EQUIPO");
		
		
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(consulta);
			while(rs.next())
			{
				System.out.println(" " +rs.getInt("idCICLISTAS") + " --- "+ rs.getString("NOMBRE")+" ----- "+rs.getInt("DORSAL")+" ----- "+rs.getInt("TIEMPO")
				+"s. ----- :"+rs.getString("EQUIPO"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
	public void Update(String nombre,String equipo, int tiempo, int dorsal)
	{
		try {
			String consulta = "INSERT INTO ciclistas(NOMBRE,EQUIPO,TIEMPO,DORSAL) VALUES (?,?,?,?)";
			PreparedStatement st = con.prepareStatement(consulta);
			
			st.setString(1, nombre);
			st.setString(2, equipo);
			st.setInt(3, tiempo);
			st.setInt(4, dorsal);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
