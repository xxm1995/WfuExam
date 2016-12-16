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
 * �ύ�Ծ������
 */
public class SubmitExamAction extends ActionSupport{
    private List<Integer> subjectID;//ѧ�����Ե���Ŀ
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
		//���óɼ���ѧ����Ϣ��
		Map<String, Object> session = ActionContext.getContext().getSession();
		logger.warn("id = "+session);
		Student student = (Student)session.get("studentInfo");
		if (student==null) {
		    addActionError("����δ��¼,�޷�����,���ȵ�¼");
		    return ERROR;
		}
		String studentID = student.getStudentID();
		logger.warn("name = "+student.getStudentName());
		studentService.setStudentResult(studentID, GeneralPoint);
		request.setAttribute("studentName", student.getStudentName());//����ѧ���������ܷ���
		request.setAttribute("GeneralPoint", GeneralPoint);
		session.put("GeneralPoint", GeneralPoint);
		session.put("subjectIDs", subjectID);//��������Ŀ���浽session�����������ʾ��ʹ��
		session.put("studentAnswers", studentAnswers);//��������Ŀѡ���б��浽session���������ȶԴ�ʹ��
		return SUCCESS;
	}
}
