package view.screen;

import java.awt.*;

import controller.SavedMessageController;

import view.MainView;

/**
 * @author Chen Chao
 *
 */
public class SavedMessageScreen extends Panel{
	private MainView view;
	
	private List savedMessageList;
	private Button view_message;
	private Label saved_message;
	private Button delete;
	private Button back;
	
	public SavedMessageScreen(MainView view) {
		this.view = view;
		
		saved_message = new Label("Saved_Message:");
		view_message = new Button("View");
		back = new Button("Back");
		delete = new Button("Delete");
		view_message.addActionListener(new SavedMessageController(this));
		delete.addActionListener(new SavedMessageController(this));
		back.addActionListener(new SavedMessageController(this));
	}
	public void setSavedMessageList(){	
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		if (savedMessageList != null)
			this.remove(savedMessageList);
		savedMessageList = new List();
		GridBagConstraints gbc = new GridBagConstraints();

		
		remove(saved_message);
		gbc.gridx = 0; // column
		gbc.gridy = 1; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 30;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(saved_message, gbc);
		add(saved_message);
		
		remove(savedMessageList);
		gbc.gridx = 0; // column
		gbc.gridy = 2; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 30;
		//gbc.ipadx = 200;
		gbc.ipady = 25;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(savedMessageList, gbc);
		add(savedMessageList);
		
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
		savedMessageList.add(message);
	}
	
	public String getSelect(){
		return savedMessageList.getSelectedItem();
	}
	
}