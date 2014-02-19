package view.screen;

import java.awt.*;

import controller.SentMessageController;

import view.MainView;

/**
 * @author Chen Chao
 *
 */
public class SentMessageScreen extends Panel{
	private MainView view;
	
	private List sentMessageList;
	private Button view_message;
	private Label sent_message;
	private Button delete;
	private Button back;
	
	public SentMessageScreen(MainView view) {
		this.view = view;
		
		sent_message = new Label("Sent_Message:");
		view_message = new Button("View");
		back = new Button("Back");
		delete = new Button("Delete");
		view_message.addActionListener(new SentMessageController(this));
		delete.addActionListener(new SentMessageController(this));
		back.addActionListener(new SentMessageController(this));
	}
	public void setSentMessageList(){	
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		if (sentMessageList != null)
			this.remove(sentMessageList);
		sentMessageList = new List();
		GridBagConstraints gbc = new GridBagConstraints();

		
		remove(sent_message);
		gbc.gridx = 0; // column
		gbc.gridy = 1; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 30;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(sent_message, gbc);
		add(sent_message);
		
		remove(sentMessageList);
		gbc.gridx = 0; // column
		gbc.gridy = 2; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 30;
		//gbc.ipadx = 200;
		gbc.ipady = 25;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(sentMessageList, gbc);
		add(sentMessageList);
		
		remove(view_message);
		gbc.gridx = 0; // column
		gbc.gridy = 3; // row	
		gbc.ipady = 0;
		gbc.ipadx = 13;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 35, 20, 0);  	
		gbl.setConstraints(view_message, gbc);
		add(view_message);
		
		remove(delete);
		gbc.gridx = 1; // column
		gbc.gridy = 3; // row	
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 40, 20, 0);  	
		gbl.setConstraints(delete, gbc);
		add(delete);
				
		remove(back);
		gbc.gridx = 2; // column
		gbc.gridy = 3; // row	
		gbc.ipadx = 13;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 40, 20, 35);  	
		gbl.setConstraints(back, gbc);
		add(back);
	}
	


	public MainView getView(){
		return this.view;
	}
	
	public void setList(String message){
		sentMessageList.add(message);
	}
	
	public String getSelect(){
		return sentMessageList.getSelectedItem();
	}
	
}