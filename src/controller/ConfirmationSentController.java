package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Model;
import model.type.Message;

import view.MainView;
import view.screen.ConfirmationSentScreen;
/**
 * @author Chen Chao
 *
 */
public class ConfirmationSentController implements ActionListener{


	private MainView mainView;
	private ConfirmationSentScreen confirmationSentScreen;
	private Model model;
	
	public ConfirmationSentController(ConfirmationSentScreen confirmationSentScreen) {
		
		this.confirmationSentScreen = confirmationSentScreen;
		mainView = confirmationSentScreen.getView();
		model = mainView.getModel();
	}

	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();
		if("YES".equals(select)){
			String sent_message = mainView.getSentMessageScreen().getSelect();
			if(sent_message != null){
				int loc = sent_message.indexOf("-");
				String recipient = sent_message.substring(0, loc);
				String timer = sent_message.substring(loc + 5, sent_message.length());
				mainView.getSentMessageScreen().setSentMessageList();
				model.DeleteSentMessage(recipient, timer);
				String uName = mainView.getLoginScreen().getUsername();
				Message[] message = null;
				message = model.getSentMessage(uName);
				if(message != null){
					int len = message.length;
					if(len>0){
						for(int i =0;i<len;i++){
							mainView.getSentMessageScreen().setList(message[i].getRecipient()+"-----"+message[i].getTime());
						}
					}
				}
				mainView.updateView(mainView.getSentMessageScreen());
			}
		}
		if("NO".equals(select)){
			mainView.updateView(mainView.getSentMessageScreen());
		}

	}
}