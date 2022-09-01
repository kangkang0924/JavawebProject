package domain;

public class InfoType {
	private int info_typeid;
	private String info_typename;
	public int getInfo_typeid() {
		return info_typeid;
	}
	public void setInfo_typeid(int info_typeid) {
		this.info_typeid = info_typeid;
	}
	public String getInfo_typename() {
		return info_typename;
	}
	public void setInfo_typename(String info_typename) {
		this.info_typename = info_typename;
	}
	@Override
	public String toString() {
		return "InfoType [info_typeid=" + info_typeid + ", info_typename="
				+ info_typename + "]";
	}
	
}
