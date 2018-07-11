package com.xavier.bean.keys;

import com.xavier.common.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * StcTracePig复合主键
 *
 * @author NewGr8Player
 */
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class StcTracePigMultiKeys implements Serializable {

	@Getter
	@Setter
	@Column(name = "province")
	private String province;

	@Getter
	@Setter
	@Column(name = "city")
	private String city;

	@Getter
	@Setter
	@Column(name = "county")
	private String county;

	@Getter
	@Setter
	@Column(name = "ent_id")
	private String entId;

	/**
	 * 为确保Date类型比较可控，将Date类型格式化为带有关键系数的字符串 yyyy-MM-dd(年月日)
	 */
	@Column(name = "date")
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = DateUtil.dateToString(DateUtil.dateStrValidator(date), DateUtil.YMD_DASH);
	}

	@Override
	public Object clone() {
		return new StcTracePigMultiKeys(
				this.province,
				this.city,
				this.county,
				this.entId,
				this.date
		);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StcTracePigMultiKeys that = (StcTracePigMultiKeys) o;
		return Objects.equals(province, that.province) &&
				Objects.equals(city, that.city) &&
				Objects.equals(county, that.county) &&
				Objects.equals(entId, that.entId) &&
				Objects.equals(date, date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(province, city, county, entId, date);
	}
}
