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
 * StcEntByTrace复合主键
 *
 * @author NewGr8Player
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class StcEntByTraceMultiKeys implements Serializable {

	@Column(name = "province")
	private String province;
	@Column(name = "city")
	private String city;
	@Column(name = "county")
	private String county;
	@Column(name = "ent_grade")
	private String entGrade;
	@Column(name = "promote_status")
	private Integer promoteStatus;
	@Column(name = "butcher_type")
	private String butcherType;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StcEntByTraceMultiKeys that = (StcEntByTraceMultiKeys) o;
		return Objects.equals(province, that.province) &&
				Objects.equals(city, that.city) &&
				Objects.equals(county, that.county) &&
				Objects.equals(entGrade, that.entGrade) &&
				Objects.equals(promoteStatus, that.promoteStatus) &&
				Objects.equals(butcherType, that.butcherType);
	}

	@Override
	public int hashCode() {

		return Objects.hash(province, city, county, entGrade, promoteStatus, butcherType);
	}
}
