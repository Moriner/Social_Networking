package model.type;

/**
 * @author chenchao
 *
 */
public class Message {
	
	private String sender;
	private String time;
	private String recipient;
	private String content;

	public Message(String sender){
		this.sender = sender;
	}
	
	public Message(String sender, String time, String recipient,String content){
		this.sender = sender;
		this.time = time;
		this.recipient = recipient;
		this.content = content;
	}
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getTime(){
		return time;
	}
	
	public void setTime(String time){
		this.time = time;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
	public String getContent(){
		return this.content;
	}
	
	public void setContent(String content){
		this.content = content;
	}

}