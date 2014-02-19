package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import model.type.Profile;
import model.type.Status;

import view.MainView;
import view.screen.AllMemberSummaryScreen;

/**
 * @author Chen Chao
 *
 */
public class AllMemberSummaryController  implements ActionListener {
	private MainView mainView;
	private AllMemberSummaryScreen allMemberScreen;
	private Model model;
	
	public AllMemberSummaryController(AllMemberSummaryScreen allMemberScreen){
		this.allMemberScreen = allMemberScreen;
		mainView = allMemberScreen.getView();
		model = mainView.getModel();
	}
	
	public void actionPerformed(ActionEvent a) {
		String select=((Button)a.getSource()).getLabel();
		if ("*Add".equals(select)){
			String fName = mainView.getAllMemberSummaryScreen().getSelect();
			String uName = mainView.getLoginScreen().getUsername();
			if ((!fName.equals(uName)) && (!fName.startsWith("***"))&&(fName != null)){
				boolean flag = model.addFriend(uName, fName);
				if(flag == false){
					System.out.println("Already");
				}else {
					System.out.println("add");
					model.getSummary(fName);
					model.getProfile(fName);
				}
				MAD_UnibookServiceTypes.MemberSummary[] summary = model.getAllMember();
				int len = summary.length;
				mainView.getAllMemberSummaryScreen().setMemberList();
				for(int i = 0; i<len; i++){
					String Name = summary[i].getUsername();
					boolean fflag = model.isFriend(uName, Name);
					if(fflag == true){
						mainView.getAllMemberSummaryScreen().setList(summary[i].getUsername());
					}else{
						mainView.getAllMemberSummaryScreen().setList("***"+summary[i].getUsername());
					}
				}
				mainView.updateView(mainView.getAllMemberSummaryScreen());
			}
		}
		if ("View".equals(select)){
			String uName = mainView.getAllMemberSummaryScreen().getSelect();
			if(uName != null){
				if(uName.startsWith("***")){
					String left = uName.substring(0,2); 
					String right = uName.substring(2 + 1,uName.length()); 
					uName = right;
					MAD_UnibookServiceTypes.MemberSummary summary = model.getSummary(uName);
					Profile profile = model.getProfile(uName);
					Status status = model.getStatus(uName);
			
					mainView.getAllMemberProfileScreen().setUsername(summary.getUsername());
					mainView.getAllMemberProfileScreen().setAge(summary.getAge());
					mainView.getAllMemberProfileScreen().setGender(summary.getGender());
					mainView.getAllMemberProfileScreen().setProgramcode(summary.getProgramCode());
				
					mainView.getAllMemberProfileScreen().setProfile(profile.getPhoto());
					mainView.getAllMemberProfileScreen().setProfile(profile.getProfile());
				
					mainView.getAllMemberProfileScreen().setDisable();
			
					mainView.updateView(mainView.getAllMemberProfileScreen());
					}
				else{
					MAD_UnibookServiceTypes.MemberSummary summary = model.getSummary(uName);
					Profile profile = model.getProfile(uName);
					Status status = model.getStatus(uName);
			
					mainView.getAllMemberProfileScreen().setUsername(summary.getUsername());
					mainView.getAllMemberProfileScreen().setAge(summary.getAge());
					mainView.getAllMemberProfileScreen().setGender(summary.getGender());
					mainView.getAllMemberProfileScreen().setProgramcode(summary.getProgramCode());
				
					mainView.getAllMemberProfileScreen().setProfile(profile.getPhoto());
					mainView.getAllMemberProfileScreen().setProfile(profile.getProfile());
				
					mainView.getAllMemberProfileScreen().setDisable();
			
					mainView.updateView(mainView.getAllMemberProfileScreen());
				}
			}
		}
		if("Back".equals(select)){
			mainView.updateView(mainView.getMenuScreen());
		}
	}

}
