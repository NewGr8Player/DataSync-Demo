package com.xavier.bean.stc;

import com.xavier.bean.multi.StcEntByAreaMultiKeys;

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
@Table(name = "stc_ent_by_dict")
public class StcEntByArea {

	@EmbeddedId
	private StcEntByAreaMultiKeys stcEntByAreaMultiKeys;
	@Column
	private Integer ent_num;

	public StcEntByArea() {
	}

	public StcEntByArea(StcEntByAreaMultiKeys stcEntByAreaMultiKeys, Integer ent_num) {
		this.stcEntByAreaMultiKeys = stcEntByAreaMultiKeys;
		this.ent_num = ent_num;
	}

	public StcEntByAreaMultiKeys getStcEntByAreaMultiKeys() {
		return stcEntByAreaMultiKeys;
	}

	public void setStcEntByAreaMultiKeys(StcEntByAreaMultiKeys stcEntByAreaMultiKeys) {
		this.stcEntByAreaMultiKeys = stcEntByAreaMultiKeys;
	}

	public Integer getEnt_num() {
		return ent_num;
	}

	public void setEnt_num(Integer ent_num) {
		this.ent_num = ent_num;
	}
}
