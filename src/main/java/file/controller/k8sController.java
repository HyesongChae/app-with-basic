package file.controller;

import java.io.Console;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import file.entity.Student;
import file.service.StudentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class k8sController {
	
	private final StudentService studentService;
	
	@GetMapping(value = "/api/actions")
	public String actionsTest() {
		return "app-with-actions version:0.0.3" ;
	}
	
	@PostMapping(value = "/api/students")
	public Student insertStudent (@RequestBody Student student) {
		return studentService.insertStudent(student);
	}
	
	@GetMapping(value = "/api/students")
	public List<Student> selectStudentAll () {
		List<Student> stds = studentService.selectStudentAll();
		return stds;
	}
	
	@GetMapping(value = "/api/students/{id}")
	public Student selectStudent (@PathVariable Long id) {
		return studentService.selectStudent(id);
	}
	
	@PutMapping(value = "/api/students/{id}")
	public void updateStudent (@PathVariable Long id, Student student) {
		studentService.updateStudent(id, student);
	}
	
	@DeleteMapping(value = "/api/students/{id}")
	public void deleteStudent (@PathVariable Long id) {
		studentService.deleteStudent(id);
	}
}
