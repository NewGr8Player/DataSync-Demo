package com.xavier.bean.stc;

import javax.persistence.Column;

public class EntByArea {

	@Column
	private String city;
	@Column
	private String county;
	@Column
	private String ent_type;
	@Column
	private String province;
	@Column
	private Integer ent_num;
}
