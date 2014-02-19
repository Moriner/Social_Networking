package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import model.type.Friend;
import model.type.Message;
import model.type.Profile;
import model.type.Status;
import view.MainView;
import view.screen.MenuScreen;


public class MenuController  implements ActionListener{
	private MainView mainView;
	private MenuScreen menu;
	private Model model;
	
	public MenuController(MenuScreen menu) {
				this.menu = menu;
				mainView = menu.getView();
				model = mainView.getModel();
			}
	
	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();
		if("View my profile".equals(select))
		{
			String uName = mainView.getLoginScreen().getUsername();
			
			MAD_UnibookServiceTypes.MemberSummary summary = model.getSummary(uName);
			Profile profile = model.getProfile(uName);
			Status status = model.getStatus(uName);
			
			mainView.getMyProfileScreen().setUsername(summary.getUsername());
			mainView.getMyProfileScreen().setAge(summary.getAge());
			mainView.getMyProfileScreen().setGender(summary.getGender());
			mainView.getMyProfileScreen().setProgramcode(summary.getProgramCode());
			
			mainView.getMyProfileScreen().setProfile(profile.getPhoto());
			mainView.getMyProfileScreen().setProfile(profile.getProfile());
			
			mainView.getMyProfileScreen().getStatus().setText(status.getStatus());
			mainView.getMyProfileScreen().setDisable();
			
			mainView.updateView(mainView.getMyProfileScreen());
		}
		if("View all member summaries".equals(select)){
			
			MAD_UnibookServiceTypes.MemberSummary[] summary = model.getAllMember();
			int len = summary.length;
			String uName = mainView.getLoginScreen().getUsername();

			mainView.getAllMemberSummaryScreen().setMemberList();
			for(int i = 0; i<len; i++){
				String fName = summary[i].getUsername();
				boolean flag = model.isFriend(uName, fName);
				if(flag == true){
					mainView.getAllMemberSummaryScreen().setList(summary[i].getUsername());
				}else{
					mainView.getAllMemberSummaryScreen().setList("***"+summary[i].getUsername());
				}
			}
			mainView.updateView(mainView.getAllMemberSummaryScreen());
		}
		
		if("View my friends".equals(select)){
			String uName = mainView.getLoginScreen().getUsername();
			Friend[] friend = null;
			int len = model.getFriend(uName).length;
			friend = new Friend[len];
			friend = model.getFriend(uName);
			mainView.getMyFriendScreen().setFriendList();
			for(int i = 0; i<len;i++){
				mainView.getMyFriendScreen().setList(friend[i].getFriendName());
			}
			if(!mainView.getLoginScreen().isOnline()){
				mainView.getMyFriendScreen().setVisible();
			}
			mainView.updateView(mainView.getMyFriendScreen());
		}
		
		if ("Search Member".equals(select)){
			mainView.getSearchMemberScreen().setSearch();
			mainView.updateView(mainView.getSearchMemberScreen());
		}
		
		if ("Sent Message Box".equals(select)){
			String uName = mainView.getLoginScreen().getUsername();
			Message[] message = null;
			message = model.getSentMessage(uName);
			mainView.getSentMessageScreen().setSentMessageList();
			if(message != null){
				int len = message.length;
				for(int i = 0;i<len; i++){
					mainView.getSentMessageScreen().setList(message[i].getRecipient()+"-----"+message[i].getTime());
				}
			}
			mainView.updateView(mainView.getSentMessageScreen());
		}
		
		if ("Received Message Box".equals(select)){
			String uName = mainView.getLoginScreen().getUsername();
			String pass = mainView.getLoginScreen().getPassword();
			Message[] message = null;
			mainView.getInboxMessageScreen().setinboxMessageList();
			message = model.getRecivedMessageFromLine(uName, pass); 
			if(message != null){
				int len = message.length;
				for(int i = 0;i<len; i++){
					model.storeRecivedMessage(message[i]);
					mainView.getInboxMessageScreen().setList(message[i].getSender()+"-----"+message[i].getTime());
				}
			}
			mainView.updateView(mainView.getInboxMessageScreen());
		}
		
		if("Saved Message Box".equals(select)){
			String uName = mainView.getLoginScreen().getUsername();
			String pass = mainView.getLoginScreen().getPassword();
			Message[] message = null;
			message = model.getRecivedMessage(uName, pass);
			mainView.getSavedMessageScreen().setSavedMessageList();
			message = model.getRecivedMessage(uName, pass);
			if(message != null){
				int len = message.length;
				for(int i = 0;i<len; i++){
					mainView.getSavedMessageScreen().setList(message[i].getSender()+"-----"+message[i].getTime());
				}
			}
			mainView.updateView(mainView.getSavedMessageScreen());
		}
		
	}

}
