//Authorship: Nathan Komenkul

package application;

public class User {
	//User Attributes
	private String email;
	private String username;
	private String password;
	private String role;
	
	//User Constructor
	public User(String email, String username, String password, String role) {
			this.email = email;
			this.username = username;
			this.password = password;
			this.role = role;
	}
	
	//Accessor Methods
	public String getEmail() {
		return email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getRole() {
		return role;
	}
	
	//Mutator Methods
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
}
