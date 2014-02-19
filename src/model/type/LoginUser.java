package model.type;

/**
 * @author chenchao
 *
 */
public class LoginUser {
	
	private String username;
	private String password;

	public LoginUser(String username){
		this.username = username;
	}
	
	public LoginUser(String username,String password){
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}