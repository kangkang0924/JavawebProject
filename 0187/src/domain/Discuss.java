package domain;

public class Discuss {
	
	private int did;
	private int uid;
	private String comm;
	private String commtime;
	private int iid;
	
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getComm() {
		return comm;
	}
	public void setComm(String comm) {
		this.comm = comm;
	}
	public String getCommtime() {
		return commtime;
	}
	public void setCommtime(String commtime) {
		this.commtime = commtime;
	}
	@Override
	public String toString() {
		return "discuss [did=" + did + ", uid=" + uid + ", comm=" + comm
				+ ", commtime=" + commtime + "]";
	}
	
}
