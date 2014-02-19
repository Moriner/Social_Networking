package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

import view.MainView;
import view.screen.AllMemberProfileScreen;

/**
 * @author Chen Chao
 *
 */
public class AllMemberProfileController implements ActionListener{


	private MainView mainView;
	private AllMemberProfileScreen allMemberProfileScreen;
	private Model model;
	
	public AllMemberProfileController(AllMemberProfileScreen allMemberProfileScreen) {
		
		this.allMemberProfileScreen = allMemberProfileScreen;
		mainView = allMemberProfileScreen.getView();
		model = mainView.getModel();
	}

	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();

		if("Back".equals(select)){
			mainView.updateView(mainView.getAllMemberSummaryScreen());
		}
	}

}