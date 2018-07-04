package com.xavier.bean.stc;

import com.xavier.bean.keys.StcEntByAreaMultiKeys;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * stc_ent_by_dict对应JavaBean
 *
 * @author NewGr8Player
 */
@Entity
@Table(name = "stc_ent_by_area")
public class StcEntByArea {

	@EmbeddedId
	private StcEntByAreaMultiKeys stcEntByAreaMultiKeys;
	@Column(name = "ent_num")
	private Integer entNum;

	public StcEntByArea() {
	}

	public StcEntByArea(StcEntByAreaMultiKeys stcEntByAreaMultiKeys, Integer entNum) {
		this.stcEntByAreaMultiKeys = stcEntByAreaMultiKeys;
		this.entNum = entNum;
	}

	public StcEntByAreaMultiKeys getStcEntByAreaMultiKeys() {
		return stcEntByAreaMultiKeys;
	}

	public void setStcEntByAreaMultiKeys(StcEntByAreaMultiKeys stcEntByAreaMultiKeys) {
		this.stcEntByAreaMultiKeys = stcEntByAreaMultiKeys;
	}

	public Integer getEntNum() {
		return entNum;
	}

	public void setEntNum(Integer entNum) {
		this.entNum = entNum;
	}

	public void incEnt_num(Integer inc) {
		this.entNum += inc;
	}
}
