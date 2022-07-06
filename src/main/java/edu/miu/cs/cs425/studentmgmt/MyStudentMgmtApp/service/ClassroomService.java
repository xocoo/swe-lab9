package edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.service;

import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.model.Classroom;

public interface ClassroomService {
    public abstract Classroom addNewClassroom(Classroom classroom);

    public abstract Classroom getClassroom(Long classroomId);
}
