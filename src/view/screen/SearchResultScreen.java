package view.screen;

import java.awt.*;

import controller.SearchResultController;

import view.MainView;

/**
 * @author Chen Chao
 *
 */
public class SearchResultScreen extends Panel {
	private MainView view;

	private List resultList;
	private Button viewDetail;
	private Button addFriend;
	private Label result;
	private Button back;
	private GridBagLayout gbl;

	public SearchResultScreen(MainView view) {
		this.view = view;
		
		gbl = new GridBagLayout();
		result = new Label("Search_Result:");
		viewDetail = new Button("View");
		addFriend = new Button("*Add");
		back = new Button("Back");
		viewDetail.addActionListener(new SearchResultController(this));
		addFriend.addActionListener(new SearchResultController(this));
		back.addActionListener(new SearchResultController(this));
	}
	public void setResultList() {
		
		
		if (resultList != null)
			this.remove(resultList);
		resultList = new List();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();

		remove(result);
		gbc.gridx = 0; // column
		gbc.gridy = 1; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 10, 0);
		gbl.setConstraints(result, gbc);
		add(result);

		remove(resultList);
		gbc.gridx = 0; // column
		gbc.gridy = 2; // row	
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.ipady = 35;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 10, 0);
		gbl.setConstraints(resultList, gbc);
		add(resultList);

		remove(viewDetail);
		gbc.gridx = 0; // column
		gbc.gridy = 3; // row	
		gbc.ipady = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
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
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 10, 10, 0);
		gbl.setConstraints(addFriend, gbc);
		add(addFriend);

		remove(back);
		gbc.gridx = 2; // column
		gbc.gridy = 3; // row	
		gbc.ipady = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1 ;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 10, 10, 0);
		gbl.setConstraints(back, gbc);
		add(back);
	}

	public MainView getView() {
		return this.view;
	}

	public void setList(String name) {
		resultList.add(name);
	}

	public String getSelect() {
		return resultList.getSelectedItem();
	}

}