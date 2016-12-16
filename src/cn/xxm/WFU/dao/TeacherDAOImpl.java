package cn.xxm.WFU.dao;

import org.hibernate.Session;

import cn.xxm.WFU.hibernate.HibernateSessionFactory;
import cn.xxm.WFU.po.Teacher;

public class TeacherDAOImpl implements TeacherDAO{
	public Teacher findByTeacherID(String teacherID) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Teacher teacher = (Teacher) session.get(Teacher.class, teacherID);
		HibernateSessionFactory.closeSession();//�ر�Session����
		return teacher;
	}
}
