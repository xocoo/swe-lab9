package edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.repository.ClassroomRepository;
import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.service.ClassroomService;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    ClassroomRepository classroomRepository;

    @Override
    public Classroom addNewClassroom(Classroom classroom) {
        var newClassroom = classroomRepository.save(classroom);
        return newClassroom;
    }

    @Override
    public Classroom getClassroom(Long classroomId) {
        var classroom = classroomRepository.findById(classroomId).orElse(null);
        return classroom;
    }

}
