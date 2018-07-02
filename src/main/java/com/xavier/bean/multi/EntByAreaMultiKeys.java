package com.xavier.bean.multi;

import javax.persistence.Column;

public class EntByAreaMultiKeys {

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
