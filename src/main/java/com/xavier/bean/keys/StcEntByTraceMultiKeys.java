package com.xavier.bean.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * StcEntByTrace复合主键
 *
 * @author NewGr8Player
 */
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

	public StcEntByTraceMultiKeys() {
	}

	public StcEntByTraceMultiKeys(String province, String city, String county, String entGrade, Integer promoteStatus, String butcherType) {
		this.province = province;
		this.city = city;
		this.county = county;
		this.entGrade = entGrade;
		this.promoteStatus = promoteStatus;
		this.butcherType = butcherType;
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

	public String getEntGrade() {
		return entGrade;
	}

	public void setEntGrade(String entGrade) {
		this.entGrade = entGrade;
	}

	public Integer getPromoteStatus() {
		return promoteStatus;
	}

	public void setPromoteStatus(Integer promoteStatus) {
		this.promoteStatus = promoteStatus;
	}

	public String getButcherType() {
		return butcherType;
	}

	public void setButcherType(String butcherType) {
		this.butcherType = butcherType;
	}

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
