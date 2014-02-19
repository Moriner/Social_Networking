package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import model.type.Friend;

import view.MainView;
import view.screen.FriendProfileScreen;
/**
 * @author Chen Chao
 *
 */
public class FriendProfileController implements ActionListener{


	private MainView mainView;
	private FriendProfileScreen friendProfileScreen;
	private Model model;
	
	public FriendProfileController(FriendProfileScreen friendProfileScreen) {
		
		this.friendProfileScreen = friendProfileScreen;
		mainView = friendProfileScreen.getView();
		model = mainView.getModel();
	}

	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();

		if("Back".equals(select)){
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