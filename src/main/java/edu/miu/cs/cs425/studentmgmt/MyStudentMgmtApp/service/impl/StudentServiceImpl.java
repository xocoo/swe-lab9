package edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.model.Student;
import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.repository.StudentRepository;
import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student addNewStudent(Student student) {
        var newStudent = studentRepository.save(student);
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        var students = studentRepository.findAll();
        return students;
    }

    @Override
    public Student getStudentById(Long studentId) {
        var student = studentRepository.findById(studentId).orElse(null);
        return student;
    }

    @Override
    public Student updatetStudent(Student updateStudent) {

        return studentRepository.save(updateStudent);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);

    }

}
