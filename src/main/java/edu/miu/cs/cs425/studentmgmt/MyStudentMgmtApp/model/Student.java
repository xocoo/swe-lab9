package edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentid")
    private Long studentId;

    @NotNull(message = "Student Number not be null")
    private String studentNumber;

    @NotNull(message = "First Name not be null")
    private String firstName;

    private String middleName;

    @NotNull(message = "Last Name not be null")
    private String lastName;

    private double cgpa;

    private LocalDate dateOfEnrollment;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "transcriptId")
    private Transcript transcript;

    @ManyToOne
    private Classroom classroom;

    public Student() {
    }

    public Student(Long studentId, @NotNull(message = "Student Number not be null") String studentNumber,
            @NotNull(message = "First Name not be null") String firstName, String middleName,
            @NotNull(message = "Last Name not be null") String lastName, double cgpa, LocalDate dateOfEnrollment,
            Transcript transcript, Classroom classroom) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.transcript = transcript;
        this.classroom = classroom;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getCgpa() {
        return cgpa;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student [cgpa=" + cgpa + ", classroom=" + classroom + ", dateOfEnrollment=" + dateOfEnrollment
                + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", studentId="
                + studentId + ", studentNumber=" + studentNumber + ", transcript=" + transcript + "]";
    }

}
