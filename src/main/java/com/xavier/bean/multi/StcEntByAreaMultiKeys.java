package com.xavier.bean.multi;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * EntByArea复合主键
 *
 * @author NewGr8Player
 */
@Embeddable
public class StcEntByAreaMultiKeys implements Serializable {

	private String city;

	private String county;

	private String ent_type;

	private String province;


	public StcEntByAreaMultiKeys() {
	}

	public StcEntByAreaMultiKeys(String city, String county, String ent_type, String province) {
		this.city = city;
		this.county = county;
		this.ent_type = ent_type;
		this.province = province;
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
