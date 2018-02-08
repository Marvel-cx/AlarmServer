package com.alarm.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.alarm.dao.handleDao;
import com.alarm.vo.AlarmInfo;
import com.alarm.db.DBConnection;

public class handleImpl implements handleDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet res;
	
	@Override
	public List<AlarmInfo> selectAll() throws Exception {
		// TODO Auto-generated method stub
		List<AlarmInfo> list=new ArrayList<AlarmInfo>();
		String sql="select alarm_id,alarm_time,alarm_type,alarm_location,alarm_lat,alarm_lng from alarm_info order by alarm_id desc limit 1;";
		DBConnection db=new DBConnection();
		conn=db.getConnection();
		pst=conn.prepareStatement(sql);
		res=pst.executeQuery();
		while(res.next()){
			AlarmInfo alarmInfo=new AlarmInfo();
			alarmInfo.setAlarmId(res.getString(1));
			alarmInfo.setAlarmTime(res.getString(2));
			alarmInfo.setAlarmType(res.getString(3));
			alarmInfo.setAlarmLocation(res.getString(4));
			alarmInfo.setAlarm_lat(res.getString(5));
			alarmInfo.setAlarm_lng(res.getString(6));			
			list.add(alarmInfo);
		}
		conn.close();
		return list;
	}
	
}
