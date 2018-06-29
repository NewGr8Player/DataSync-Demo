package com.xavier.bean;

import com.alibaba.otter.canal.protocol.CanalEntry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ent_info")
public class EntInfo implements Serializable {

	@Id
	@Column
	private String id;
	@Column
	private String entNo;
	@Column
	private String cardNo;
	@Column
	private String entName;
	@Column
	private String entTypeCode;
	@Column
	private String entTypeName;
	@Column
	private String legalPerson;
	@Column
	private String telephone;
	@Column
	private String otherPerson;
	@Column
	private String otherTelephone;
	@Column
	private String idcard;
	@Column
	private String supervision;
	@Column
	private String stateTypeCode;
	@Column
	private String stateTypeName;
	@Column
	private Integer promoteStatus;
	@Column
	private Date researchDate;
	@Column
	private Date promoteDate;
	@Column
	private Date buildDate;
	@Column
	private String province;
	@Column
	private String city;
	@Column
	private String county;
	@Column
	private String detail;
	@Column
	private String lng;
	@Column
	private String lat;
	@Column
	private Integer sort;
	@Column
	private Integer status;
	@Column
	private String createBy;
	@Column
	private Date createDate;
	@Column
	private String updateBy;
	@Column
	private Date updateDate;
	@Column
	private String remarks;
	@Column
	private String delFlag;

	public EntInfo() {
	}

	public EntInfo(List<CanalEntry.Column> list) {
		list.forEach(
				(e) -> {
					switch (e.getName()) {
						case "id":
							this.id = e.getValue();
							break;
						case "entNo":
							this.entNo = e.getValue();
							break;
						case "":
					}
				}
		);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEntNo() {
		return entNo;
	}

	public void setEntNo(String entNo) {
		this.entNo = entNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getEntTypeCode() {
		return entTypeCode;
	}

	public void setEntTypeCode(String entTypeCode) {
		this.entTypeCode = entTypeCode;
	}

	public String getEntTypeName() {
		return entTypeName;
	}

	public void setEntTypeName(String entTypeName) {
		this.entTypeName = entTypeName;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOtherPerson() {
		return otherPerson;
	}

	public void setOtherPerson(String otherPerson) {
		this.otherPerson = otherPerson;
	}

	public String getOtherTelephone() {
		return otherTelephone;
	}

	public void setOtherTelephone(String otherTelephone) {
		this.otherTelephone = otherTelephone;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getSupervision() {
		return supervision;
	}

	public void setSupervision(String supervision) {
		this.supervision = supervision;
	}

	public String getStateTypeCode() {
		return stateTypeCode;
	}

	public void setStateTypeCode(String stateTypeCode) {
		this.stateTypeCode = stateTypeCode;
	}

	public String getStateTypeName() {
		return stateTypeName;
	}

	public void setStateTypeName(String stateTypeName) {
		this.stateTypeName = stateTypeName;
	}

	public Integer getPromoteStatus() {
		return promoteStatus;
	}

	public void setPromoteStatus(Integer promoteStatus) {
		this.promoteStatus = promoteStatus;
	}

	public Date getResearchDate() {
		return researchDate;
	}

	public void setResearchDate(Date researchDate) {
		this.researchDate = researchDate;
	}

	public Date getPromoteDate() {
		return promoteDate;
	}

	public void setPromoteDate(Date promoteDate) {
		this.promoteDate = promoteDate;
	}

	public Date getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
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

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
}
