package view.screen;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;

import controller.AboutMeController;

import view.MainView;

/**
 * @author Chen Chao
 *
 */
public class AboutMeScreen extends Panel{
	private MainView view;
	
	private Label name;
	private Label Name;
	private Label studentID;
	private Label StudentID;
	private Label Content;
	private Button back;
	
	public AboutMeScreen(MainView view) {
		this.view = view;
		
		name = new Label("Name:");
		Name = new Label("Chao Chen");
		studentID = new Label("Welcome to");
		StudentID = new Label("My application");
		Content = new Label("MAD-----Social Networking");
		back = new Button("Back");
		back.addActionListener(new AboutMeController(this));
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		remove(name);
		gbc.gridx = 0; // column
		gbc.gridy = 1; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(name, gbc);
		add(name);
		
		remove(Name);
		gbc.gridx = 1; // column
		gbc.gridy = 1; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(Name, gbc);
		add(Name);
		
		remove(studentID);
		gbc.gridx = 0; // column
		gbc.gridy = 2; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(studentID, gbc);
		add(studentID);
		
		remove(StudentID);
		gbc.gridx = 1; // column
		gbc.gridy = 2; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(StudentID, gbc);
		add(StudentID);
		
		remove(Content);
		gbc.gridx = 0; // column
		gbc.gridy = 3; // row	
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(Content, gbc);
		add(Content);
		
		remove(back);
		gbc.gridx = 0; // column
		gbc.gridy = 4; // row	
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(back, gbc);
		add(back);
	}

	public MainView getView() {
		return this.view;
	}	
}
