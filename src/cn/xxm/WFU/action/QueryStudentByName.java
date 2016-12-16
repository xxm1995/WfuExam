package cn.xxm.WFU.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.xxm.WFU.po.Student;
import cn.xxm.WFU.service.StudentService;
import cn.xxm.WFU.service.StudentServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class QueryStudentByName extends ActionSupport{
	private String studentName;
	private StudentService studentService = new StudentServiceImpl();
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Student> students = studentService.getStudentByName(studentName);
		request.setAttribute("students", students);
		return this.SUCCESS;
	}
	
}
