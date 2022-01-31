package com.hyq.springcloud.canvo.service.iml;


import com.hyq.springcloud.canvo.dao.DeptDao;
import com.hyq.springcloud.canvo.domain.Dept;
import com.hyq.springcloud.canvo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeptServiceImpl implements DeptService
{
	@Autowired
	private DeptDao dao;

	@Override
	public boolean add(Dept dept)
	{
		return dao.addDept(dept);
	}

	@Override
	public Dept get(Long id)
	{
		return dao.findById(id);
	}

	@Override
	public List<Dept> list()
	{
		return dao.findAll();
	}

}
