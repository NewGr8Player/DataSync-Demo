package com.xavier.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * sys_dict表对应的JavaBean
 *
 * @author NewGr8Player
 */
@Getter
@Setter
@Entity
@Table(name = "sys_dict")
public class Dict implements Serializable {
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "value")
	private String value;
	@Column(name = "label")
	private String label;
	@Column(name = "type")
	private String type;
	@Column(name = "description")
	private String description;
	@Column(name = "sort")
	private BigDecimal sort;
	@Column(name = "parent_id")
	private String parentId;
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
	private String delFlag;

}
