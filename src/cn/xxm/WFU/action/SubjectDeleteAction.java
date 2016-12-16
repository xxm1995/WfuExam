package cn.xxm.WFU.action;

import cn.xxm.WFU.service.SubjectService;
import cn.xxm.WFU.service.SubjectServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class SubjectDeleteAction extends ActionSupport{
	private int subjectID;
	private SubjectService subjectService = new SubjectServiceImpl();
	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	public String execute() throws Exception {
		subjectService.deleteSubject(subjectID);
		return SUCCESS;
	}
}
