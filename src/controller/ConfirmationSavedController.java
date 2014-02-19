package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Model;
import model.type.Message;

import view.MainView;
import view.screen.ConfirmationSavedScreen;
/**
 * @author Chen Chao
 *
 */
public class ConfirmationSavedController implements ActionListener{


	private MainView mainView;
	private ConfirmationSavedScreen confirmationSavedScreen;
	private Model model;
	
	public ConfirmationSavedController(ConfirmationSavedScreen confirmationSavedScreen) {
		
		this.confirmationSavedScreen = confirmationSavedScreen;
		mainView = confirmationSavedScreen.getView();
		model = mainView.getModel();
	}

	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();
		if("YES".equals(select)){
			String saved_message = mainView.getSavedMessageScreen().getSelect();
			if(saved_message != null){
				int loc = saved_message.indexOf("-");
				String sender = saved_message.substring(0, loc);
				String timer = saved_message.substring(loc + 5, saved_message.length());
				mainView.getSavedMessageScreen().setSavedMessageList();
				model.DeleteRecivedMessage(sender, timer);
				String uName = mainView.getLoginScreen().getUsername();
				String pass = mainView.getLoginScreen().getPassword();
				Message[] message = null;
				message = model.getRecivedMessage(uName, pass);
				if(message != null){
					int len = message.length;
					if(len>0){
						for(int i = 0;i<len;i++){
							mainView.getSavedMessageScreen().setList(message[i].getSender()+"-----"+message[i].getTime());
						}
					}
				}
				mainView.updateView(mainView.getSavedMessageScreen());
			}
		}
		if("NO".equals(select)){
			mainView.updateView(mainView.getSavedMessageScreen());
		}

	}
}