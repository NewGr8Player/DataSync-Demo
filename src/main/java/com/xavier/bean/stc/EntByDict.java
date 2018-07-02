package com.xavier.bean.stc;

import com.xavier.bean.multi.EntByDictMultiKeys;

import javax.persistence.*;
import java.io.Serializable;

/**
 * sys_dict表对应的JavaBean
 *
 * @author NewGr8Player
 */
@Entity
@Table(name = "stc_ent_by_dict")
@IdClass(EntByDictMultiKeys.class)
public class EntByDict implements Serializable {
	@Column
	private String province;
	@Column
	private String city;
	@Column
	private String county;
	@Column
	private String ent_type;
	@Column
	private String dict_type;
	@Column
	private String dict_value;
	@Column
	private String dict_label;
	@Column
	private Integer ent_num;

	public EntByDict() {
	}

	public EntByDict(String province, String city, String county, String ent_type, String dict_type, String dict_value, String dict_label, Integer ent_num) {
		this.province = province;
		this.city = city;
		this.county = county;
		this.ent_type = ent_type;
		this.dict_type = dict_type;
		this.dict_value = dict_value;
		this.dict_label = dict_label;
		this.ent_num = ent_num;
	}

	@Id
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Id
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Id
	public String getDict_type() {
		return dict_type;
	}

	public void setDict_type(String dict_type) {
		this.dict_type = dict_type;
	}

	@Id
	public String getDict_value() {
		return dict_value;
	}

	public void setDict_value(String dict_value) {
		this.dict_value = dict_value;
	}

	@Id
	public String getEnt_type() {
		return ent_type;
	}

	public void setEnt_type(String ent_type) {
		this.ent_type = ent_type;
	}

	@Id
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDict_label() {
		return dict_label;
	}

	public void setDict_label(String dict_label) {
		this.dict_label = dict_label;
	}

	public Integer getEnt_num() {
		return ent_num;
	}

	public void setEnt_num(Integer ent_num) {
		this.ent_num = ent_num;
	}
}
