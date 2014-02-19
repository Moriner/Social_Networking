package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Model;

import view.MainView;
import view.screen.InboxMessageDetailScreen;
/**
 * @author Chen Chao
 *
 */
public class InboxMessageDetailController implements ActionListener{


	private MainView mainView;
	private InboxMessageDetailScreen inboxMessageDetailScreen;
	private Model model;
	
	public InboxMessageDetailController(InboxMessageDetailScreen inboxMessageDetailScreen) {
		
		this.inboxMessageDetailScreen = inboxMessageDetailScreen;
		mainView = inboxMessageDetailScreen.getView();
		model = mainView.getModel();
	}

	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();

		if("Back".equals(select)){
			mainView.updateView(mainView.getInboxMessageScreen());
		}
	}
}