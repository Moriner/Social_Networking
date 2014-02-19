package model.type;

import model.util.ArrayConverter;
import MAD_UnibookServiceTypes.MemberProfile;

/**
 * @author chenchao
 *
 */
public class Profile {
	private String username;
	private byte[] photo;
	private String profile;

	public Profile(String username){
		this.username=username;
	}
	
	public Profile(String name,MemberProfile profile){
		this.username=name;
		this.profile=profile.getProfile();
		this.photo=ArrayConverter.createByteArray(profile.getPhoto());
	}
	
	public byte[] getPhoto() {
		return photo;
	}

	public String getProfile() {
		return profile;
	}

	public String getUsername() {
		return username;
	}

	public void setPhoto(byte[] is) {
		photo = is;
	}

	public void setProfile(String string) {
		profile = string;
	}

}
