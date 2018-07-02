package com.xavier.bean.multi;

import java.io.Serializable;
import java.util.Objects;

/**
 * EntByDic复合主键
 */
public class EntByDictMultiKeys implements Serializable {
	private String province;
	private String city;
	private String county;
	private String ent_type;
	private String dict_type;
	private String dict_value;

	public EntByDictMultiKeys(){

	}

	public EntByDictMultiKeys(String province, String city, String county, String ent_type, String dict_type, String dict_value) {
		this.province = province;
		this.city = city;
		this.county = county;
		this.ent_type = ent_type;
		this.dict_type = dict_type;
		this.dict_value = dict_value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EntByDictMultiKeys that = (EntByDictMultiKeys) o;
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
