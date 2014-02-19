package view.screen;

import java.awt.Button;
import java.awt.Choice;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;


import view.MainView;
import controller.SearchMemberController;

public class SearchMemberScreen extends Panel {
	private MainView view;

	private Button search;
	private Button back;
	private Label min_Age;
	private Label max_Age;
	private Label Gender;
	private Label ProgramCode;
	private Choice min_age;
	private Choice max_age;
	private TextField programcode;
	private Choice gender;
	private Label Error;

	public SearchMemberScreen(MainView view) {
		this.view = view;
		
		min_Age = new Label("Min_Age:");
		max_Age = new Label("Max_Age:");
		Gender = new Label("Gender:");
		gender = new Choice();
		Error = new Label("");
		gender.add("M");
		gender.add("F");
		gender.add("Any");
		min_age = new Choice();
		max_age = new Choice();
		for(int i=1; i<100; i++){
			min_age.add(Integer.toString(i));
			max_age.add(Integer.toString(i));
		}
		ProgramCode = new Label("ProgramCode:");
		programcode = new TextField("Any", 10);
		back = new Button("Back");
		search = new Button("Search");
		back.addActionListener(new SearchMemberController(this));
		search.addActionListener(new SearchMemberController(this));
	}
	public void setSearch(){
		if(!Error.getText().equals("")){
			this.remove(Error);
			Error = new Label("");
		}
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		//----------------------------
		
		remove(min_Age);
		gbc.gridx = 0; // column
		gbc.gridy = 1; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(min_Age, gbc);
		add(min_Age);
				
		remove(min_age);		
		gbc.gridx = 1; // column
		gbc.gridy = 1; // row	
		gbc.ipadx = 8;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(min_age, gbc);
		add(min_age);
				
		remove(max_Age);
		gbc.gridx = 0; // column
		gbc.gridy = 2; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(max_Age, gbc);
		add(max_Age);
		
		remove(max_age);		
		gbc.gridx = 1; // column
		gbc.gridy = 2; // row	
		gbc.ipadx = 8;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(max_age, gbc);
		add(max_age);
			
		remove(Gender);		
		gbc.gridx = 0; // column
		gbc.gridy = 3; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(Gender, gbc);
		add(Gender);
		
		remove(gender);				
		gbc.gridx = 1; // column
		gbc.gridy = 3; // row	
		gbc.ipadx = 10;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(gender, gbc);
		add(gender);
		
		remove(ProgramCode);	
		gbc.gridx = 0; // column
		gbc.gridy = 4; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(ProgramCode, gbc);
		add(ProgramCode);
			
		remove(programcode);				
		gbc.gridx = 1; // column
		gbc.gridy = 4; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(programcode, gbc);
		add(programcode);
		
		remove(search);
		gbc.gridx = 0; // column
		gbc.gridy = 5; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(search, gbc);
		add(search);
		
		remove(back);				
		gbc.gridx = 1; // column
		gbc.gridy = 5; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(back, gbc);
		add(back);
		
		remove(Error);				
		gbc.gridx = 0; // column
		gbc.gridy = 6; // row	
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(Error, gbc);
		add(Error);

				
		//----------------------------

	}
	
	/**
	 * @return
	 */
	public MainView getView() {
		return view;
	}
	
	public String getMin_Age(){
		return this.min_age.getSelectedItem();
	}
	
	public String getMax_Age(){
		return this.max_age.getSelectedItem();
	}
	
	public String getGender(){
		return this.gender.getSelectedItem();
	}
	
	public String getProgramCode(){
		return this.programcode.getText();
	}
	
	public void setError(String error){
		this.Error.setText(error);
	}
}