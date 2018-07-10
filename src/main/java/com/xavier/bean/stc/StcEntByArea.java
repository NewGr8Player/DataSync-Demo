package com.xavier.bean.stc;

import com.xavier.bean.keys.StcEntByAreaMultiKeys;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * stc_ent_by_dict对应JavaBean
 *
 * @author NewGr8Player
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stc_ent_by_area")
public class StcEntByArea {

	@EmbeddedId
	private StcEntByAreaMultiKeys stcEntByAreaMultiKeys;
	@Column(name = "ent_num")
	private Integer entNum;

	public void incEnt_num(Integer inc) {
		this.entNum += inc;
	}
}
