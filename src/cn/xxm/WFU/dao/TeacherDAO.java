package cn.xxm.WFU.dao;

import cn.xxm.WFU.po.Teacher;

public interface TeacherDAO {
	public Teacher findByTeacherID(String teacherID);//查询方法，根据教师ID查询
}
