package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Model;
import model.type.Message;

import view.MainView;
import view.screen.InboxMessageScreen;
/**
 * @author Chen Chao
 *
 */
public class InboxMessageController implements ActionListener{


	private MainView mainView;
	private InboxMessageScreen inboxMessageScreen;
	private Model model;
	
	public InboxMessageController(InboxMessageScreen inboxMessageScreen) {
		
		this.inboxMessageScreen = inboxMessageScreen;
		mainView = inboxMessageScreen.getView();
		model = mainView.getModel();
	}

	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();

		if("Back".equals(select)){
			mainView.updateView(mainView.getMenuScreen());
		}
		
		if("View".equals(select)){
			String receive_message = mainView.getInboxMessageScreen().getSelect();
			String uName = mainView.getLoginScreen().getUsername();
			if(receive_message != null){
				int loc = receive_message.indexOf("-");
				String sender = receive_message.substring(0, loc);
				String timer = receive_message.substring(loc + 5, receive_message.length());
				Message message = null;
				message = model.getRecivedMessage(uName, sender, timer);
				System.out.println(message);
				mainView.getInboxMessageDetailScreen().setContent();
				if(message != null){
					mainView.getInboxMessageDetailScreen().setSender(message.getSender());
					mainView.getInboxMessageDetailScreen().setText(message.getContent());
					mainView.getInboxMessageDetailScreen().setTime(message.getTime());
				}
				mainView.updateView(mainView.getInboxMessageDetailScreen());
			}
		}
	}
}