package com.xavier.bean.stc;

import com.xavier.bean.keys.StcEntByTraceMultiKeys;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * stc_ent_by_trace表对应的JavaBean
 *
 * @author NewGr8Player
 */
@Entity
@Table(name = "stc_ent_by_trace")
public class StcEntByTrace implements Serializable {

	@EmbeddedId
	private StcEntByTraceMultiKeys stcEntByTraceMultiKeys;
	@Column(name="ent_num")
	private Integer entNum;

	public StcEntByTrace() {
	}

	public StcEntByTrace(StcEntByTraceMultiKeys stcEntByTraceMultiKeys, Integer entNum) {
		this.stcEntByTraceMultiKeys = stcEntByTraceMultiKeys;
		this.entNum = entNum;
	}

	public StcEntByTraceMultiKeys getStcEntByTraceMultiKeys() {
		return stcEntByTraceMultiKeys;
	}

	public void setStcEntByTraceMultiKeys(StcEntByTraceMultiKeys stcEntByTraceMultiKeys) {
		this.stcEntByTraceMultiKeys = stcEntByTraceMultiKeys;
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
