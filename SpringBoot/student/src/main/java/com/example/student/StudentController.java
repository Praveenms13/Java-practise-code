package com.example.student;

import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@RequestMapping("/students")
public class StudentController {
    private final List<Student> studentList = new ArrayList<>();
    private int id = 0;
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentList;
    }
    @PostMapping("/addStudent")
    public ApiResponse addStudent(@RequestBody Student student) {
        for  (Student s : studentList) {
            if (s.getName().equals(student.getName()) || s.getEmail().equals(student.getEmail())) {
                return new ApiResponse(false, "Student already exists");
            }
        }
        student.setId(++this.id);
        studentList.add(student);
        return new ApiResponse(true, "Student added successfully");
    }

    @PutMapping("/updateStudent/{id}")
    public ApiResponse updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                if (updatedStudent.getName() != null) {
                    student.setName(updatedStudent.getName());
                }
                if (updatedStudent.getEmail() != null) {
                    student.setEmail(updatedStudent.getEmail());
                }
                return new ApiResponse(true, "Student updated successfully");
            }
        }
        return new ApiResponse(false, "Student not found");
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ApiResponse deleteStudent(@PathVariable int id) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                return new ApiResponse(true, "Student deleted successfully");
            }
        }
        return new ApiResponse(false, "Student not found");
    }
}
