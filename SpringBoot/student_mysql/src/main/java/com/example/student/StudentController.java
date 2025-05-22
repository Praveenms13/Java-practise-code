package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/addStudent")
    public ApiResponse addStudent(@RequestBody Student student) {
        // Optional: Check for duplicates by email or name
        List<Student> existingStudents = studentRepository.findAll();
        for (Student s : existingStudents) {
            if (s.getName().equalsIgnoreCase(student.getName()) ||
                    s.getEmail().equalsIgnoreCase(student.getEmail())) {
                return new ApiResponse(false, "Student already exists");
            }
        }

        studentRepository.save(student);
        return new ApiResponse(true, "Student added successfully");
    }

    @PutMapping("/updateStudent/{id}")
    public ApiResponse updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            if (updatedStudent.getName() != null) {
                student.setName(updatedStudent.getName());
            }
            if (updatedStudent.getEmail() != null) {
                student.setEmail(updatedStudent.getEmail());
            }
            studentRepository.save(student);
            return new ApiResponse(true, "Student updated successfully");
        }
        return new ApiResponse(false, "Student not found");
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ApiResponse deleteStudent(@PathVariable int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return new ApiResponse(true, "Student deleted successfully");
        }
        return new ApiResponse(false, "Student not found");
    }
}
