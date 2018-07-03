package com.xavier.bean.keys;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * StcEntByArea复合主键
 *
 * @author NewGr8Player
 */
@Embeddable
public class StcEntByAreaMultiKeys implements Serializable {

	private String province;
	private String city;
	private String county;
	private String ent_type;

	public StcEntByAreaMultiKeys() {
	}

	public StcEntByAreaMultiKeys(String city, String county, String ent_type, String province) {
		this.city = city;
		this.county = county;
		this.ent_type = ent_type;
		this.province = province;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StcEntByAreaMultiKeys that = (StcEntByAreaMultiKeys) o;
		return Objects.equals(city, that.city) &&
				Objects.equals(county, that.county) &&
				Objects.equals(ent_type, that.ent_type) &&
				Objects.equals(province, that.province);
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, county, ent_type, province);
	}
}
