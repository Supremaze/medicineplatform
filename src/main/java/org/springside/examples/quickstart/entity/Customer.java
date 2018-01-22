package org.springside.examples.quickstart.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableList;

@Entity
@Table(name = "tbl_customer")
public class Customer extends IdEntity {
	private String realname;
	private String sn_customer;
	private String sfz;
	private String sex;
	private int age;
	private String phone;
	private String address;
//	private String zipcode;
	private String email;
//	private int areaid;
	private String danwei;
	private int weight;
	private int height;
	private String tixing;
	private String shenghua;
	private String bingshi;
	private Date addtime;
	private int adduser;
	private int isdelete;
//	private int ifhospital;
//	private int hospitalid;
	private int kefuid;
	private int status;
	private String jhr;//监护人
	private String birth;
//	private Date registerDate;
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "member_id")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSn_customer() {
		return sn_customer;
	}
	public void setSn_customer(String sn_customer) {
		this.sn_customer = sn_customer;
	}
	public String getSfz() {
		return sfz;
	}
	public void setSfz(String sfz) {
		this.sfz = sfz;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDanwei() {
		return danwei;
	}
	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getTixing() {
		return tixing;
	}
	public void setTixing(String tixing) {
		this.tixing = tixing;
	}
	public String getShenghua() {
		return shenghua;
	}
	public void setShenghua(String shenghua) {
		this.shenghua = shenghua;
	}
	public String getBingshi() {
		return bingshi;
	}
	public void setBingshi(String bingshi) {
		this.bingshi = bingshi;
	}
	// 设定JSON序列化时的日期格式
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
//	public int getAdduser() {
//		return adduser;
//	}
//	public void setAdduser(int adduser) {
//		this.adduser = adduser;
//	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public int getKefuid() {
		return kefuid;
	}
	public void setKefuid(int kefuid) {
		this.kefuid = kefuid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getJhr() {
		return jhr;
	}
	public void setJhr(String jhr) {
		this.jhr = jhr;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}

}