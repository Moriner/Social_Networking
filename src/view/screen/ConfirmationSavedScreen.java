package view.screen;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;

import controller.ConfirmationSavedController;


import view.MainView;

/**
 * @author Chen Chao
 *
 */
public class ConfirmationSavedScreen extends Panel{
	private MainView view;
	
	private Label confirmation;
	private Button yes;
	private Button no;
	
	public ConfirmationSavedScreen(MainView view) {
		this.view = view;
		
		confirmation = new Label("ARE YOU SURE TO DELETE THIS?");
		yes = new Button("YES");
		no = new Button("NO");
		yes.addActionListener(new ConfirmationSavedController(this));
		no.addActionListener(new ConfirmationSavedController(this));
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		remove(confirmation);
		gbc.gridx = 0; // column
		gbc.gridy = 1; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(confirmation, gbc);
		add(confirmation);
		
		remove(yes);
		gbc.gridx = 0; // column
		gbc.gridy = 2; // row	
		gbc.gridheight = 1;
		gbc.gridwidth =1;
		gbc.ipadx = 10;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 30, 20, 0);  	
		gbl.setConstraints(yes, gbc);
		add(yes);
		
		remove(no);
		gbc.gridx = 1; // column
		gbc.gridy = 2; // row	
		gbc.gridheight = 1;
		gbc.gridwidth =1;
		gbc.ipadx = 15;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST; 
		gbc.insets = new Insets(0, 5, 20, 40);  	
		gbl.setConstraints(no, gbc);
		add(no);
		
	}

	public MainView getView() {
		return this.view;
	}	
}