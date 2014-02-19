package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Model;
import model.type.Message;

import view.MainView;
import view.screen.SentMessageScreen;
/**
 * @author Chen Chao
 *
 */
public class SentMessageController implements ActionListener{


	private MainView mainView;
	private SentMessageScreen sentMessageScreen;
	private Model model;
	
	public SentMessageController(SentMessageScreen sentMessageScreen) {
		
		this.sentMessageScreen = sentMessageScreen;
		mainView = sentMessageScreen.getView();
		model = mainView.getModel();
	}

	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();

		if("Back".equals(select)){
			mainView.updateView(mainView.getMenuScreen());
		}
		
		if("View".equals(select)){
			String sent_message = mainView.getSentMessageScreen().getSelect();
			if(sent_message != null){
				int loc = sent_message.indexOf("-");
				String recipient = sent_message.substring(0, loc);
				String timer = sent_message.substring(loc + 5, sent_message.length());
				Message message = null;
				message = model.getSentMessage(recipient, timer);
				mainView.getSentMessageDetailScreen().setContent();
				if(message != null){
					mainView.getSentMessageDetailScreen().setRecipient(message.getRecipient());
					mainView.getSentMessageDetailScreen().setText(message.getContent());
					mainView.getSentMessageDetailScreen().setTime(message.getTime());
				}
				mainView.updateView(mainView.getSentMessageDetailScreen());
			}
		}
		if("Delete".equals(select)){
			String sent_message = mainView.getSentMessageScreen().getSelect();
			if(sent_message != null){
				mainView.updateView(mainView.getConfirmationSentScreen());
			}
		}
	}
}