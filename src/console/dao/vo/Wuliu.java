package console.dao.vo;

import java.io.Serializable;
import java.util.Date;

public class Wuliu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Date createTime;
	private String address;
	private String croassName;
	private String toName;
	private int type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCroassName() {
		return croassName;
	}

	public void setCroassName(String croassName) {
		this.croassName = croassName;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Wuliu(int id, Date createTime, String address, String croassName, String toName, int type) {
		super();
		this.id = id;
		this.createTime = createTime;
		this.address = address;
		this.croassName = croassName;
		this.toName = toName;
		this.type = type;
	}

	public Wuliu() {
	}

	@Override
	public String toString() {
		return id + "£¬" + createTime + "£¬" + address + "£¬" + croassName + "£¬" + toName + "£¬" + type;
	}
}
