package com.example.school_system.controller;

import com.example.school_system.dto.ServiceResponse;
import com.example.school_system.dto.User;
import com.example.school_system.repository.UserReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserReository repo;
    List<User> userList = new ArrayList<>();

    @PostMapping("/saveStudent")
    public ResponseEntity<Object> addStudent(@RequestBody User user) {
        userList.add(user);
        repo.save(user);
        ServiceResponse<User> response = new ServiceResponse<User>("success", user);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/getStudents")
    public ResponseEntity<Object> getAllStudent() {
        ServiceResponse<List<User>> response = new ServiceResponse<>("success", userList);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/delete")
    //public String deleteStudent(@PathVariable(name = "id") Long reg_no, Model model) {
        public ResponseEntity<User> deleteSt(@PathVariable (value="reg_no") Long reg_no){
            User existingSt = this.repo.findById(reg_no).orElseThrow();
            this.repo.delete(existingSt);
            return ResponseEntity.ok().build();
    }

}
