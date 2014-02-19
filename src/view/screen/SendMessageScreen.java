package view.screen;

import java.awt.*;

import controller.SendMessageController;


import view.MainView;

/**
 * @author Chen Chao
 *
 */
public class SendMessageScreen extends Panel{
	private MainView view;
	
	private Label content;
	private TextArea Content;
	private Label recipient;
	private Label Recipient;
	private Button back;
	private Button send;
	private Label info;
	private GridBagLayout gbl;
	
	public SendMessageScreen(MainView view) {
		this.view = view;
		
		gbl = new GridBagLayout();
		content = new Label("Content:");
		recipient = new Label("Recipient:");
		back = new Button("Back");
		send = new Button("Send");
		info = new Label("");
		Recipient = new Label();
		Content = new TextArea("",4,20,TextArea.SCROLLBARS_VERTICAL_ONLY);
		back.addActionListener(new SendMessageController(this));
		send.addActionListener(new SendMessageController(this));
	}
	public void setContent(){	
		
		if(info.getText() != null){
			this.remove(info);
			info = new Label("");	
		}
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();

		
		remove(recipient);
		gbc.gridx = 0; // column
		gbc.gridy = 1; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(recipient, gbc);
		add(recipient);
		
		remove(Recipient);
		gbc.gridx = 1; // column
		gbc.gridy = 1; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(Recipient, gbc);
		add(Recipient);
		
		remove(content);
		gbc.gridx = 0; // column
		gbc.gridy = 2; // row	
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 0, 0);  	
		gbl.setConstraints(content, gbc);
		add(content);
		
		remove(Content);
		gbc.gridx = 0; // column
		gbc.gridy = 3; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(Content, gbc);
		add(Content);
		
		remove(send);
		gbc.gridx = 0; // column
		gbc.gridy = 4; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(send, gbc);
		add(send);
		
		remove(back);
		gbc.gridx = 1; // column
		gbc.gridy = 4; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(back, gbc);
		add(back);
		
		remove(info);
		gbc.gridx = 0; // column
		gbc.gridy = 5; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST; 
		gbc.insets = new Insets(0, 0, 20, 0);  	
		gbl.setConstraints(info, gbc);
		add(info);
	}
	


	public MainView getView(){
		return this.view;
	}
	
	public void setText(String content){
		this.Content.setText(content);
	}
	
	public String getText(){
		return Content.getText();
	}
	
	public void setRecipient(String Recipient){
		this.Recipient.setText(Recipient);
		this.Content.setText("");
	}
	
	public void setInfo(String information){
		this.info.setText(information);
	}
	
}
