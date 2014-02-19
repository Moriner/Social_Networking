package view.screen;

import java.awt.*;

import controller.InboxMessageDetailController;


import view.MainView;

/**
 * @author Chen Chao
 *
 */
public class InboxMessageDetailScreen extends Panel{
	private MainView view;
	
	private Label content;
	private TextArea Content;
	private Label sender;
	private Label Sender;
	private Label timer;
	private Label Timer;
	private Button back;
	private GridBagLayout gbl;
	
	public InboxMessageDetailScreen(MainView view) {
		this.view = view;
		
		gbl = new GridBagLayout();
		content = new Label("Content:");
		sender = new Label("Sender:");
		back = new Button("Back");
		timer = new Label("Time:");
		Timer = new Label();
		Sender = new Label();
		Content = new TextArea("",4,20,TextArea.SCROLLBARS_VERTICAL_ONLY);
		back.addActionListener(new InboxMessageDetailController(this));
	}
	public void setContent(){	
		
		
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();

		
		remove(sender);
		gbc.gridx = 0; // column
		gbc.gridy = 1; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(sender, gbc);
		add(sender);
		
		remove(Sender);
		gbc.gridx = 1; // column
		gbc.gridy = 1; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(Sender, gbc);
		add(Sender);
		
		remove(timer);
		gbc.gridx = 0; // column
		gbc.gridy = 2; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(timer, gbc);
		add(timer);
		
		remove(Timer);
		gbc.gridx = 1; // column
		gbc.gridy = 2; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(Timer, gbc);
		add(Timer);
		
		remove(content);
		gbc.gridx = 0; // column
		gbc.gridy = 3; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 0, 0);  	
		gbl.setConstraints(content, gbc);
		add(content);
		
		remove(Content);
		gbc.gridx = 0; // column
		gbc.gridy = 4; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(Content, gbc);
		add(Content);
	
		remove(back);
		gbc.gridx = 0; // column
		gbc.gridy = 5; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(back, gbc);
		add(back);
	}
	


	public MainView getView(){
		return this.view;
	}
	
	public void setText(String content){
		this.Content.setText(content);
		this.Content.setEditable(false);
	}
	
	public String getText(){
		return Content.getText();
	}
	
	public void setSender(String Sender){
		this.Sender.setText(Sender);
		this.Content.setText("");
	}
	
	public void setTime(String timer){
		this.Timer.setText(timer);
	}
}