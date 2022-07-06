package edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.model.Student;
import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.repository.ClassroomRepository;
import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.repository.StudentRepository;
import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.repository.TranscriptRepository;
import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.service.ClassroomService;
import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.service.StudentService;
import edu.miu.cs.cs425.studentmgmt.MyStudentMgmtApp.service.TranscriptService;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {
	@Autowired
	TranscriptRepository transcriptRepository;

	@Autowired
	TranscriptService transcriptService;

	@Autowired
	ClassroomRepository classroomRepository;

	@Autowired
	ClassroomService classroomService;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Student Management App");
		Transcript transcript = new Transcript(null, "BS Computer Science");
		Transcript savedTranscript = transcriptService.addNewTranscript(transcript);
		System.out.println(savedTranscript);

		Classroom classroom = new Classroom(null, "McLaughlin building", "M105");
		Classroom savedClassroom = classroomService.addNewClassroom(classroom);
		System.out.println(savedClassroom);
		LocalDate dateOfEnrollment = LocalDate.parse("2019-05-24");

		Student student = new Student(null, "000-61-0001", "Anna", "Lynn", "Smith",
				3.45, dateOfEnrollment, transcript,
				classroom);
		Student savedStudent = studentService.addNewStudent(student);
		System.out.println(savedStudent);
		printAllStudents();
		printStudentById((long) 1);
		printStudentById((long) 10);
		System.out.println("Finished execution");
	}

	private void printAllStudents() {
		var students = studentService.getAllStudents();
		students.forEach(System.out::println);
	}

	private void printStudentById(Long studentId) {
		var student = studentService.getStudentById(studentId);
		if (student != null)
			System.out.println(student);
		else
			System.out.printf("Student not found: %d\n", studentId);
	}

	private void updateStudent(Long studentId) {
		var student = studentService.getStudentById(studentId);
		var updateStudent = studentService.updatetStudent(student);
		System.out.println(updateStudent);
	}

	public void deleteStudentById(Long studentId) {
		studentService.deleteStudentById(studentId);
	}
}
