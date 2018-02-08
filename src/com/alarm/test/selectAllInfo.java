package com.alarm.test;

import java.util.List;

import com.alarm.dao.handleDao;
import com.alarm.daoImpl.handleImpl;
import com.alarm.vo.AlarmInfo;

public class selectAllInfo {
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		handleDao dao=new handleImpl();
		List<AlarmInfo> list=dao.selectAll();
		if(list != null){
			for(AlarmInfo vo:list){
				System.out.println(vo.getAlarmId()+" "+vo.getAlarmTime());
			}
		}else{
			System.out.println("nodata");
		}
	}

}
