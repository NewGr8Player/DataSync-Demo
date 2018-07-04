package com.xavier.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ent_butcher")
public class EntButcher implements Serializable {

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "grade")
	private String grade;
	@Column(name = "butcher_num")
	private BigDecimal butcherNum;
	@Column(name = "checker_num")
	private Integer checkerNum;
	@Column(name = "artisan_num")
	private Integer artisanNum;
	@Column(name = "check_other")
	private String checkOther;
	@Column(name = "butcher_other")
	private String butcherOther;
	@Column(name = "harmless_other")
	private String harmlessOther;
	@Column(name = "butcher_no")
	private Integer butcherNo;
	@Column(name = "is_record")
	private Integer isRecord;
	@Column(name = "sort")
	private Integer sort;
	@Column(name = "status")
	private Integer status;
	@Column(name = "create_id")
	private String createId;
	@Column(name = "create_date")
	private Date createDate;
	@Column(name = "update_by")
	private String updateBy;
	@Column(name = "update_date")
	private Date updateDate;
	@Column(name = "remarks")
	private String remarks;
	@Column(name = "del_flag")
	private Integer delFlag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public BigDecimal getButcherNum() {
		return butcherNum;
	}

	public void setButcherNum(BigDecimal butcherNum) {
		this.butcherNum = butcherNum;
	}

	public Integer getCheckerNum() {
		return checkerNum;
	}

	public void setCheckerNum(Integer checkerNum) {
		this.checkerNum = checkerNum;
	}

	public Integer getArtisanNum() {
		return artisanNum;
	}

	public void setArtisanNum(Integer artisanNum) {
		this.artisanNum = artisanNum;
	}

	public String getCheckOther() {
		return checkOther;
	}

	public void setCheckOther(String checkOther) {
		this.checkOther = checkOther;
	}

	public String getButcherOther() {
		return butcherOther;
	}

	public void setButcherOther(String butcherOther) {
		this.butcherOther = butcherOther;
	}

	public String getHarmlessOther() {
		return harmlessOther;
	}

	public void setHarmlessOther(String harmlessOther) {
		this.harmlessOther = harmlessOther;
	}

	public Integer getButcherNo() {
		return butcherNo;
	}

	public void setButcherNo(Integer butcherNo) {
		this.butcherNo = butcherNo;
	}

	public Integer getIsRecord() {
		return isRecord;
	}

	public void setIsRecord(Integer isRecord) {
		this.isRecord = isRecord;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
}
