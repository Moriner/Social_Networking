package view.screen;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;

import view.MainView;
import controller.MenuController;

public class MenuScreen extends Panel {
	private MainView view;

	private Button myProfile;
	private Button summary;
	private Button friend;
	private Button sentMail;
	private Button receievMail;
	private Button search;
	private Button save;

	public MenuScreen(MainView view) {
		this.view = view;


		myProfile = new Button("View my profile");
		summary = new Button("View all member summaries");
		friend = new Button("View my friends");
		sentMail = new Button("Sent Message Box");
		receievMail = new Button("Received Message Box");
		search = new Button("Search Member");
		save = new Button("Saved Message Box");
		myProfile.addActionListener(new MenuController(this));
		summary.addActionListener(new MenuController(this));
		friend.addActionListener(new MenuController(this));
		sentMail.addActionListener(new MenuController(this));
		receievMail.addActionListener(new MenuController(this));
		search.addActionListener(new MenuController(this));
		save.addActionListener(new MenuController(this));

		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		//----------------------------

		gbc.gridx = 1; // column
		gbc.gridy = 1; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(myProfile, gbc);
		add(myProfile);
				
		gbc.gridx = 1; // column
		gbc.gridy = 2; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(summary, gbc);
		add(summary);
				
		gbc.gridx = 1; // column
		gbc.gridy = 3; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(friend, gbc);
		add(friend);
				
		gbc.gridx = 1; // column
		gbc.gridy = 4; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(sentMail, gbc);
		add(sentMail);
				
		gbc.gridx = 1; // column
		gbc.gridy = 5; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(save, gbc);
		add(save);
		
		gbc.gridx = 1; // column
		gbc.gridy = 6; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(receievMail, gbc);
		add(receievMail);
						
		gbc.gridx = 1; // column
		gbc.gridy = 7; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(search, gbc);
		add(search);
				
		//----------------------------

	}

	/**
	 * @return
	 */
	public MainView getView() {
		return view;
	}

	public void setVisible(){
		this.search.setVisible(false);
		this.receievMail.setVisible(false);
		this.summary.setVisible(false);
		this.myProfile.setVisible(false);
	}

}
