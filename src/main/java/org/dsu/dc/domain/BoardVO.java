package org.dsu.dc.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private long bno;
	private String Sno;
	private String Sname;
	private String PCno;
	private Date Logindate;
	private Date Logoutdate;
}
