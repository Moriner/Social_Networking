package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


import model.Model;
import model.type.Friend;
import model.type.Message;

import view.MainView;
import view.screen.SendMessageScreen;
/**
 * @author Chen Chao
 *
 */
public class SendMessageController implements ActionListener{


	private MainView mainView;
	private SendMessageScreen sendMessageScreen;
	private Model model;
	
	public SendMessageController(SendMessageScreen sendMessageScreen) {
		
		this.sendMessageScreen = sendMessageScreen;
		mainView = sendMessageScreen.getView();
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
		
		if("Send".equals(select)){
			String recipient = mainView.getMyFriendScreen().getSelect();
			String content = mainView.getSendMessageScreen().getText();
			if((!recipient.equals(""))&&(!content.equals(""))){
				String uName = mainView.getLoginScreen().getUsername();
				String pass = mainView.getLoginScreen().getPassword();
				Date data_time = new Date();
				String t = data_time.toString();
				boolean flag = model.sendMessage(uName, pass, recipient, content);
				if(flag == true){
					Message message = new Message(uName, t, recipient, content);
					model.storeSentMessage(message);
				}
				mainView.getSendMessageScreen().setInfo("Send Successfully");
				mainView.updateView(mainView.getSendMessageScreen());
			}
		}
	}
}