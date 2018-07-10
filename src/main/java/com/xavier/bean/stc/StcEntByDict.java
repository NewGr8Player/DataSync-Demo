package com.xavier.bean.stc;

import com.xavier.bean.keys.StcEntByDictMultiKeys;
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
 * stc_ent_by_dict表对应的JavaBean
 *
 * @author NewGr8Player
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stc_ent_by_dict")
public class StcEntByDict implements Serializable {

	@EmbeddedId
	private StcEntByDictMultiKeys stcEntByDictMultiKeys;
	@Column(name = "dict_label")
	private String dictLabel;
	@Column(name = "ent_num")
	private Integer entNum;

	public void incEnt_num(Integer inc) {
		this.entNum += inc;
	}
}
