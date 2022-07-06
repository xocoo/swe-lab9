package edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.service;

import java.util.List;

import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.model.Student;

public interface StudentService {
    public abstract Student addNewStudent(Student student);

    public abstract List<Student> getAllStudents();

    public abstract Student getStudentById(Long studentId);

    Student updatetStudent(Student updateStudent);

    void deleteStudentById(Long studentId);
}
