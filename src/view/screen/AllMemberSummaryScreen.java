package view.screen;

import java.awt.*;

import controller.AllMemberSummaryController;

import view.MainView;

/**
 * @author Chen Chao
 *
 */
public class AllMemberSummaryScreen extends Panel{
	private MainView view;
	
	private List memberList;
	private Button viewDetail;
	private Button addFriend;
	private Label member;
	private Button back;
	
	public AllMemberSummaryScreen(MainView view) {
		this.view = view;
		
		member = new Label("All_Member:");
		viewDetail = new Button("View");
		addFriend = new Button("*Add");
		back = new Button("Back");
		viewDetail.addActionListener(new AllMemberSummaryController(this));
		addFriend.addActionListener(new AllMemberSummaryController(this));
		back.addActionListener(new AllMemberSummaryController(this));
	}
	public void setMemberList(){	
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		if (memberList != null)
			this.remove(memberList);
		memberList = new List();
		GridBagConstraints gbc = new GridBagConstraints();

		
		remove(member);
		gbc.gridx = 0; // column
		gbc.gridy = 1; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(member, gbc);
		add(member);
		
		remove(memberList);
		gbc.gridx = 0; // column
		gbc.gridy = 2; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.ipady = 35;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(memberList, gbc);
		add(memberList);
		
		remove(viewDetail);
		gbc.gridx = 0; // column
		gbc.gridy = 3; // row	
		gbc.ipady = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 10, 0);  	
		gbl.setConstraints(viewDetail, gbc);
		add(viewDetail);
		
		remove(addFriend);
		gbc.gridx = 1; // column
		gbc.gridy = 3; // row	
		gbc.ipady = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 10, 10, 0);  	
		gbl.setConstraints(addFriend, gbc);
		add(addFriend);
		
		remove(back);
		gbc.gridx = 2; // column
		gbc.gridy = 3; // row	
		gbc.ipady = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 10, 10, 0);  	
		gbl.setConstraints(back, gbc);
		add(back);
	}
	


	public MainView getView(){
		return this.view;
	}
	
	public void setList(String name){
		memberList.add(name);
	}
	
	public String getSelect(){
		return memberList.getSelectedItem();
	}
	
}
