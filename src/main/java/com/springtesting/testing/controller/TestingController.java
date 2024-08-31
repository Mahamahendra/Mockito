package com.springtesting.testing.controller;

import com.springtesting.testing.Entity.Testing;
import com.springtesting.testing.Global.IdAlreadyExist;
import com.springtesting.testing.Global.InvalidAge;
import com.springtesting.testing.Global.NoElementFound;
import com.springtesting.testing.service.TestingService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TestingController {
    @Autowired
    TestingService ser;

    @PostMapping(value="/save")
    public ResponseEntity<Testing> addData(@RequestBody Testing add) throws IdAlreadyExist, InvalidAge {
        return new ResponseEntity<>(ser.addData(add), HttpStatus.CREATED);
    }

    @PostMapping(value="/saveAll")
    public ResponseEntity<List<Testing>> addAllData(@RequestBody List<Testing> addAll) {
        return new ResponseEntity<>(ser.addAllData(addAll), HttpStatus.CREATED);
    }
    @GetMapping(value="/findById/id")
    public ResponseEntity<Testing> getById(@PathVariable int id) throws NoElementFound {
        return ResponseEntity.ok(ser.getById(id));
    }
    @GetMapping(value="/findAll")
    public ResponseEntity<List<Testing>> getAll() throws  NoElementFound{
        return ResponseEntity.ok(ser.getAll());
    }

    @PutMapping(value="/update/{id}")
    public ResponseEntity<Testing> getUpdate(@RequestBody Testing upd, @PathVariable int id){
        Testing update = ser.getUpdate(upd,id);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }
    @DeleteMapping(value="/getDelete")
    public ResponseEntity<String> getDelete(@PathVariable int id) {
        return ResponseEntity.ok(ser.getDelete(id));
    }
}
