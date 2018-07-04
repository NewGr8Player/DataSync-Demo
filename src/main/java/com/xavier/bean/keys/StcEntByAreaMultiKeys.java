package com.xavier.bean.keys;

import javax.persistence.Column;
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

	@Column(name = "province")
	private String province;
	@Column(name = "city")
	private String city;
	@Column(name = "county")
	private String county;
	@Column(name = "ent_type")
	private String entType;

	public StcEntByAreaMultiKeys() {
	}

	public StcEntByAreaMultiKeys(String city, String county, String entType, String province) {
		this.city = city;
		this.county = county;
		this.entType = entType;
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

	public String getEntType() {
		return entType;
	}

	public void setEntType(String entType) {
		this.entType = entType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StcEntByAreaMultiKeys that = (StcEntByAreaMultiKeys) o;
		return Objects.equals(city, that.city) &&
				Objects.equals(county, that.county) &&
				Objects.equals(entType, that.entType) &&
				Objects.equals(province, that.province);
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, county, entType, province);
	}
}
