package model.handler;

import java.rmi.RemoteException;

import javax.xml.rpc.JAXRPCException;

import model.type.LoginUser;
import model.type.Profile;

import MAD_UnibookService.UNIbook;
import MAD_UnibookService.UNIbook_Stub;
import MAD_UnibookServiceTypes.MemberProfile;
import MAD_UnibookServiceTypes.MemberSummary;

/**
 * @author Chen Chao
 *
 */
public class WSModelHandler extends DefaultModelHandler{
	
	private DefaultModelHandler handler;
	private UNIbook wsStub;
	
	public WSModelHandler(){
		wsStub = new UNIbook_Stub();
	}
	
	public boolean getLogin(String uName, String pass, boolean isOnline){
		boolean flag = false;
		//LoginUser login = null;
			UNIbook stub = new UNIbook_Stub();
			try {
				flag = stub.login(uName, pass);
				if(flag == true){
					System.out.println("WS HANDLER: LOGIN\n");
					LoginUser login = new LoginUser(uName, pass);
					previousHandler.setLogin(login);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (JAXRPCException e) {
				e.printStackTrace();
			}finally{
				return flag;
			}
	}

	public Profile getProfile(String user){
		MemberProfile memberProfile = null;
		Profile pro =null;
		try {
			memberProfile = wsStub.getMemberProfile(user);
			 
			if (memberProfile != null){
				System.out.println("WS HANDLER: GET PROFILE\n");
				pro = new Profile(user, memberProfile);
				previousHandler().setProfile(pro);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (JAXRPCException e) {
			e.printStackTrace();
		}
		return pro;
	}
	
	public MemberSummary getSummary(String user){
		MemberSummary memberSummary = null;
		try {
			memberSummary = wsStub.getMemberSummary(user);
			if (memberSummary != null){
				System.out.println("WS HANDLER: GET PROFILE\n");
				previousHandler().setSummary(user, memberSummary);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (JAXRPCException e) {
			e.printStackTrace();
		}
		return memberSummary;
	}
	
}
