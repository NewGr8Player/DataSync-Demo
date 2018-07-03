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
	@Column
	private String dict_label;
	@Column
	private Integer ent_num;

	public StcEntByDict() {
	}

	public StcEntByDict(StcEntByDictMultiKeys stcEntByDictMultiKeys, String dict_label, Integer ent_num) {
		this.stcEntByDictMultiKeys = stcEntByDictMultiKeys;
		this.dict_label = dict_label;
		this.ent_num = ent_num;
	}

	public StcEntByDictMultiKeys getStcEntByDictMultiKeys() {
		return stcEntByDictMultiKeys;
	}

	public void setStcEntByDictMultiKeys(StcEntByDictMultiKeys stcEntByDictMultiKeys) {
		this.stcEntByDictMultiKeys = stcEntByDictMultiKeys;
	}

	public String getDict_label() {
		return dict_label;
	}

	public void setDict_label(String dict_label) {
		this.dict_label = dict_label;
	}

	public Integer getEnt_num() {
		return ent_num;
	}

	public void setEnt_num(Integer ent_num) {
		this.ent_num = ent_num;
	}

	public void incEnt_num(Integer inc) {
		this.ent_num += inc;
	}
}
