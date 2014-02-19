package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.xml.rpc.JAXRPCException;

import MAD_UnibookService.UNIbook_Stub;

import model.Model;

import view.MainView;
import view.screen.MyProfileScreen;

/**
 * @author Chen Chao
 *
 */
public class MyProfileController implements ActionListener{


	private MainView mainView;
	private MyProfileScreen myProfileScreen;
	private Model model;
	
	public MyProfileController(MyProfileScreen myProfileScreen) {
		
		this.myProfileScreen = myProfileScreen;
		mainView = myProfileScreen.getView();
		model = mainView.getModel();
	}

	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();

		if("Back".equals(select)){
			mainView.updateView(mainView.getMenuScreen());
		}
		if("UpdateStatus".equals(select)){
			UNIbook_Stub stub = new UNIbook_Stub();
			String user = mainView.getLoginScreen().getUsername();
			String pass = mainView.getLoginScreen().getPassword();
			String status = mainView.getMyProfileScreen().getStatusText();
			try {
				stub.updateMemberStatus(user, pass, status);
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (JAXRPCException e) {
				e.printStackTrace();
			}
		}
	}

}
