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
	//admin,user,doctor
	private String roles;
	//男，女
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
	//0：未审核，1：未通过，2：已通过
	private int status;
	private String doctorCer;
	//是否被审核（医生）
	private int ifcheck;
	//审核客服的id
	private int kefuid;
	//擅长病种，1：呼吸；2：自闭症；
	private int bingzhong;
	private String salt;
	private String plainPassword;
	private int price;
	public Member(String username, String realname, String password, String roles, String sex, String avatar,
			Date regtime, int endtime, String birthday, String intro, String address, String phone, String sfz,
			String danwei, int status, String doctorCer, int ifcheck, int kefuid, int bingzhong, String salt,
			String plainPassword) {
		super();
		this.username = username;
		this.realname = realname;
		this.password = password;
		this.roles = roles;
		this.sex = sex;
		this.avatar = avatar;
		this.regtime = regtime;
		this.endtime = endtime;
		this.birthday = birthday;
		this.intro = intro;
		this.address = address;
		this.phone = phone;
		this.sfz = sfz;
		this.danwei = danwei;
		this.status = status;
		this.doctorCer = doctorCer;
		this.ifcheck = ifcheck;
		this.kefuid = kefuid;
		this.bingzhong = bingzhong;
		this.salt = salt;
		this.plainPassword = plainPassword;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	@Transient
	@JsonIgnore
	public List<String> getRoleList() {
		// 角色列表在数据库中实际以逗号分隔字符串存储，因此返回不能修改的List.
		return ImmutableList.copyOf(StringUtils.split(roles, ","));
	}

	// 设定JSON序列化时的日期格式
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getRegtime() {
		return regtime;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public int getEndtime() {
		return endtime;
	}
	public void setEndtime(int endtime) {
		this.endtime = endtime;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSfz() {
		return sfz;
	}
	public void setSfz(String sfz) {
		this.sfz = sfz;
	}
	public String getDanwei() {
		return danwei;
	}
	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDoctorCer() {
		return doctorCer;
	}
	public void setDoctorCer(String doctorCer) {
		this.doctorCer = doctorCer;
	}
	public int getIfcheck() {
		return ifcheck;
	}
	public void setIfcheck(int ifcheck) {
		this.ifcheck = ifcheck;
	}
	public int getKefuid() {
		return kefuid;
	}
	public void setKefuid(int kefuid) {
		this.kefuid = kefuid;
	}
	public int getBingzhong() {
		return bingzhong;
	}
	public void setBingzhong(int bingzhong) {
		this.bingzhong = bingzhong;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getPlainPassword() {
		return plainPassword;
	}
	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}
	public void setRegisterDate(Date currentDate) {
		// TODO Auto-generated method stub
		
	}
	
	
}
