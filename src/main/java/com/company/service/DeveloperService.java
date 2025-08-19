package com.company.service;

import com.company.entity.Developer;

import java.util.List;

public interface DeveloperService {

    String saveDevaloper(Developer developer);

    List<Developer> getAllDeveloper();

    Developer getDeveloperById(int Id);

    Developer getAllDeveloperById(int id);

    String deleteDeveloperById(int id);

    Developer updateDeveloper(int id , Developer newData);

    List<Developer> filterDataByCity(String city);

    List<Developer> filterDataByGender(String gender);

    List<Developer> getDeveloperByAge(int age);

}
