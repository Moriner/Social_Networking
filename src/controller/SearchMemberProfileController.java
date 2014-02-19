package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MAD_UnibookServiceTypes.MemberSummary;

import model.Model;

import view.MainView;
import view.screen.SearchMemberProfileScreen;
/**
 * @author Chen Chao
 *
 */
public class SearchMemberProfileController implements ActionListener{


	private MainView mainView;
	private SearchMemberProfileScreen searchMemberProfileScreen;
	private Model model;
	
	public SearchMemberProfileController(SearchMemberProfileScreen searchMemberProfileScreen) {
		
		this.searchMemberProfileScreen = searchMemberProfileScreen;
		mainView = searchMemberProfileScreen.getView();
		model = mainView.getModel();
	}

	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();

		if("Back".equals(select)){
			int min_age = Integer.parseInt(mainView.getSearchMemberScreen().getMin_Age());
			int max_age = Integer.parseInt(mainView.getSearchMemberScreen().getMax_Age());
			String gender = mainView.getSearchMemberScreen().getGender();
			String programcode = mainView.getSearchMemberScreen().getProgramCode();
			String uName = mainView.getLoginScreen().getUsername();
			mainView.getSearchResultScreen().setResultList();
			MemberSummary[] searchMember = null;
			searchMember = model.searchMember(min_age, max_age, gender, programcode);
			int len = searchMember.length;
			for(int i =0;i<len;i++){	
				boolean fflag = model.isFriend(uName, searchMember[i].getUsername());
				if(fflag == true){
					mainView.getSearchResultScreen().setList(searchMember[i].getUsername());
				}else{
					mainView.getSearchResultScreen().setList("***"+searchMember[i].getUsername());
				}	
			}
			mainView.updateView(mainView.getSearchResultScreen());
		}
	}
}