package com.xavier.bean.stc;

import com.xavier.bean.keys.StcTracePigMultiKeys;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stc_trace_pig")
public class StcTracePig implements Serializable {

	@EmbeddedId
	private StcTracePigMultiKeys stcTracePigMultiKeys;

	@Column(name = "ent_num")
	private Integer butcherNum;

	@Column(name = "butcher_flag")
	private Integer butcherFlag = 0;

	@Column(name = "sell_num")
	private Integer sellNum;

	@Column(name = "sell_flag")
	private Integer sellFlag = 0;

	/**
	 * <p>相比前一日屠宰量变化情况</p>
	 * <ul>
	 * <li> 传入参数为{@code null}或者等于前一天置{@code 0};</li>
	 * <li> 大于前一天置{@code 1};</li>
	 * <li> 小于前一天置{@code -1};</li>
	 * </ul>
	 *
	 * @param butcherNum 前一天屠宰量
	 * @see java.lang.Integer#compareTo(Integer)
	 */
	public void preButcherNumCpm(Integer butcherNum) {
		if (null == butcherNum) {/* 前一天为空 */
			this.butcherFlag = 0;
		} else {/* 与前一天比较 */
			this.butcherFlag = butcherNum.compareTo(this.butcherNum);
		}
	}

	/**
	 * <p>相比前一日销售量变化情况</p>
	 *
	 * @param sellNum 前一天销售量
	 * @see java.lang.Integer#compareTo(Integer)
	 */
	public void preSellNumCpm(Integer sellNum) {
		if (null == sellNum) {/* 前一天为空 */
			this.sellNum = 0;
		} else {/* 与前一天比较 */
			this.sellNum = sellNum.compareTo(this.sellNum);
		}
	}

}
