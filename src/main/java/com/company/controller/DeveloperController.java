package com.company.controller;

import com.company.entity.Developer;
import com.company.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/developer")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;
    @PostMapping("/add")
    public ResponseEntity<String> addDeveloper(@RequestBody Developer developer){
        System.err.println(developer);
        developerService.saveDevaloper(developer);
        return new ResponseEntity<>("Developer saved", HttpStatus.CREATED);

    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<Developer>> getAllData(){
        List<Developer> developerList = developerService.getAllDeveloper();
        return new ResponseEntity<>(developerList , HttpStatus.OK);

    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Developer> getDeveloperById(@PathVariable("id")int id){
        Developer developer = developerService.getAllDeveloperById(id);
        return new ResponseEntity<>(developer , HttpStatus.OK);
    }

    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<String> deleteBYId(@PathVariable("id")int id){
      String msg =  developerService.deleteDeveloperById(id);
      return new ResponseEntity<>(msg , HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Developer> updateDeveloper(@PathVariable("id")int id, @RequestBody Developer developer){
    Developer updateDeveloper = developerService.updateDeveloper(id , developer);
    return new ResponseEntity<>(updateDeveloper , HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Developer>> filterDeveloper(@RequestParam(required = false)String city , @RequestParam(required = false)String gender){
        List<Developer> sortedList = new ArrayList<>();
    if(gender == null){
       sortedList = developerService.filterDataByCity(city);
    }else{
        sortedList = developerService.filterDataByGender(gender);
    }
        return new ResponseEntity<>(sortedList , HttpStatus.OK);
    }
}
