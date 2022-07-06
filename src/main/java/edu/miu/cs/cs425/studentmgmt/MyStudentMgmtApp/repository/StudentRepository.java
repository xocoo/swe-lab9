package edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
