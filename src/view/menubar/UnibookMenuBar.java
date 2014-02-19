package view.menubar;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import view.MainView;

import controller.MenubarController;

public class UnibookMenuBar extends MenuBar {
	private MainView mainView;
	private Menu file;
	private MenuItem exit;
	private Menu mainmenu;
	private Menu messages;
	private MenuItem personal;
	private MenuItem allmember;
	private MenuItem search;
	private MenuItem friend;
	private MenuItem save;
	private MenuItem newmessage;
	private MenuItem sent;
	private Menu model;
	private Menu pda;
	private Menu nokia;
	private MenuItem about;
	private MenuItem horizontal1;
	private MenuItem vertical1;
	private MenuItem horizontal2;
	private MenuItem vertical2;

	public UnibookMenuBar(MainView mainView) {
		super();

		this.mainView = mainView;
		file = new Menu("File");
		mainmenu = new Menu("Main");
		messages = new Menu("Messages");
		exit = new MenuItem("Exit");
		personal = new MenuItem("My Profile");
		allmember = new MenuItem("All Members");
		search = new MenuItem("Search Members");
		friend = new MenuItem("My Friends");
		save = new MenuItem("Saved Messages");
		newmessage = new MenuItem("Read New Messages");
		sent = new MenuItem("Sent Messages");
		about = new MenuItem("About Designer");
		model = new Menu("Resolution");
		pda = new Menu("PDA-style devices");
		nokia = new Menu("Nokia E90 Communicator");
		horizontal1 = new MenuItem("Horizontal-PDA");
		vertical1 = new MenuItem("Vertical-PDA");
		horizontal2 = new MenuItem("Horizontal-Nokia E90");
		vertical2 = new MenuItem("Vertical-Nokia E90");
		file.add(exit);
		pda.add(vertical1);
		pda.add(horizontal1);
		nokia.add(vertical2);
		nokia.add(horizontal2);
		model.add(pda);
		model.add(nokia);
		mainmenu.addSeparator();
		mainmenu.add(personal);
		mainmenu.add(allmember);
		mainmenu.add(search);
		mainmenu.add(friend);
		messages.add(save);
		messages.add(newmessage);
		messages.add(sent);
		mainmenu.addSeparator();
		mainmenu.add(messages);
		mainmenu.add(model);
		mainmenu.add(about);
		this.add(file);
		this.add(mainmenu);
		mainmenu.setEnabled(false);
		exit.addActionListener(new MenubarController(this));
		mainmenu.addActionListener(new MenubarController(this));
		personal.addActionListener(new MenubarController(this));
		allmember.addActionListener(new MenubarController(this));
		search.addActionListener(new MenubarController(this));
		friend.addActionListener(new MenubarController(this));
		save.addActionListener(new MenubarController(this));
		newmessage.addActionListener(new MenubarController(this));
		sent.addActionListener(new MenubarController(this));
		vertical1.addActionListener(new MenubarController(this));
		horizontal1.addActionListener(new MenubarController(this));
		vertical2.addActionListener(new MenubarController(this));
		horizontal2.addActionListener(new MenubarController(this));
	}

	public MainView getView() {
		return mainView;
	}

	public void setMainMenuOff() {
		this.mainmenu.setEnabled(false);
	}

	public void setMainMenuOn() {
		this.mainmenu.setEnabled(true);
	}

	public void setItem() {
		this.personal.setEnabled(true);
		this.allmember.setEnabled(true);
		this.search.setEnabled(true);
		this.newmessage.setEnabled(true);
	}

	public void setItemnot() {
		this.personal.setEnabled(false);
		this.allmember.setEnabled(false);
		this.search.setEnabled(false);
		this.newmessage.setEnabled(false);
	}
}
