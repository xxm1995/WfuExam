package cn.xxm.WFU.service;

import cn.xxm.WFU.dao.TeacherDAO;
import cn.xxm.WFU.dao.TeacherDAOImpl;
import cn.xxm.WFU.po.Teacher;

public class TeacherServiceImpl implements TeacherService{
	private TeacherDAO teacherDAO = new TeacherDAOImpl();
	
	public boolean allowLogin(String teacherID, String password) {
		Teacher teacher = teacherDAO.findByTeacherID(teacherID);
		if(teacher == null) {//�ж��Ƿ���ڸ�ID�Ľ�ʦ
			return false;
		}else {
			if(password.equals(teacher.getPassword())) {//�ж������Ƿ���ͬ
				return true;
			}else{
				return false;
			}
		}
	}
}
