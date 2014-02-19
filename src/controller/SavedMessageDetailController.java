package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Model;

import view.MainView;
import view.screen.SavedMessageDetailScreen;
/**
 * @author Chen Chao
 *
 */
public class SavedMessageDetailController implements ActionListener{


	private MainView mainView;
	private SavedMessageDetailScreen savedMessageDetailScreen;
	private Model model;
	
	public SavedMessageDetailController(SavedMessageDetailScreen savedMessageDetailScreen) {
		
		this.savedMessageDetailScreen = savedMessageDetailScreen;
		mainView = savedMessageDetailScreen.getView();
		model = mainView.getModel();
	}

	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();

		if("Back".equals(select)){
			mainView.updateView(mainView.getSavedMessageScreen());
		}
	}
}