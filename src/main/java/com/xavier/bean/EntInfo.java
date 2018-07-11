package com.xavier.bean;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * ent_info表对应的JavaBean
 *
 * @author NewGr8Player
 */
@Getter
@Setter
@Entity
@Table(name = "ent_info")
public class EntInfo implements Serializable {

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "ent_no")
	private String entNo;
	@Column(name = "card_no")
	private String cardNo;
	@Column(name = "ent_name")
	private String entName;
	@Column(name = "ent_type_code")
	private String entTypeCode;
	@Column(name = "ent_type_name")
	private String entTypeName;
	@Column(name = "legal_person")
	private String legalPerson;
	@Column(name = "telephone")
	private String telephone;
	@Column(name = "other_person")
	private String otherPerson;
	@Column(name = "other_telephone")
	private String otherTelephone;
	@Column(name = "idcard")
	private String idcard;
	@Column(name = "supervision")
	private String supervision;
	@Column(name = "state_type_code")
	private String stateTypeCode;
	@Column(name = "state_type_name")
	private String stateTypeName;
	@Column(name = "promote_status")
	private Integer promoteStatus;
	@Column(name = "research_date")
	private Date researchDate;
	@Column(name = "promote_date")
	private Date promoteDate;
	@Column(name = "build_date")
	private Date buildDate;
	@Column(name = "province")
	private String province;
	@Column(name = "city")
	private String city;
	@Column(name = "county")
	private String county;
	@Column(name = "detail")
	private String detail;
	@Column(name = "lng")
	private String lng;
	@Column(name = "lat")
	private String lat;
	@Column(name = "sort")
	private Integer sort;
	@Column(name = "status")
	private Integer status;
	@Column(name = "create_by")
	private String createBy;
	@Column(name = "create_date")
	private Date createDate;
	@Column(name = "update_by")
	private String updateBy;
	@Column(name = "update_date")
	private Date updateDate;
	@Column(name = "remarks")
	private String remarks;
	@Column(name = "del_flag")
	private String delFlag = "0";
}
