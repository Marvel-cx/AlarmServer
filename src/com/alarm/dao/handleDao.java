package com.alarm.dao;

import java.util.List;

import com.alarm.vo.AlarmInfo;

public interface handleDao {
	//查询所有报警信息
	public List<AlarmInfo> selectAll() throws Exception;
	//
}
