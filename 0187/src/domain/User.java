package domain;

/**
 * 用于封装数据的JavaBean
 * @author xlh
 *
 */
public class User {
	private Integer uid;
	private String username;
	private String password;
	private String nickname;
	private String address;
	private String phone;
	private String sex;
	private int lim;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getLim() {
		return lim;
	}
	public void setLim(int lim) {
		this.lim = lim;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password="
				+ password + ", nickname=" + nickname + ", address=" + address
				+ ", phone=" + phone + ", sex=" + sex + ", lim=" + lim + "]";
	}

	
	
}