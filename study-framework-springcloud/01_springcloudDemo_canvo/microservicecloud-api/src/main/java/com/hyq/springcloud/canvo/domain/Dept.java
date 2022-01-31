package com.hyq.springcloud.canvo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;


@AllArgsConstructor
@Data
@Accessors(chain=true)
@Getter
@Setter
// entity --orm--- db_table类表关系映射
public class Dept implements Serializable
{
	// 主键
	private Long 	deptno;
	// 部门名称
	private String 	dname;

	// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
	private String 	db_source;
	public Dept(String dname)
	{
		super();
		this.dname = dname;
	}

	public Dept() {
		super();

	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", db_source=" + db_source + "]";
	}

	public Long getDeptno() {
		return deptno;
	}

	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDb_source() {
		return db_source;
	}

	public void setDb_source(String db_source) {
		this.db_source = db_source;
	}


}
