package model.type;

/**
 * @author chenchao
 *
 */
public class Friend {
	
	private int number;
	private String username;
	private String friendname;

	public Friend(String username){
		this.username = username;
	}
	
	public Friend(int number, String username,String friendname){
		this.number = number;
		this.username = username;
		this.friendname = friendname;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFriendName() {
		return friendname;
	}

	public void setFriendName(String friendname) {
		this.friendname = friendname;
	}
	
	public int getNumber(){
		return this.number;
	}
	
	public void setNumber(int number){
		this.number = number;
	}

}