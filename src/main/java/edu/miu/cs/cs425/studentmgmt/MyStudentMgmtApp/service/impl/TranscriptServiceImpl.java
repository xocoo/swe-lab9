package edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.repository.TranscriptRepository;
import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.service.TranscriptService;

@Service
public class TranscriptServiceImpl implements TranscriptService {
    @Autowired
    TranscriptRepository transcriptRepository;

    @Override
    public Transcript addNewTranscript(Transcript transcript) {
        var newTranscript = transcriptRepository.save(transcript);
        return newTranscript;
    }

    @Override
    public Transcript getTransctipt(Long transcriptId) {
        var transcript = transcriptRepository.findById(transcriptId).orElse(null);
        return transcript;
    }

}
