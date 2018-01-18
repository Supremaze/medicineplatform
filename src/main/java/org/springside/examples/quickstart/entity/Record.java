package org.springside.examples.quickstart.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tbl_record")
public class Record extends IdEntity {
	private String rec_sn;
//	受检人
	private Long customerid;
	private String customer;
//	诊断医生
	private Long assigned;
	private Date assigntime;
	private Long assigner_id;
//	添加人
	private Long operator_id; 
	private Date addtime;
//	0：未审核，1：审核通过未选医生，2：已选医生未诊断（分诊后添加recordresult），3：已诊断，4：未通过审核
	private Long status;
//	审核客服
	private	Long kefuid;
//	private Long ifcheck;
// 病种，1：呼吸；2：自闭症；
	private Long bingzhong;
//	是否已选医生
//	private Long flag;
	public String getRec_sn() {
		return rec_sn;
	}
	public void setRec_sn(String rec_sn) {
		this.rec_sn = rec_sn;
	}
	public Long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Long getAssigned() {
		return assigned;
	}
	public void setAssigned(Long assigned) {
		this.assigned = assigned;
	}
	// 设定JSON序列化时的日期格式
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
		public Date getAssigntime() {
			return assigntime;
		}
	public void setAssigntime(Date assigntime) {
		this.assigntime = assigntime;
	}
	public Long getAssigner_id() {
		return assigner_id;
	}
	public void setAssigner_id(Long assigner_id) {
		this.assigner_id = assigner_id;
	}
	public Long getOperator_id() {
		return operator_id;
	}
	public void setOperator_id(Long operator_id) {
		this.operator_id = operator_id;
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
	public Long getKefuid() {
		return kefuid;
	}
	public void setKefuid(Long kefuid) {
		this.kefuid = kefuid;
	}
	public Long getBingzhong() {
		return bingzhong;
	}
	public void setBingzhong(Long bingzhong) {
		this.bingzhong = bingzhong;
	}
	
}
