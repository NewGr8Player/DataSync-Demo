package com.xavier.bean.stc;

import com.xavier.bean.keys.StcEntByTraceMultiKeys;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stc_ent_by_trace")
public class StcEntByTrace implements Serializable {

	@EmbeddedId
	private StcEntByTraceMultiKeys stcEntByTraceMultiKeys;
	@Column(name="ent_num")
	private Integer entNum;

	public void incEnt_num(Integer inc) {
		this.entNum += inc;
	}
}
