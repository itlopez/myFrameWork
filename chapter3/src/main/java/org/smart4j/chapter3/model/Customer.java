package org.smart4j.chapter3.model;

/**
 * @author ：lopez
 * @date ：Created in 2019/12/9 21:16
 * @description：
 * @modified By：
 */
public class Customer {
	/** ID */
	private Long id;
	/** 客户名称 */
	private String name;
	/** 联系人 */
	private String contact;
	/** 电话号码 */
	private String telephone;
	/** 邮箱地址 */
	private String email;
	/** 备注 */
	private String remark;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
