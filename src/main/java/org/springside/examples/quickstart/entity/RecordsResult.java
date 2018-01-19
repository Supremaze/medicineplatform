package org.springside.examples.quickstart.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="tbl_records_result")
public class RecordsResult extends IdEntity {
	//record id
	private Long parentid;
	//分诊号
	private String res_sn;
	//受检者id
	private Long uid;
	//受检者
	private String customer;
//	private Long dept_id;
	//诊断医生id
	private Long doctor_id;
	//用户id
	private Long assigner_id;
//	private Long assigntime;
	private Double price;
	//分诊时间
	private Date addtime;
	//是否已分诊
//	private Long ckstatus;
	//是否已诊断
	private Long status;
	private Date res_time;
	private Customer cus;
	//诊断内容
	private String res_text;
	public Long getParentid() {
		return parentid;
	}
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	public String getRes_sn() {
		return res_sn;
	}
	public void setRes_sn(String res_sn) {
		this.res_sn = res_sn;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Long getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Long doctor_id) {
		this.doctor_id = doctor_id;
	}
	public Long getAssigner_id() {
		return assigner_id;
	}
	public void setAssigner_id(Long assigner_id) {
		this.assigner_id = assigner_id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	// 设定JSON序列化时的日期格式
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	// 设定JSON序列化时的日期格式
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getRes_time() {
		return res_time;
	}
	public void setRes_time(Date res_time) {
		this.res_time = res_time;
	}
	public String getRes_text() {
		return res_text;
	}
	public void setRes_text(String res_text) {
		this.res_text = res_text;
	}
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	public Customer getCus() {
		return cus;
	}

	public void setCus(Customer cus) {
		this.cus = cus;
	}
	
}