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
	private static int sel = 0;

	public static void main(String[] args) {
		
		boolean end = false;
		System.out.println("------BIENVENIDO------ \n 1.-INSERTAR CICLISTA \n 2.-SOLICITAR DATOS ETAPA \n 3.-SALIR");
		Scanner tec = new Scanner(System.in);
		 
		while(!end) {
			sel = tec.nextInt();
			switch (sel) {
			case 1:
				insert(tec);
				break;
			case 2:	
				getEtapa();
				break;
			case 3:
				end = true;
				break;
			default:
				System.out.println("ERR---NO SE RECONOCE EL COMANDO");				
				break;
			}//end switch
			System.out.println("\n------MENU------ \n 1.-INSERTAR CICLISTA \n 2.-SOLICITAR DATOS ETAPA \n 3.-SALIR");
			
		}//end while

	}

	private static void getEtapa() {


		
		con.getCiclistas();
		
		
	}

	private static void insert(Scanner tec) {
		int id = 1;
		System.out.println("NOMBRE:");
		String nombre = tec.next();
		System.out.println("EQUIPO:");
		String equipo = tec.next();
		System.out.println("TIEMPO (segundos):");
		int tiempo = tec.nextInt();
		System.out.println("DORSAL:");
		int dorsal = tec.nextInt();
		
		con.Update(nombre, equipo, tiempo, dorsal);
			
		
		
		
		
		
		
	}

}
