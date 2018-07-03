package com.xavier.bean.multi;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * EntByDic复合主键
 *
 * @author NewGr8Player
 */
@Embeddable
public class StcEntByDictMultiKeys implements Serializable {

	private String province;
	private String city;
	private String county;
	private String ent_type;
	private String dict_type;
	private String dict_value;

	public StcEntByDictMultiKeys() {

	}

	public StcEntByDictMultiKeys(String province, String city, String county, String ent_type, String dict_type, String dict_value) {
		this.province = province;
		this.city = city;
		this.county = county;
		this.ent_type = ent_type;
		this.dict_type = dict_type;
		this.dict_value = dict_value;
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

	public String getEnt_type() {
		return ent_type;
	}

	public void setEnt_type(String ent_type) {
		this.ent_type = ent_type;
	}

	public String getDict_type() {
		return dict_type;
	}

	public void setDict_type(String dict_type) {
		this.dict_type = dict_type;
	}

	public String getDict_value() {
		return dict_value;
	}

	public void setDict_value(String dict_value) {
		this.dict_value = dict_value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StcEntByDictMultiKeys that = (StcEntByDictMultiKeys) o;
		return Objects.equals(province, that.province) &&
				Objects.equals(city, that.city) &&
				Objects.equals(county, that.county) &&
				Objects.equals(ent_type, that.ent_type) &&
				Objects.equals(dict_type, that.dict_type) &&
				Objects.equals(dict_value, that.dict_value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(province, city, county, ent_type, dict_type, dict_value);
	}
}
