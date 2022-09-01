package domain;

public class Information {

	private int iid;
	private String itype;
	private String information;
	private String detail;
	private int uid;
	private String phone;
	private String pubtime;
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public String getItype() {
		return itype;
	}
	public void setItype(String itype) {
		this.itype = itype;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPubtime() {
		return pubtime;
	}
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}
	@Override
	public String toString() {
		return "Information [iid=" + iid + ", itype=" + itype
				+ ", information=" + information + ", detail=" + detail
				+ ", uid=" + uid + ", phone=" + phone + ", pubtime=" + pubtime
				+ "]";
	}
	
}
