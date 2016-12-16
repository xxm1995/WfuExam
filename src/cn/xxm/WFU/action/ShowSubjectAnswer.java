package cn.xxm.WFU.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import cn.xxm.WFU.po.Subject;
import cn.xxm.WFU.service.SubjectService;
import cn.xxm.WFU.service.SubjectServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * 显示试题答案
 */
public class ShowSubjectAnswer extends ActionSupport{
    private static final long serialVersionUID = -1938960870046510708L;
	Logger logger = Logger.getLogger(this.getClass());
	private SubjectService subjectService = new SubjectServiceImpl();
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		List<Subject> subjects = new ArrayList<Subject>();//保存学生考过的题目
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = ActionContext.getContext().getSession();
		List<Integer> subjectIDs = (List<Integer>) session.get("subjectIDs");
		List<String> studentAnswers = (List<String>) session.get("studentAnswers");
		int i = 0;
		for(Integer subjectID : subjectIDs) {
			Subject subject = subjectService.showSubjectParticular(subjectID);//通过试题编号查找试题
			subject.setSubjectParse(studentAnswers.get(i));
			subjects.add(subject);
			i++;
		}
		request.setAttribute("subjects", subjects);
		request.setAttribute("studentAnswers", studentAnswers);
		logger.warn("subjects= "+subjects);
		logger.warn("studentAnswers= "+studentAnswers);
		return SUCCESS;
	}
}
