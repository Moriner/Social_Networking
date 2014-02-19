package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MAD_UnibookServiceTypes.MemberSummary;

import model.Model;
import model.type.Profile;
import model.type.Status;

import view.MainView;
import view.screen.SearchResultScreen;

/**
 * @author Chen Chao
 *
 */
public class SearchResultController  implements ActionListener {
	private MainView mainView;
	private SearchResultScreen searchResultScreen;
	private Model model;
	
	public SearchResultController(SearchResultScreen searchResultScreen){
		this.searchResultScreen = searchResultScreen;
		mainView = searchResultScreen.getView();
		model = mainView.getModel();
	}
	
	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();
		if ("*Add".equals(select)){
			String fName = mainView.getSearchResultScreen().getSelect();
			String uName = mainView.getLoginScreen().getUsername();
			int min_age = Integer.parseInt(mainView.getSearchMemberScreen().getMin_Age());
			int max_age = Integer.parseInt(mainView.getSearchMemberScreen().getMax_Age());
			String gender = mainView.getSearchMemberScreen().getGender();
			String programcode = mainView.getSearchMemberScreen().getProgramCode();
			if (!fName.equals(uName)){
				boolean flag = model.addFriend(uName, fName);
				if(flag == false){
					System.out.println("Already");
				}else {
					System.out.println("add");
					model.getSummary(fName);
					model.getProfile(fName);
				}
				MemberSummary[] summary = model.searchMember(min_age, max_age, gender, programcode);
				int len = summary.length;
				mainView.getSearchResultScreen().setResultList();
				for(int i = 0; i<len; i++){
					String Name = summary[i].getUsername();
					boolean fflag = model.isFriend(uName, Name);
					if(fflag == true){
						mainView.getSearchResultScreen().setList(summary[i].getUsername());
					}else{
						mainView.getSearchResultScreen().setList("***"+summary[i].getUsername());
					}
				}
				mainView.updateView(mainView.getSearchResultScreen());
			}
		}
		if ("View".equals(select)){
			String uName = mainView.getSearchResultScreen().getSelect();
			if(uName != null){
				if(uName.startsWith("***")){
					String left = uName.substring(0,2); 
					String right = uName.substring(2 + 1,uName.length()); 
					uName = right;
				}
				MAD_UnibookServiceTypes.MemberSummary summary = model.getSummary(uName);
				Profile profile = model.getProfile(uName);
				Status status = model.getStatus(uName);
			
				mainView.getSearchMemberProfileScreen().setUsername(summary.getUsername());
				mainView.getSearchMemberProfileScreen().setAge(summary.getAge());
				mainView.getSearchMemberProfileScreen().setGender(summary.getGender());
				mainView.getSearchMemberProfileScreen().setProgramcode(summary.getProgramCode());
				
				mainView.getSearchMemberProfileScreen().setProfile(profile.getPhoto());
				mainView.getSearchMemberProfileScreen().setProfile(profile.getProfile());
				
				mainView.getSearchMemberProfileScreen().setDisable();
				mainView.getSearchMemberProfileScreen().setVisible();
			
				mainView.updateView(mainView.getSearchMemberProfileScreen());
			}
		}
		if("Back".equals(select)){
			mainView.getSearchMemberScreen().setSearch();
			mainView.updateView(mainView.getSearchMemberScreen());
		}
	}

}