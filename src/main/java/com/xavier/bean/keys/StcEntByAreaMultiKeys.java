package com.xavier.bean.keys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * StcEntByArea复合主键
 *
 * @author NewGr8Player
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
