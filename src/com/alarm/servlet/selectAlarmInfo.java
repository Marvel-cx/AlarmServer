package com.alarm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alarm.vo.AlarmInfo;
import com.alarm.dao.handleDao;
import com.alarm.daoImpl.handleImpl;

/**
 * Servlet implementation class selectAll
 */
@WebServlet("/selectAll")
public class selectAlarmInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectAlarmInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        String jsonp=request.getParameter("callback");
        handleDao dao=new handleImpl();
        List<AlarmInfo> list;
        //把从数据库查询的结果构造成一个JSON字符串推向前台
        StringBuffer json=new StringBuffer();
        json.append("[");
        try {
			list = dao.selectAll();
			if(list!=null){				
 				for(AlarmInfo vo:list){
 					json.append("{");
 					json.append("'alarm_id':").append("'").append(vo.getAlarmId()).append("'").append(",");
 					json.append("'alarm_time':").append("'").append(vo.getAlarmTime()).append("'").append(",");
 					json.append("'alarm_type':").append("'").append(vo.getAlarmType()).append("'").append(",");
 					json.append("'alarm_location':").append("'").append(vo.getAlarmLocation()).append("'").append(",");
 					json.append("'alarm_lat':").append("'").append(vo.getAlarm_lat()).append("'").append(",");
 					json.append("'alarm_lng':").append("'").append(vo.getAlarm_lng()).append("'");
 					json.append("},"); 					
 				}
 				json.deleteCharAt(json.length() - 1);  
 				json.append("]");
 				PrintWriter writer=response.getWriter();
 		        writer.print(jsonp+"("+json+")");
 		        writer.flush();
 		        writer.close();
  			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
