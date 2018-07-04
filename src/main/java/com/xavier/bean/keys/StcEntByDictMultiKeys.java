package com.xavier.bean.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * StcEntByDict复合主键
 *
 * @author NewGr8Player
 */
@Embeddable
public class StcEntByDictMultiKeys implements Serializable {

	@Column(name = "province")
	private String province;
	@Column(name = "city")
	private String city;
	@Column(name = "county")
	private String county;
	@Column(name = "ent_type")
	private String entType;
	@Column(name = "dict_type")
	private String dictType;
	@Column(name = "dict_value")
	private String dictValue;

	public StcEntByDictMultiKeys() {

	}

	public StcEntByDictMultiKeys(String province, String city, String county, String entType, String dictType, String dictValue) {
		this.province = province;
		this.city = city;
		this.county = county;
		this.entType = entType;
		this.dictType = dictType;
		this.dictValue = dictValue;
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

	public String getEntType() {
		return entType;
	}

	public void setEntType(String entType) {
		this.entType = entType;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictValue() {
		return dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StcEntByDictMultiKeys that = (StcEntByDictMultiKeys) o;
		return Objects.equals(province, that.province) &&
				Objects.equals(city, that.city) &&
				Objects.equals(county, that.county) &&
				Objects.equals(entType, that.entType) &&
				Objects.equals(dictType, that.dictType) &&
				Objects.equals(dictValue, that.dictValue);
	}

	@Override
	public int hashCode() {
		return Objects.hash(province, city, county, entType, dictType, dictValue);
	}
}
