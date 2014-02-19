package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Model;
import model.type.Friend;

import view.MainView;
import view.screen.ConfirmationFriendScreen;
/**
 * @author Chen Chao
 *
 */
public class ConfirmationFriendController implements ActionListener{


	private MainView mainView;
	private ConfirmationFriendScreen confirmationFriendScreen;
	private Model model;
	
	public ConfirmationFriendController(ConfirmationFriendScreen confirmationFriendScreen) {
		
		this.confirmationFriendScreen = confirmationFriendScreen;
		mainView = confirmationFriendScreen.getView();
		model = mainView.getModel();
	}

	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();
		if("YES".equals(select)){
			String fName = mainView.getMyFriendScreen().getSelect();
			String uName = mainView.getLoginScreen().getUsername();
			model.deleteFriend(uName, fName);
			Friend[] friend = null;
			int len = model.getFriend(uName).length;
			friend = new Friend[len];
			friend = model.getFriend(uName);
			mainView.getMyFriendScreen().setFriendList();
			for(int i = 0; i<len;i++){
				mainView.getMyFriendScreen().setList(friend[i].getFriendName());
			}
			mainView.updateView(mainView.getMyFriendScreen());
		}
		if("NO".equals(select)){
			String uName = mainView.getLoginScreen().getUsername();
			Friend[] friend = null;
			int len = model.getFriend(uName).length;
			friend = new Friend[len];
			friend = model.getFriend(uName);
			mainView.getMyFriendScreen().setFriendList();
			for(int i = 0; i<len;i++){
				mainView.getMyFriendScreen().setList(friend[i].getFriendName());
			}
			mainView.updateView(mainView.getMyFriendScreen());
		}

	}
}