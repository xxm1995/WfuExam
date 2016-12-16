package cn.xxm.WFU.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.xxm.WFU.po.Student;
import cn.xxm.WFU.po.Subject;
import cn.xxm.WFU.service.SubjectService;
import cn.xxm.WFU.service.SubjectServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * 获得随机试题
 */
public class GetRandomSubject extends ActionSupport{
    private static final long serialVersionUID = 7391340211819149782L;
    private SubjectService subjectService = new SubjectServiceImpl();
    public String execute() throws Exception {
	Map<String, Object> session = ActionContext.getContext().getSession();
	Student student = (Student)session.get("studentInfo");
	if (student==null) {
	    addActionError("请先登录,然后进行测试");
	    return ERROR;
	}
	List<Subject> subjects = subjectService.randomFindSubject(20);//获得试题记录
	HttpServletRequest request = ServletActionContext.getRequest();
	request.setAttribute("subjects", subjects);

	return SUCCESS;
    }
}
