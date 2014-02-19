package view.screen;

import java.awt.*;

import controller.MyFriendController;

import view.MainView;

/**
 * @author Chen Chao
 *
 */
public class MyFriendScreen extends Panel{
	private MainView view;
	
	private List fiendList;
	private Button viewDetail;
	private Button deleteFriend;
	private Label friend;
	private Button back;
	private Button message;
	
	public MyFriendScreen(MainView view) {
		this.view = view;
		
		friend = new Label("My_Friend:");
		viewDetail = new Button("View");
		deleteFriend = new Button("Delete");
		message = new Button("Send");
		back = new Button("Back");
		viewDetail.addActionListener(new MyFriendController(this));
		deleteFriend.addActionListener(new MyFriendController(this));
		back.addActionListener(new MyFriendController(this));
		message.addActionListener(new MyFriendController(this));
	}
	public void setFriendList(){	
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		if (fiendList != null)
			this.remove(fiendList);
		fiendList = new List();
		GridBagConstraints gbc = new GridBagConstraints();

		
		remove(friend);
		gbc.gridx = 0; // column
		gbc.gridy = 1; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(friend, gbc);
		add(friend);
		
		remove(fiendList);
		gbc.gridx = 0; // column
		gbc.gridy = 2; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		//gbc.ipady = 12;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(fiendList, gbc);
		add(fiendList);
		
		remove(viewDetail);
		gbc.gridx = 0; // column
		gbc.gridy = 3; // row	
		gbc.ipady = 0;
		gbc.ipadx = 13;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(viewDetail, gbc);
		add(viewDetail);
		
		remove(deleteFriend);
		gbc.gridx = 1; // column
		gbc.gridy = 3; // row	
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(deleteFriend, gbc);
		add(deleteFriend);
		
		remove(message);
		gbc.gridx = 0; // column
		gbc.gridy = 4; // row	
		gbc.ipady = 0;
		gbc.ipadx = 13;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(message, gbc);
		add(message);
		
		remove(back);
		gbc.gridx = 1; // column
		gbc.gridy = 4; // row	
		gbc.ipady = 0;
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
	
	public void setList(String name){
		fiendList.add(name);
	}
	
	public String getSelect(){
		return fiendList.getSelectedItem();
	}
	
	public void setVisible(){
		this.message.setVisible(false);
	}
	
}