package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MAD_UnibookServiceTypes.MemberSummary;

import model.Model;

import view.MainView;
import view.screen.SearchMemberScreen;

/**
 * @author Chen Chao
 *
 */
public class SearchMemberController implements ActionListener{


	private MainView mainView;
	private SearchMemberScreen searchMemberScreen;
	private Model model;
	
	public SearchMemberController(SearchMemberScreen searchMemberScreen) {
		
		this.searchMemberScreen = searchMemberScreen;
		mainView = searchMemberScreen.getView();
		model = mainView.getModel();
	}

	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();

		if("Back".equals(select)){
			mainView.updateView(mainView.getMenuScreen());
		}
		if("Search".equals(select)){
			String uName = mainView.getLoginScreen().getUsername();
			int min_age = Integer.parseInt(mainView.getSearchMemberScreen().getMin_Age());
			int max_age = Integer.parseInt(mainView.getSearchMemberScreen().getMax_Age());
			String gender = mainView.getSearchMemberScreen().getGender();
			String programcode = mainView.getSearchMemberScreen().getProgramCode();
			if(min_age>max_age){
				mainView.getSearchMemberScreen().setSearch();
				mainView.getSearchMemberScreen().setError("*min_age>max_age*");
				mainView.updateView(mainView.getSearchMemberScreen());
			}else{
				if(!mainView.getSearchMemberScreen().getProgramCode().equals("")){
	
					mainView.getSearchResultScreen().setResultList();
					MemberSummary[] searchMember = null;
					searchMember = model.searchMember(min_age, max_age, gender, programcode);
					if((searchMember != null&&searchMember.length != 0&&searchMember[0] != null)&&(min_age<=max_age)){
						int len = searchMember.length;
						System.out.println(searchMember.length);
						for(int i =0;i<len;i++){
							boolean fflag = model.isFriend(uName, searchMember[i].getUsername());
							if(fflag == true){
								mainView.getSearchResultScreen().setList(searchMember[i].getUsername());
							}else{
								mainView.getSearchResultScreen().setList("***"+searchMember[i].getUsername());
							}		
						}
						mainView.updateView(mainView.getSearchResultScreen());
					}else {
						mainView.getSearchMemberScreen().setSearch();
						mainView.getSearchMemberScreen().setError("*result null*");
						mainView.updateView(mainView.getSearchMemberScreen());
					}
				}else {
					mainView.getSearchMemberScreen().setSearch();
					mainView.getSearchMemberScreen().setError("*result null*");
					mainView.updateView(mainView.getSearchMemberScreen());
				}
			}
		}
	}

}