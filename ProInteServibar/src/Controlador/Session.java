package Controlador;

import Controlador.Session;

public class Session {
	private static Vendedor usuario;
	private static boolean isAdmin;

	public static Vendedor getUsuario() {
		return Session.usuario;
	}

	public static boolean isAdmin() {
		return isAdmin;
		
	}

	public static void setUsuario(Vendedor user) {
		// TODO Auto-generated method stub
		Session.usuario = usuario;
	}

	public static void setAdmin(boolean isAdmin) {
		// TODO Auto-generated method stub
		Session.isAdmin = isAdmin;
	}

	
	

	
}
	
	
	