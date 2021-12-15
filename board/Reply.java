package board;

public class Reply {
	
	private int parentNo;
	private String rBody;
	private int memberIdx;
	private String nickname;
	private String regDate;

	public Reply(int parentNo, String rBody, int memberIdx, String nickname, String regDate) {
		super();
		this.parentNo = parentNo;
		this.rBody = rBody;
		this.memberIdx = memberIdx;
		this.nickname = nickname;
		this.regDate = regDate;
	}
	
	public int getParentNo() {
		return parentNo;
	}
	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}
	public String getrBody() {
		return rBody;
	}
	public void setrBody(String rBody) {
		this.rBody = rBody;
	}
	public String getNickname() {
		return nickname;
	}
	public void setWriter(String nickname) {
		this.nickname = nickname;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
}
