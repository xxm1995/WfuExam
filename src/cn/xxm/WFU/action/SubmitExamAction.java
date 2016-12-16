package cn.xxm.WFU.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import cn.xxm.WFU.po.Student;
import cn.xxm.WFU.service.StudentService;
import cn.xxm.WFU.service.StudentServiceImpl;
import cn.xxm.WFU.service.SubjectService;
import cn.xxm.WFU.service.SubjectServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * 提交试卷，并打分
 */
public class SubmitExamAction extends ActionSupport{
    private List<Integer> subjectID;//学生考试的题目
	private SubjectService subjectService = new SubjectServiceImpl();
	private StudentService studentService = new StudentServiceImpl();
	public List<Integer> getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(List<Integer> subjectID) {
		this.subjectID = subjectID;
	}
	public String execute() throws Exception {
	    	Logger logger = Logger.getLogger(this.getClass());
		HttpServletRequest request = ServletActionContext.getRequest();
		List<String> studentAnswers = new ArrayList<String>();
		for(int i = 0; i < 20; i++) {
			String answer = request.getParameter("subjectAnswer"+i);
			studentAnswers.add(answer);
		}
		int GeneralPoint = subjectService.accountResult(subjectID, studentAnswers);
		logger.warn("studentAnswers = "+studentAnswers);
		//设置成绩到学生信息中
		Map<String, Object> session = ActionContext.getContext().getSession();
		logger.warn("id = "+session);
		Student student = (Student)session.get("studentInfo");
		if (student==null) {
		    addActionError("请您未登录,无法测试,请先登录");
		    return ERROR;
		}
		String studentID = student.getStudentID();
		logger.warn("name = "+student.getStudentName());
		studentService.setStudentResult(studentID, GeneralPoint);
		request.setAttribute("studentName", student.getStudentName());//保存学生姓名和总分数
		request.setAttribute("GeneralPoint", GeneralPoint);
		session.put("GeneralPoint", GeneralPoint);
		session.put("subjectIDs", subjectID);//将考试题目保存到session，方便后面显示答案使用
		session.put("studentAnswers", studentAnswers);//将考试题目选项中保存到session，方便后面比对答案使用
		return SUCCESS;
	}
}
