package ejercicio3;

public class Usuario {
	private String nombre;
	private String apellidos;
	private String email;
	private String login;
	private String contrasena;
	
	//Constructor
	/**
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param login
	 * @param contrsena
	 */
	public Usuario(String nombre, String apellidos, String email, String login,
			String contrasena) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.login = login;
		this.contrasena = contrasena;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the contrsena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * @param contrsena the contrsena to set
	 */
	public void setContrasena(String contrsena) {
		this.contrasena = contrsena;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario nombre=" + nombre + ", apellidos=" + apellidos
				+ ", email=" + email + ", login=" + login + ", contrasena="
				+ contrasena;
	}
	
}
