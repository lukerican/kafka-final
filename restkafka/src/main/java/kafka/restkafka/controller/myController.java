package kafka.restkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import kafka.restkafka.models.Student;
import kafka.restkafka.rep.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("/student")
public class myController  {
    @Autowired
    private StudentRepository studentRepository;
    @PostMapping("/")
    public ResponseEntity<?> addStudent(@RequestBody Student student)
    {
        Student save = this.studentRepository.save(student);
        return ResponseEntity.ok(save);
    }
    @GetMapping("/")
    public ResponseEntity<?> getStudent()
    {
        return ResponseEntity.ok(this.studentRepository.findAll());
    }
    @GetMapping("/{ID}")
    public Student getBookById(@PathVariable String ID) {
        return studentRepository.findById(ID).orElse(null);
    }

    @PutMapping("/")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student)
    {
        return ResponseEntity.ok(studentRepository.save(student));
    }

    @DeleteMapping("/{ID}")
    public void deleteStudent(@PathVariable String ID) {
        studentRepository.deleteById(ID);
    }
}

