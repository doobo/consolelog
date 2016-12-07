package console.dao.vo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Date createTime;
	private String address;
	private String username;
	private String ipadd;
	private int type;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIpadd() {
		return ipadd;
	}

	public void setIpadd(String ipadd) {
		this.ipadd = ipadd;
	}

	public User(int id, Date createTime, String address, String username, String ipadd, int type) {
		super();
		this.id = id;
		this.createTime = createTime;
		this.address = address;
		this.username = username;
		this.ipadd = ipadd;
		this.type = type;
	}

	public User() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id + "£¬" + createTime + "£¬" + address + "£¬" + username + "£¬" + ipadd + "£¬" + type;
	}

}
