package model;

public class ReaderInfo {
	private int readerid;
	private String readername;
	private int readertypeid;
	private String readertypename;
	private String idcard;
	private int number;
	private int borrownumber;
	public int getReaderid() {
		return readerid;
	}
	public void setReaderid(int readerid) {
		this.readerid = readerid;
	}
	public String getReadername() {
		return readername;
	}
	public void setReadername(String readername) {
		this.readername = readername;
	}
	public int getReadertypeid() {
		return readertypeid;
	}
	public void setReadertypeid(int readertypeid) {
		this.readertypeid = readertypeid;
	}
	public String getReadertypename() {
		return readertypename;
	}
	public void setReadertypename(String readertypename) {
		this.readertypename = readertypename;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getBorrownumber() {
		return borrownumber;
	}
	public void setBorrownumber(int borrownumber) {
		this.borrownumber = borrownumber;
	}
	
}
