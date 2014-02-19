package view.screen;

import java.awt.*;

import controller.InboxMessageController;

import view.MainView;

/**
 * @author Chen Chao
 *
 */
public class InboxMessageScreen extends Panel{
	private MainView view;
	
	private List inboxMessageList;
	private Button view_message;
	private Label inbox_message;
	private Button back;
	
	public InboxMessageScreen(MainView view) {
		this.view = view;
		
		inbox_message = new Label("Inbox_Message:");
		view_message = new Button("View");
		back = new Button("Back");
		view_message.addActionListener(new InboxMessageController(this));
		back.addActionListener(new InboxMessageController(this));
	}
	public void setinboxMessageList(){	
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		if (inboxMessageList != null)
			this.remove(inboxMessageList);
		inboxMessageList = new List();
		GridBagConstraints gbc = new GridBagConstraints();

		
		remove(inbox_message);
		gbc.gridx = 0; // column
		gbc.gridy = 1; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(inbox_message, gbc);
		add(inbox_message);
		
		remove(inboxMessageList);
		gbc.gridx = 0; // column
		gbc.gridy = 2; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.ipady = 25;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(inboxMessageList, gbc);
		add(inboxMessageList);
		
		remove(view_message);
		gbc.gridx = 0; // column
		gbc.gridy = 3; // row	
		gbc.ipady = 0;
		gbc.ipadx = 13;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 63, 20, 0);  	
		gbl.setConstraints(view_message, gbc);
		add(view_message);
				
		remove(back);
		gbc.gridx = 2; // column
		gbc.gridy = 3; // row	
		gbc.ipady = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 64, 20, 74);  	
		gbl.setConstraints(back, gbc);
		add(back);
	}
	


	public MainView getView(){
		return this.view;
	}
	
	public void setList(String message){
		inboxMessageList.add(message);
	}
	
	public String getSelect(){
		return inboxMessageList.getSelectedItem();
	}
	
}