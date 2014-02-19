package model.handler;

import java.rmi.RemoteException;
import java.util.Date;

import javax.xml.rpc.JAXRPCException;

import model.Model;
import model.handler.chain.DefaultChainHandler;
import model.type.Friend;
import model.type.LoginUser;
import model.type.Message;
import model.type.Profile;
import model.type.Status;
import MAD_UnibookService.UNIbook;
import MAD_UnibookService.UNIbook_Stub;
import MAD_UnibookServiceTypes.MemberSummary;

/**
 * @author Chen Chao
 *
 * 
 */
public class DefaultModelHandler implements Model, DefaultChainHandler{

	private DefaultModelHandler nextHandler;
	protected DefaultModelHandler previousHandler;
	private DefaultModelHandler defaultModel;
	
	public DefaultModelHandler() {
	}
	
	public DefaultModelHandler nextHandler(){
		return nextHandler;
	}
	
	public void setNextHandler(DefaultModelHandler handler){
		nextHandler = handler;
	}
	
	public DefaultModelHandler previousHandler(){
		return previousHandler;
	}
	
	public void setPreviousHandler(DefaultModelHandler handler){
		previousHandler = handler;
	}
	
	public boolean getLogin(String uName, String pass, boolean isOnline){
		boolean flag = false;
		flag = nextHandler.getLogin(uName, pass, isOnline);
		return flag;
	}
	
	public boolean setLogin(LoginUser login){
		if(previousHandler().setLogin(login)){
			return true;
		}else return false;
	}
	
	public Status getStatus(String uName){
		Status sta = null;
		String status = null;
		UNIbook stub = new UNIbook_Stub();
		try{
			status = stub.getMemberStatus(uName);
			System.out.println("WS HANDLER: GET STATUS\n");
			if (status != null){
				sta = new Status(uName, status);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (JAXRPCException e) {
			e.printStackTrace();
		}finally{
			return sta;
		}
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
	
	public MemberSummary[] searchMember(int minage, int maxage, String gender, String programcode){
		UNIbook stub = new UNIbook_Stub();
		MemberSummary[] searchMember = null;
		try{
			searchMember = stub.findMembersByCriteria(minage, maxage, gender, programcode);
			System.out.println("WS HANDLER: SEARCH MEMBER\n");
		}catch (RemoteException e) {
			e.printStackTrace();
		} catch (JAXRPCException e) {
			e.printStackTrace();
		}finally{
			return searchMember;
		}
	}
	
	public MemberSummary[] getAllMember(){
		UNIbook stub = new UNIbook_Stub();
		MemberSummary[] allMember = null;
		try{
			allMember = stub.findAllMembers();
			System.out.println("WS HANDLER: FIND ALL MEMBER\n");
		}catch (RemoteException e) {
			e.printStackTrace();
		} catch (JAXRPCException e) {
			e.printStackTrace();
		}finally{
			return allMember;
		}
	}

	public Profile getProfile(String uName) {
		
		return nextHandler().getProfile(uName);
	}
	
	public boolean setProfile(Profile profile){
		if (previousHandler().setProfile(profile)){
			return true;
		}else return false;	
	}

	public MemberSummary getSummary(String uName) {
		return nextHandler().getSummary(uName);
	}

	public boolean setSummary(String uName, MemberSummary summary){
		if(previousHandler().setSummary(uName, summary)){
			return true;
		}else return false;
	}
	
	public boolean sendMessage(String sender, String senderpassword, String recipient, String content){
		UNIbook stub = new UNIbook_Stub();
		boolean flag = false;	
		try{
			flag = stub.sendMessage(sender, senderpassword, recipient, content);
			System.out.println("WS HANDLER: SEND MESSAGE\n");
		}catch (RemoteException e) {
			e.printStackTrace();
		} catch (JAXRPCException e) {
			e.printStackTrace();
		}finally{
			return flag;
		}
	}

	public void storeSentMessage(Message message){
		nextHandler().storeSentMessage(message);
	}
	
	public void storeRecivedMessage(Message message){
		nextHandler().storeRecivedMessage(message);
	}
	
	public Message[] getRecivedMessage(String uName, String password){
		return nextHandler().getRecivedMessage(uName, password);
	}
	
	public void setRecivedMessage(Message[] message){
		previousHandler().setRecivedMessage(message);
	}
	
	public Message[] getSentMessage(String uName){
		return nextHandler().getSentMessage(uName);
	}
	
	public void setSentMessage(Message[] message){
		previousHandler().setSentMessage(message);
	}
	
	public boolean DeleteSentMessage(String recipient, String timer){
		return nextHandler().DeleteSentMessage(recipient, timer);
	}
	
	public boolean DeleteRecivedMessage(String sender, String timer){
		return nextHandler().DeleteRecivedMessage(sender, timer);
	}
	
	public Message getSentMessage(String recipient, String timer){
		return nextHandler().getSentMessage(recipient, timer);
	}
	
	public Message getRecivedMessage(String uName, String sender, String timer){
		return nextHandler().getRecivedMessage(uName , sender, timer);
	}

	public Message[] getRecivedMessageFromLine(String uName, String password){
		Message[] message = null;
		UNIbook stub = new UNIbook_Stub();
		try{
			MAD_UnibookServiceTypes.Message[] m = stub.readNewMessages(uName, password);
			System.out.println("WS HANDLER: GET RECEIVED MESSAGE\n");
			int i = m.length;
			message = new Message[i];
			for(;i>0;i--){
				message[i-1] = new Message(m[i-1].getSender());
				message[i-1].setSender(m[i-1].getSender());
				message[i-1].setRecipient(uName);
				message[i-1].setContent(m[i-1].getContent());
				Date data_time = new Date();
				String t = data_time.toString();
				message[i-1].setTime(t+"-"+Integer.toString(i));
			}
		}catch (RemoteException e) {
			e.printStackTrace();
		} catch (JAXRPCException e) {
			e.printStackTrace();
		}
		return message;
	}

}
