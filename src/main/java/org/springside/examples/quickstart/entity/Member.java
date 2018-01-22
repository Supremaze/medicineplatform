package org.springside.examples.quickstart.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableList;

//JPA标识
@Entity
@Table(name = "tbl_member")
public class Member extends IdEntity {
	private String username;
	private String realname;
	private String password;
	// admin,user,doctor
	private String roles;
	// 男，女
	private String sex;
	private String avatar;
	private Date regtime;
	private int endtime;
	private String birthday;
	private String intro;
	private String address;
	private String phone;
	private String sfz;
	private String danwei;
	// 0：未审核，1：未通过，2：已通过
	private int status;
	// private String doctorcer;
	// 是否被审核（医生）
	private int ifcheck;
	// 审核客服的id
	private int kefuid;
	// 擅长病种，1：呼吸；2：自闭症；
	private int bingzhong;
	private String salt;
	private String plainPassword;
	private int price;
	//客服不予通过时的说明
	private String content;


	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAddress() {
		return address;
	}

	public String getAvatar() {
		return avatar;
	}

	public int getBingzhong() {
		return bingzhong;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getDanwei() {
		return danwei;
	}

	public int getEndtime() {
		return endtime;
	}

	// public String getDoctorCer() {
	// return doctorcer;
	// }
	// public void setDoctorCer(String doctorcer) {
	// this.doctorcer = doctorcer;
	// }
	public int getIfcheck() {
		return ifcheck;
	}

	public String getIntro() {
		return intro;
	}

	public int getKefuid() {
		return kefuid;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}
	
	// 不持久化到数据库，也不显示在Restful接口的属性.
	@Transient
	@JsonIgnore
	public String getPlainPassword() {
		return plainPassword;
	}
	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	public int getPrice() {
		return price;
	}

	public String getRealname() {
		return realname;
	}

	// 设定JSON序列化时的日期格式
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getRegtime() {
		return regtime;
	}

	@Transient
	@JsonIgnore
	public List<String> getRoleList() {
		// 角色列表在数据库中实际以逗号分隔字符串存储，因此返回不能修改的List.
		return ImmutableList.copyOf(StringUtils.split(roles, ","));
	}

	public String getRoles() {
		return roles;
	}

	public String getSalt() {
		return salt;
	}

	public String getSex() {
		return sex;
	}

	public String getSfz() {
		return sfz;
	}

	public int getStatus() {
		return status;
	}

	public String getUsername() {
		return username;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setBingzhong(int bingzhong) {
		this.bingzhong = bingzhong;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}

	public void setEndtime(int endtime) {
		this.endtime = endtime;
	}

	public void setIfcheck(int ifcheck) {
		this.ifcheck = ifcheck;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public void setKefuid(int kefuid) {
		this.kefuid = kefuid;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	public void setPrice(int price) {
		this.price = price;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public void setRegisterDate(Date currentDate) {
		// TODO Auto-generated method stub

	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setSfz(String sfz) {
		this.sfz = sfz;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


}
