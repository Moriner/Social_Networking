package model;

import model.type.Friend;
import model.type.Message;
import model.type.Profile;
import model.type.Status;

public interface Model {
	public boolean getLogin(String uName, String pass, boolean isOnline);
	
	public Profile getProfile(String uName);
	
	public MAD_UnibookServiceTypes.MemberSummary getSummary(String uName);
	
	public Status getStatus(String uName);
	
	public MAD_UnibookServiceTypes.MemberSummary[] getAllMember();
	
	public boolean addFriend(String uName, String fName);
	
	public boolean isFriend(String uName, String fName);
	
	public Friend[] getFriend(String uName); 
	
	public boolean deleteFriend(String uName, String fName);
	
	public MAD_UnibookServiceTypes.MemberSummary[] searchMember(int minage, int maxage, String gender, String programcode);

	public boolean sendMessage(String sender, String senderpassword, String recipient, String content);
	
	public void storeSentMessage(Message message);
	
	public void storeRecivedMessage(Message message);
	
	public Message[] getRecivedMessage(String uName, String password);
	
	public Message[] getSentMessage(String uName);
	
	public boolean DeleteSentMessage(String recipient, String timer);
	
	public boolean DeleteRecivedMessage(String sender, String timer);
	
	public Message getSentMessage(String recipient, String timer);
	
	public Message getRecivedMessage(String uName, String sender, String timer);
	
	public Message[] getRecivedMessageFromLine(String uName, String password);
}
