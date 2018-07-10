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

@Getter
@Setter
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
}
