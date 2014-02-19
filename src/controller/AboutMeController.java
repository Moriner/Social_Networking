package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Model;

import view.MainView;
import view.screen.AboutMeScreen;
/**
 * @author Chen Chao
 *
 */
public class AboutMeController implements ActionListener{


	private MainView mainView;
	private AboutMeScreen aboutMeScreen;
	private Model model;
	
	public AboutMeController(AboutMeScreen aboutMeScreen) {
		
		this.aboutMeScreen = aboutMeScreen;
		mainView = aboutMeScreen.getView();
		model = mainView.getModel();
	}

	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();
		if("Back".equals(select)){
			mainView.updateView(mainView.getMenuScreen());
		}

	}
}