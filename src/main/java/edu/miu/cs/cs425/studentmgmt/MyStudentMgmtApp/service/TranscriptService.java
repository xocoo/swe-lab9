package edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.service;

import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.model.Transcript;

public interface TranscriptService {
    public abstract Transcript addNewTranscript(Transcript transcript);

    public abstract Transcript getTransctipt(Long transcriptId);
}
