package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Model;

import view.MainView;
import view.screen.SentMessageDetailScreen;
/**
 * @author Chen Chao
 *
 */
public class SentMessageDetailController implements ActionListener{


	private MainView mainView;
	private SentMessageDetailScreen sentMessageDetailScreen;
	private Model model;
	
	public SentMessageDetailController(SentMessageDetailScreen sentMessageDetailScreen) {
		
		this.sentMessageDetailScreen = sentMessageDetailScreen;
		mainView = sentMessageDetailScreen.getView();
		model = mainView.getModel();
	}

	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();

		if("Back".equals(select)){
			mainView.updateView(mainView.getSentMessageScreen());
		}

	}
}