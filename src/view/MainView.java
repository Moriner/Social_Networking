package view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.ScrollPane;


import model.Model;
import view.menubar.UnibookMenuBar;
import view.screen.AboutMeScreen;
import view.screen.AllMemberProfileScreen;
import view.screen.AllMemberSummaryScreen;
import view.screen.ConfirmationFriendScreen;
import view.screen.ConfirmationSavedScreen;
import view.screen.ConfirmationSentScreen;
import view.screen.FriendProfileScreen;
import view.screen.InboxMessageDetailScreen;
import view.screen.InboxMessageScreen;
import view.screen.LoginScreen;
import view.screen.MenuScreen;
import view.screen.MyFriendScreen;
import view.screen.MyProfileScreen;
import view.screen.SavedMessageDetailScreen;
import view.screen.SavedMessageScreen;
import view.screen.SearchMemberProfileScreen;
import view.screen.SearchMemberScreen;
import view.screen.SearchResultScreen;
import view.screen.SendMessageScreen;
import view.screen.SentMessageDetailScreen;
import view.screen.SentMessageScreen;

public class MainView extends Frame{
	private LoginScreen loginScreen;
	private MenuScreen menuScreen;
	private MyProfileScreen myinfoScreen;
	private AllMemberSummaryScreen allMemberScreen;
	private AllMemberProfileScreen allMemberProfileScreen;
	private MyFriendScreen myFriendScreen;
	private FriendProfileScreen friendScreen;
	private SearchMemberScreen searchMemberScreen;
	private SearchResultScreen searchResultScreen;
	private SearchMemberProfileScreen searchMemberProfileScreen;
	private SendMessageScreen sendMessageScreen;
	private SentMessageScreen sentMessageScreen;
	private InboxMessageScreen inboxMessageScreen;
	private SentMessageDetailScreen sentMessageDetailScreen;
	private InboxMessageDetailScreen inboxMessageDetailScreen;
	private SavedMessageScreen savedMessageScreen;
	private SavedMessageDetailScreen savedMessageDetailScreen;
	private AboutMeScreen aboutMeScreen;
	private ConfirmationFriendScreen confirmationFriendScreen;
	private ConfirmationSavedScreen confirmationSavedScreen;
	private ConfirmationSentScreen confirmationSentScreen;
	private ScrollPane scrollPane;
	private UnibookMenuBar menuBar;
	
	private Model model;

		public MainView(Model model) {

			super("UNIbook");
			this.model = model;

			// init custom screens
			loginScreen = new LoginScreen(this);
			menuScreen = new MenuScreen(this);	
			myinfoScreen = new MyProfileScreen(this);
			allMemberScreen = new AllMemberSummaryScreen(this);
			allMemberProfileScreen = new AllMemberProfileScreen(this);
			myFriendScreen = new MyFriendScreen(this);
			friendScreen = new FriendProfileScreen(this);
			searchMemberScreen = new SearchMemberScreen(this);
			searchResultScreen = new SearchResultScreen(this);
			searchMemberProfileScreen = new SearchMemberProfileScreen(this);
			sendMessageScreen = new SendMessageScreen(this);
			sentMessageScreen = new SentMessageScreen(this);
			inboxMessageScreen = new InboxMessageScreen(this);
			sentMessageDetailScreen = new SentMessageDetailScreen(this);
			inboxMessageDetailScreen = new InboxMessageDetailScreen(this);
			savedMessageScreen = new SavedMessageScreen(this);
			savedMessageDetailScreen = new SavedMessageDetailScreen(this);
			aboutMeScreen = new AboutMeScreen(this);
			confirmationFriendScreen = new ConfirmationFriendScreen(this);
			confirmationSavedScreen = new ConfirmationSavedScreen(this);
			confirmationSentScreen = new ConfirmationSentScreen(this);
			// init the scroll pane
			scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);

			// set layout for the Frame	and add the scroll pane
			setLayout(new BorderLayout());
			add(scrollPane, BorderLayout.CENTER);

			// init the custom menu bar and add it to the frame
			menuBar = new UnibookMenuBar(this);
			setMenuBar(menuBar);

			// display the initial (login) screen
			updateView(loginScreen);
		}

		public void updateView(Panel newScreen) {
			scrollPane.removeAll(); // or remove (...);
			scrollPane.add(newScreen, BorderLayout.CENTER);
			this.validate();
		}

		
		public Model getModel() {
			return model;
		}
	
		// ... the remaining getters (e.g. for each individual screen etc.)

	
	public LoginScreen getLoginScreen() {
		return loginScreen;
	}

	
	public MenuScreen getMenuScreen() {
		return menuScreen;
	}


	public MyProfileScreen getMyProfileScreen() {
		return myinfoScreen;
	}
	
	public AllMemberSummaryScreen getAllMemberSummaryScreen(){
		
		return allMemberScreen;
	}
	
	public AllMemberProfileScreen getAllMemberProfileScreen(){
		return allMemberProfileScreen;
	}
	
	public MyFriendScreen getMyFriendScreen(){
		return myFriendScreen;
	}
	
	public FriendProfileScreen getFriendProfileScreen(){
		return friendScreen;
	}
	
	public SearchMemberScreen getSearchMemberScreen(){
		return searchMemberScreen;
	}
	
	public SearchResultScreen getSearchResultScreen(){
		return searchResultScreen;
	}
	
	public SearchMemberProfileScreen getSearchMemberProfileScreen(){
		return this.searchMemberProfileScreen;
	}
	
	public SendMessageScreen getSendMessageScreen(){
		return this.sendMessageScreen;
	}
	
	public SentMessageScreen getSentMessageScreen(){
		return this.sentMessageScreen;
	}
	
	public InboxMessageScreen getInboxMessageScreen(){
		return this.inboxMessageScreen;
	}
	
	public SentMessageDetailScreen getSentMessageDetailScreen(){
		return this.sentMessageDetailScreen;
	}
	
	public InboxMessageDetailScreen getInboxMessageDetailScreen(){
		return this.inboxMessageDetailScreen;
	}
	
	public SavedMessageScreen getSavedMessageScreen(){
		return this.savedMessageScreen;
	}
	
	public SavedMessageDetailScreen getSavedMessageDetailScreen(){
		return this.savedMessageDetailScreen;
	}
	
	public UnibookMenuBar getUnibookMenuBar(){
		return this.menuBar;
	}
	
	public AboutMeScreen getAboutMeScreen(){
		return this.aboutMeScreen;
	}
	
	public ConfirmationFriendScreen getConfirmationFriendScreen(){
		return this.confirmationFriendScreen;
	}
	
	public ConfirmationSavedScreen getConfirmationSavedScreen(){
		return this.confirmationSavedScreen;
	}
	
	public ConfirmationSentScreen getConfirmationSentScreen(){
		return this.confirmationSentScreen;
	}
}
