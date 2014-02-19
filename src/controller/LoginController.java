package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import view.MainView;
import view.screen.LoginScreen;

public class LoginController implements ActionListener{

		private MainView mainView;
		private LoginScreen screen;
		private Model model;
		private boolean loginResponse = false;

		public LoginController(LoginScreen screen) {
			this.screen = screen;
			mainView = screen.getView();
			model = mainView.getModel();
		}

		public void actionPerformed(ActionEvent actionEvent) {
        
			// you will need to check which button was selected (refer to lecture notes and lectopia recordings)
			String select=((Button)actionEvent.getSource()).getLabel();
			if("Login".equals(select)){
				loginResponse =
					model.getLogin(
						screen.getUsername(),
						screen.getPassword(),
						screen.isOnline());
				System.out.println(loginResponse);
				if (loginResponse) {
					System.out.println("login");
					if(!screen.isOnline()){
						mainView.getMenuScreen().setVisible();
						mainView.getUnibookMenuBar().setItemnot();
					}
					mainView.getUnibookMenuBar().setMainMenuOn();
					mainView.updateView(mainView.getMenuScreen());
				} else {
					// ...
					mainView.getLoginScreen().setError();
					mainView.getLoginScreen().setNull();
					mainView.updateView(mainView.getLoginScreen());
					// ...	
				}
			}
			if("Reset".equals(select)){
				mainView.getLoginScreen().setNull();
				mainView.updateView(mainView.getLoginScreen());
			}
		}

		public MainView getMainView() {
			return mainView;
		}
}
