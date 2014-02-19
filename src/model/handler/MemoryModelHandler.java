package model.handler;

import java.util.Vector;

import model.type.Friend;
import model.type.Message;
import model.type.Profile;

import MAD_UnibookServiceTypes.MemberSummary;

/**
 * @author Chen Chao
 *
 */
public class MemoryModelHandler extends DefaultModelHandler{

	private DefaultModelHandler handler;
	private Vector[] vector1;
	private Vector[] vector2;
	private Vector vector3;
	private Vector[] vector4;
	private Vector[] vector5;
	//private Vector vector6;
	
	
	public MemoryModelHandler() {

	}

	
	public boolean getLogin(String uName, String pass, boolean isOnline){
		vector1 = new Vector[2];
		vector1[0] = new Vector();
		vector1[1] = new Vector();
		vector2 = new Vector[2];
		vector2[0] = new Vector();
		vector2[1] = new Vector();
		vector3 = new Vector();
		vector4 = new Vector[5];
		vector4[0] = new Vector();
		vector4[1] = new Vector();
		vector4[2] = new Vector();
		vector4[3] = new Vector();
		vector4[4] = new Vector();
		vector5 = new Vector[5];
		vector5[0] = new Vector();
		vector5[1] = new Vector();
		vector5[2] = new Vector();
		vector5[3] = new Vector();
		vector5[4] = new Vector();
		boolean flag = false;
		flag = nextHandler().getLogin(uName, pass, isOnline);
		return flag;
	}
	
	public boolean addFriend(String uName, String fName){
		return nextHandler().addFriend(uName, fName);
	}
	
	public boolean isFriend(String uName, String fName){
		return nextHandler().isFriend(uName, fName);
	}
	
	public Friend[] getFriend(String uName){
		return nextHandler().getFriend(uName);
	}
	
	public boolean deleteFriend(String uName, String fName){
		return nextHandler().deleteFriend(uName, fName);
	}
	
	public Profile getProfile(String profileName){
		System.out.println("MEMORY HANDLER: GET PROFILE\n");
		Profile temp = new Profile(profileName);
		temp = ProfileSearchCache(profileName);
		
		if (temp.getProfile()!= null){
			System.out.println("MEMORY HANDLER: PROFILE FOUND\n");
			return temp;
		}
		else{
			System.out.println("MEMORY HANDLER: PROFILE NOT FOUND\n");
			return nextHandler().getProfile(profileName);
		}
	}
	public boolean setProfile(Profile pro){
		if(ProfileStoreCache(pro)){
			return true;
		}else return false;
	}

	public MemberSummary getSummary(String summaryName){
		System.out.println("MEMORY HANDLER: GET SUMMARY\n");
		MemberSummary temp = SummarySearchCache(summaryName);
		if (temp.getUsername() != null){
			System.out.println("MEMORY HANDLER: SUMMARY FOUND\n");
			return temp;
		}
		else{
			System.out.println("MEMORY HANDLER: SUMMARY NOT FOUND\n");
			return nextHandler().getSummary(summaryName);
		}
	}

	public boolean setSummary(String summaryName, MemberSummary summary){
		if(SummaryStoreCache(summaryName, summary)){
			return true;
		}else return false;
	}

	public Profile ProfileSearchCache(String profileName){
		int i = vector1[0].size();
		Profile t = new Profile(profileName);
		for(;i>0;i--){
			if (vector1[0].elementAt(i-1).equals(profileName)){
				
				t = (Profile)vector1[1].elementAt(i-1);
				break;
			}
		}
		return t;
	}
	
	public boolean ProfileStoreCache(Profile profile){
		vector1[0].addElement(profile.getUsername());
		vector1[1].addElement(profile);
		System.out.println("MEMORY HANDLER: STORE PROFILE\n");
		return true;
	}


	public MemberSummary SummarySearchCache(String summaryName){
		int i = vector2[0].size();
		MemberSummary t = new MemberSummary();
		for(;i>0;i--){
			if (vector2[0].elementAt(i-1).equals(summaryName)){
				t = (MemberSummary)vector2[1].elementAt(i-1);
				break;
			}
		}
		return t;
		
	}
	
	public boolean SummaryStoreCache(String summaryName, MemberSummary summary){
		vector2[0].addElement(summaryName);
		vector2[1].addElement(summary);
		System.out.println("MEMORY HANDLER: STORE SUMMARY\n");
		return true;
	}
	
	public void storeSentMessage(Message message){
		vector5[0].addElement(message.getSender());
		vector5[1].addElement(message.getTime());
		vector5[2].addElement(message.getRecipient());
		vector5[3].addElement(message.getContent());
		vector5[4].addElement("f");
		System.out.println("MEMORY HANDLER: STORE SENT MESSAGE\n");
		nextHandler().storeSentMessage(message);
	}
	
	public Message[] getRecivedMessage(String uName, String password){
		Message[] message = SearchRecivedMessage(uName);
		if(message != null&&message.length!=0&&message[0]!=null){
			System.out.println("MEMORY HANDLER: GET RECEIVED MESSAGE\n");
			return message;
		}else {
			return nextHandler().getRecivedMessage(uName, password);
		}
	}
	
	public Message[] SearchRecivedMessage(String uName){
		int i = vector4[0].size();
		Message[] message = null;
		System.out.println(i);
		int m= 0;
		for(;i>0;i--){
			if(vector4[2].elementAt(i-1).equals(uName)&&vector4[4].elementAt(i-1).equals("t"))
				m++;
		}
		message = new Message[m];
		int num = vector4[0].size();
		for(;num>0;num--){
			if(vector4[2].elementAt(num-1).equals(uName)&&vector4[4].elementAt(num-1).equals("t")){
				message[m-1] = new Message(vector4[0].elementAt(num-1).toString());
				message[m-1].setSender(vector4[0].elementAt(num-1).toString());
				message[m-1].setTime(vector4[1].elementAt(num-1).toString());
				message[m-1].setRecipient(vector4[2].elementAt(num-1).toString());
				message[m-1].setContent(vector4[3].elementAt(num-1).toString());
				m--;
			}
		}
		return message;
	}
	
	public void storeRecivedMessage(Message message){
		vector4[0].addElement(message.getSender());
		vector4[1].addElement(message.getTime());
		vector4[2].addElement(message.getRecipient());
		vector4[3].addElement(message.getContent());
		vector4[4].addElement("t");
		System.out.println("MEMORY HANDLER: STORE RECEIVED MESSAGE\n");
		nextHandler().storeRecivedMessage(message);
	}
	
	public Message[] getSentMessage(String uName){
		int i = vector5[0].size();
		Message[] message = null;
		int m= 0;
		for(;i>0;i--){
			if(vector5[0].elementAt(i-1).equals(uName)&&vector5[4].elementAt(i-1).equals("f"))
				m++;
		}
		message = new Message[m];
		int num = vector5[0].size();
		for(;num>0;num--){
			if(vector5[0].elementAt(num-1).equals(uName)&&vector5[4].elementAt(num-1).equals("f")){
				message[m-1] = new Message(vector5[0].elementAt(num-1).toString());
				message[m-1].setSender(vector5[0].elementAt(num-1).toString());
				message[m-1].setTime(vector5[1].elementAt(num-1).toString());
				message[m-1].setRecipient(vector5[2].elementAt(num-1).toString());
				message[m-1].setContent(vector5[3].elementAt(num-1).toString());
				m--;
			}
		}
		if(message != null&&message.length!=0&&message[0]!=null){
			System.out.println("MEMORY HANDLER: GET SENT MESSAGE\n");
			return message;
		}else {
			return nextHandler().getSentMessage(uName);
		}
	}
	
	public void setSentMessage(Message[] message){
		if(message != null){
			int i = message.length;
			for(;i>0;i--){
				vector5[0].addElement(message[i-1].getSender());
				vector5[1].addElement(message[i-1].getTime());
				vector5[2].addElement(message[i-1].getRecipient());
				vector5[3].addElement(message[i-1].getContent());
				vector5[4].addElement("f");
			}
			System.out.println("MEMORY HANDLER: STORE SENT MESSAGE\n");
		}
	}
	
	public boolean DeleteSentMessage(String recipient, String timer){
		int i = vector5[0].size();
		boolean flag = false;
		for(;i>0;i--){
			if(vector5[2].elementAt(i-1).equals(recipient)&&vector5[4].elementAt(i-1).equals("f")&&vector5[1].elementAt(i-1).equals(timer)){
				vector5[0].removeElementAt(i-1);
				vector5[1].removeElementAt(i-1);
				vector5[2].removeElementAt(i-1);
				vector5[3].removeElementAt(i-1);
				vector5[4].removeElementAt(i-1);
				flag = true;
			}	
		}
		System.out.println("MEMORY HANDLER: DELETE SENT MESSAGE\n");
		return nextHandler().DeleteSentMessage(recipient, timer);
		
	}
	
	public boolean DeleteRecivedMessage(String sender, String timer){
		boolean flag = false;
		int i = vector4[0].size();
		for(;i>0;i--){
			if(vector4[0].elementAt(i-1).equals(sender)&&vector4[4].elementAt(i-1).equals("t")&&vector4[3].elementAt(i-1).equals(timer)){
				vector4[0].removeElementAt(i-1);
				vector4[1].removeElementAt(i-1);
				vector4[2].removeElementAt(i-1);
				vector4[3].removeElementAt(i-1);
				vector4[4].removeElementAt(i-1);
				flag = true;
			}			
		}
		System.out.println("MEMORY HANDLER: DELETE RECEIVED MESSAGE\n");
		return nextHandler().DeleteRecivedMessage(sender, timer);
	}
	
	public Message getSentMessage(String recipient, String timer){
		Message message = null;
		boolean found = false;
		int i = vector5[0].size();
		for(;i>0;i--){
			if(vector5[2].elementAt(i-1).equals(recipient)&&vector5[4].elementAt(i-1).equals("f")&&vector5[1].elementAt(i-1).equals(timer)){
				message = new Message(vector5[0].elementAt(i-1).toString());
				message.setTime(vector5[1].elementAt(i-1).toString());
				message.setRecipient(vector5[2].elementAt(i-1).toString());
				message.setContent(vector5[3].elementAt(i-1).toString());
				found = true;
			}
		}
		if(found){
			System.out.println("MEMORY HANDLER: GET SENT MESSAGE DETAIL\n");
			return message;
		}
		else{
			return nextHandler().getSentMessage(recipient, timer);
		}
	}
	
	public Message getRecivedMessage(String uName, String sender, String timer){
		Message message = null;
		boolean found = false;
		int i = vector4[0].size();
		for(;i>0;i--){
			if(vector4[0].elementAt(i-1).equals(sender)&&vector4[4].elementAt(i-1).equals("t")&&vector4[1].elementAt(i-1).equals(timer)){
				message = new Message(sender);
				message.setTime(vector4[1].elementAt(i-1).toString());
				message.setRecipient(vector4[2].elementAt(i-1).toString());
				message.setContent(vector4[3].elementAt(i-1).toString());
				found = true;
			}
		}
		if(found){
			System.out.println("MEMORY HANDLER: GET RECEIVED MESSAGE DETAIL\n");
			return message;
		}
		else{
			return nextHandler().getRecivedMessage(uName, sender, timer);
		}
	}
}
