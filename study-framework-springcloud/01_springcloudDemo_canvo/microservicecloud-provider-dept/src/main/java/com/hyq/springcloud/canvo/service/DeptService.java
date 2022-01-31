package com.hyq.springcloud.canvo.service;



import com.hyq.springcloud.canvo.domain.Dept;

import java.util.List;


public interface DeptService
{
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
