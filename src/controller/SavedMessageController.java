package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Model;
import model.type.Message;

import view.MainView;
import view.screen.SavedMessageScreen;
/**
 * @author Chen Chao
 *
 */
public class SavedMessageController implements ActionListener{


	private MainView mainView;
	private SavedMessageScreen savedMessageScreen;
	private Model model;
	
	public SavedMessageController(SavedMessageScreen savedMessageScreen) {
		
		this.savedMessageScreen = savedMessageScreen;
		mainView = savedMessageScreen.getView();
		model = mainView.getModel();
	}

	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();

		if("Back".equals(select)){
			mainView.updateView(mainView.getMenuScreen());
		}
		
		if("View".equals(select)){
			String saved_message = mainView.getSavedMessageScreen().getSelect();
			String uName = mainView.getLoginScreen().getUsername();
			if(saved_message != null){
				int loc = saved_message.indexOf("-");
				String sender = saved_message.substring(0, loc);
				String timer = saved_message.substring(loc + 5, saved_message.length());
				Message message = null;
				message = model.getRecivedMessage(uName, sender, timer);
				mainView.getSavedMessageDetailScreen().setContent();
				if(message != null){
					mainView.getSavedMessageDetailScreen().setSender(message.getSender());
					mainView.getSavedMessageDetailScreen().setText(message.getContent());
					mainView.getSavedMessageDetailScreen().setTime(message.getTime());
				}
				mainView.updateView(mainView.getSavedMessageDetailScreen());
			}
		}
		if("Delete".equals(select)){
			String saved_message = mainView.getSavedMessageScreen().getSelect();
			if(saved_message != null){
				mainView.updateView(mainView.getConfirmationSavedScreen());
			}
		}
	}
}