package view.screen;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import view.MainView;
import controller.LoginController;

public class LoginScreen extends Panel{
	private MainView view;
	private Label username_l;
	private Label password_l;
	private Label error1,error2;
	private TextField username_t;
	private TextField password_t;
	private Checkbox mode;
	private Button login_b;
	private Button reset_b;
	
	public LoginScreen (MainView view)
	{
		this.view = view;
		//label
		username_l=new Label("Username:");
		password_l=new Label("Password:");
		error1=new Label("");
		error2=new Label("");
		
		//textfield
		username_t=new TextField("",10);
		password_t=new TextField("",10);
		password_t.setEchoChar('*');
		
		//checkbox
		mode=new Checkbox("online",true);
		
		//button
		login_b=new Button("Login");
		login_b.addActionListener(new LoginController(this));
		reset_b=new Button("Reset");
		reset_b.addActionListener(new LoginController(this));
		
		//set layout
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		//-------------------------------------------------
		
		//username label
		remove(username_l);
		gbc.gridx = 1; // column
		gbc.gridy = 2; // row
		gbc.insets = new Insets(0, 0, 10, 0); // vertical padding	
		gbl.setConstraints(username_l, gbc);
		add(username_l);

		// username textfield
		remove(username_t);
		gbc.gridx = 2; // column
		gbc.gridy = 2; // row
		gbc.insets = new Insets(0, 0, 10, 0); // vertical padding	
		gbl.setConstraints(username_t, gbc);
		add(username_t);
		
		//password label
		remove(password_l);
		gbc.gridx = 1; // column
		gbc.gridy = 3; // row	
		gbl.setConstraints(password_l, gbc);
		add(password_l);

		// password textfield
		remove(password_t);
		gbc.gridx = 2; // column
		gbc.gridy = 3; // row			
		gbl.setConstraints(password_t, gbc);
		add(password_t);

		// checkbox
		remove(mode);
		gbc.gridx = 1; // column
		gbc.gridy = 4; // row		
		gbc.anchor = GridBagConstraints.SOUTHWEST; // aligning
		gbc.insets = new Insets(0, 0, 30, 0); // vertical padding	
		gbl.setConstraints(mode, gbc);
		add(mode);

		// login button
		remove(login_b);
		gbc.gridx = 1; // column
		gbc.gridy = 6; // row	
		gbc.anchor = GridBagConstraints.EAST; // aligning
		gbc.insets = new Insets(0, 5, 20, 0); // horizontal padding	
		gbl.setConstraints(login_b, gbc);
		add(login_b);

		// cancel button
		remove(reset_b);
		gbc.gridx = 2; // column
		gbc.gridy = 6; // row				
		gbc.anchor = GridBagConstraints.WEST; // aligning		
		gbl.setConstraints(reset_b, gbc);
		add(reset_b);
		
		remove(error1);
		gbc.gridx = 1; // column
		gbc.gridy = 7; // row	
		gbc.gridwidth = 2;	
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 5, 0, 0);		
		gbc.anchor = GridBagConstraints.WEST; // aligning		
		gbl.setConstraints(error1, gbc);
		add(error1);
		
	}
	
	

	
	public boolean isOnline() {
		return mode.getState();
	}

	
	public String getPassword() {
		return password_t.getText();
	}

	
	public String getUsername() {
		return username_t.getText();
	}
	
	public MainView getView() {
		return view;
	}
	
	public void setNull(){
		this.password_t.setText("");
		this.username_t.setText("");
	}
	
	public void setError(){
		this.error1.setText("*INPUT ERROR*");
	}

}
