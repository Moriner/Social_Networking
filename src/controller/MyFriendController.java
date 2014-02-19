package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import model.type.Profile;
import model.type.Status;

import view.MainView;
import view.screen.MyFriendScreen;

/**
 * @author Chen Chao
 *
 */
public class MyFriendController implements ActionListener {
	private MainView mainView;
	private MyFriendScreen myFriendScreen;
	private Model model;
	
	public MyFriendController(MyFriendScreen myFriendScreen){
		this.myFriendScreen = myFriendScreen;
		mainView = myFriendScreen.getView();
		model = mainView.getModel();
	}
	
	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();
		if ("Delete".equals(select)){
			String fName = mainView.getMyFriendScreen().getSelect();
			if(fName != null)
			mainView.updateView(mainView.getConfirmationFriendScreen());
		}
		if ("View".equals(select)){
			String uName = mainView.getMyFriendScreen().getSelect();
			if(uName != null){
				MAD_UnibookServiceTypes.MemberSummary summary = model.getSummary(uName);
				Profile profile = model.getProfile(uName);
				Status status = model.getStatus(uName);
			
				mainView.getFriendProfileScreen().setUsername(summary.getUsername());
				mainView.getFriendProfileScreen().setAge(summary.getAge());
				mainView.getFriendProfileScreen().setGender(summary.getGender());
				mainView.getFriendProfileScreen().setProgramcode(summary.getProgramCode());
				
				mainView.getFriendProfileScreen().setProfile(profile.getPhoto());
				mainView.getFriendProfileScreen().setProfile(profile.getProfile());
				
				mainView.getFriendProfileScreen().getStatus().setText(status.getStatus());
				mainView.getFriendProfileScreen().setDisable();
			
				mainView.updateView(mainView.getFriendProfileScreen());
			}
		}
		
		if("Send".equals(select)){
			String uName = mainView.getMyFriendScreen().getSelect();
			if(uName != null){
				mainView.getSendMessageScreen().setContent();
				mainView.getSendMessageScreen().setRecipient(uName);
				mainView.updateView(mainView.getSendMessageScreen());
			}
		}
		if("Back".equals(select)){
			mainView.updateView(mainView.getMenuScreen());
		}
	}
}