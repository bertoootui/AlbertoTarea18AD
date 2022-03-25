package UI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Controller.Connector;

public class Main {
	
	private static Connector con = new Connector();
	private static Connection conn = con.getConnection();

	public static void main(String[] args) {
		
		
		System.out.println("------BIENVENIDO------ \n 1.-INSERTAR CICLISTA \n 2.-SOLICITAR DATOS ETAPA \n 3.-SALIR");
		Scanner tec = new Scanner(System.in);
		int sel = tec.nextInt();
		switch (sel) {
		case 1:
			insert(tec);
			break;
		case 2:	
			getEtapa();
		default:
			break;
		}
		

	}

	private static void getEtapa() {
		String consulta= "SELECT * FROM ciclistas";
		
		ResultSet rs = con.getCiclistas(consulta, conn);
		String[] dat = new String [3];
		
		try {
			while(rs.next())
			{
				System.out.println("ID: " +rs.getInt("idCICLISTAS") + " --- NOMBRE:"+ rs.getString("NOMBRE")+"\n");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void insert(Scanner tec) {
		int id = 1;
		System.out.println("NOMBRE:");
		String nombre = tec.next();
		System.out.println("EQUIPO:");
		String equipo = tec.next();
		System.out.println("TIEMPO (segundos):");
		int tiempo = tec.nextInt();
		
		String consulta = "INSERT INTO ciclistas(NOMBRE,EQUIPO,TIEMPO) VALUES (?,?,?)";
		try {
			PreparedStatement st = conn.prepareStatement(consulta);
			st.setString(1, nombre);
			st.setString(2, equipo);
			st.setInt(3, tiempo);
			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
