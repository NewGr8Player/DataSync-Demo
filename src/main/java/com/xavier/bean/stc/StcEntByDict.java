package com.xavier.bean.stc;

import com.xavier.bean.keys.StcEntByDictMultiKeys;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * stc_ent_by_dict表对应的JavaBean
 *
 * @author NewGr8Player
 */
@Entity
@Table(name = "stc_ent_by_dict")
public class StcEntByDict implements Serializable {

	@EmbeddedId
	private StcEntByDictMultiKeys stcEntByDictMultiKeys;
	@Column(name = "dict_label")
	private String dictLabel;
	@Column(name = "ent_num")
	private Integer entNum;

	public StcEntByDict() {
	}

	public StcEntByDict(StcEntByDictMultiKeys stcEntByDictMultiKeys, String dictLabel, Integer entNum) {
		this.stcEntByDictMultiKeys = stcEntByDictMultiKeys;
		this.dictLabel = dictLabel;
		this.entNum = entNum;
	}

	public StcEntByDictMultiKeys getStcEntByDictMultiKeys() {
		return stcEntByDictMultiKeys;
	}

	public void setStcEntByDictMultiKeys(StcEntByDictMultiKeys stcEntByDictMultiKeys) {
		this.stcEntByDictMultiKeys = stcEntByDictMultiKeys;
	}

	public String getDictLabel() {
		return dictLabel;
	}

	public void setDictLabel(String dictLabel) {
		this.dictLabel = dictLabel;
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
