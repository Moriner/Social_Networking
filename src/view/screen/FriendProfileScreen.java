package view.screen;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import controller.FriendProfileController;

import view.MainView;
import view.util.ImageDisplay;

public class FriendProfileScreen extends Panel {
	private ImageDisplay imagedis;
	private Graphics g;
	private TextField profile;
	private Label username;
	private Label age;
	private Label gender;
	private Label programcode;
	private Label p;
	private Label u;
	private Label a;
	private Label gen;
	private Label pcode;
	private Label status;
	private TextField Status;
	private MainView view;
	private Button back;
	private GridBagLayout gbl;

	public FriendProfileScreen(MainView view) {
		this.view = view;
		gbl= new GridBagLayout();
		profile = new TextField("",30);
		status = new Label("Status:");
		username = new Label("Username:");
		age = new Label("Age:");
		gender = new Label("Gender:");
		programcode = new Label("ProgramCode:");
		p = new Label("Profile:");
		u = new Label("Username:");
		a = new Label("Age:");
		gen = new Label("Gender:");
		pcode = new Label("ProgramCode:");
		back = new Button("Back");
		Status = new TextField("",30);
		back.addActionListener(new FriendProfileController(this));
	}
	
	public void setProfile(byte[] byt){
		if(imagedis!=null)
		 this.remove(imagedis);
		imagedis = new ImageDisplay(byt);
		
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();

		//----------------------------
		remove(u);
		gbc.gridx = 0; // column
		gbc.gridy = 0; // row	
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 2, 0);
		gbl.setConstraints(u, gbc);
		add(u);
		
		remove(username);
		gbc.gridx = 1; // column
		gbc.gridy = 0; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 2, 0);
		gbl.setConstraints(username, gbc);
		add(username);
		
		remove(a);
		gbc.gridx = 0; // column
		gbc.gridy = 1; // row	
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 2, 0);
		gbl.setConstraints(a, gbc);
		add(a);
		
		remove(age);
		gbc.gridx = 1; // column
		gbc.gridy = 1; // row	
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 2, 0);
		gbl.setConstraints(age, gbc);
		add(age);
		
		remove(gen);
		gbc.gridx = 0; // column
		gbc.gridy = 2; // row	
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 2, 0);
		gbl.setConstraints(gen, gbc);
		add(gen);
		
		remove(gender);		
		gbc.gridx = 1; // column
		gbc.gridy = 2; // row	
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 2, 0);
		gbl.setConstraints(gender, gbc);
		add(gender);
		
		remove(pcode);
		gbc.gridx = 0; // column
		gbc.gridy = 3; // row	
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 2, 0);
		gbl.setConstraints(pcode, gbc);
		add(pcode);
		
		remove(programcode);
		gbc.gridx = 1; // column
		gbc.gridy = 3; // row	
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 2, 0);
		gbl.setConstraints(programcode, gbc);
		add(programcode);
		
		remove(imagedis);
		gbc.gridx = 0; // column
		gbc.gridy = 4; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 2, 0);
		gbl.setConstraints(imagedis, gbc);
		add(imagedis);
		
		remove(p);
		gbc.gridx = 0; // column
		gbc.gridy = 5; // row	
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 2, 0);
		gbl.setConstraints(p, gbc);
		add(p);
		
		remove(profile);
		gbc.gridx = 0; // column
		gbc.gridy = 6; // row	
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 2, 0);
		gbl.setConstraints(profile, gbc);
		add(profile);
		
		remove(status);
		gbc.gridx = 0; // column
		gbc.gridy = 7; // row	
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 2, 0);
		gbl.setConstraints(status, gbc);
		add(status);
		
		remove(Status);
		gbc.gridx = 0; // column
		gbc.gridy = 8; // row	
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 2, 0);
		gbl.setConstraints(Status, gbc);
		add(Status);

		remove(back);
		gbc.gridx = 1; // column
		gbc.gridy = 9; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 50, 2, 0);  	
		gbl.setConstraints(back, gbc);
		add(back);
	
	}
	
	public void setProfile(String profile){
		this.profile.setText(profile);
	}
	
	public void setUsername(String username){
		this.username.setText(username);
	}
	
	public void setAge(int age){
		this.age.setText(Integer.toString(age));
	}
	
	public void setGender(String gender){
		this.gender.setText(gender);
	}
	
	public void setProgramcode(String programcode){
		this.programcode.setText(programcode);
	}
	
	public TextField getStatus(){
		return Status;
	}
	
	public String getStatusText(){
		return Status.getText();
	}
	
	public void setDisable(){
		this.profile.setEditable(false);
		this.Status.setEditable(false);
	}
	
	public MainView getView() {
		return view;
	}
	
}