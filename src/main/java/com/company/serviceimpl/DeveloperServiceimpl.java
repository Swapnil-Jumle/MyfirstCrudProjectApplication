package com.company.serviceimpl;

import com.company.entity.Developer;
import com.company.helper.DeveloperIdGenerator;
import com.company.repository.DeveloperRepository;
import com.company.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeveloperServiceimpl  implements DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public Developer getDeveloperById(int Id) {
        return null;
    }

    @Override
    public Developer getAllDeveloperById(int id) {
       Developer developer = developerRepository.findById(id).orElseThrow(()-> new NullPointerException("Developer with id not found"+id));
        return developer;
    }

    @Override
    public String saveDevaloper(Developer developer) {

       String developerid = DeveloperIdGenerator.generateDeveloperId(developer);
       developer.setDeveloperId(developerid);

        Developer saveDeveloper = developerRepository.save(developer);
        if (saveDeveloper != null) {
            return "developer saved";
        } else {
            return "Developer is not saved";
        }
    }



    @Override
    public List<Developer> getAllDeveloper() {
        List<Developer> developerList = developerRepository.findAll();
        return developerList;
    }


    @Override
    public String deleteDeveloperById(int id) {
        developerRepository.deleteById(id);
        return "Developer Deleted";
    }

    @Override
    public Developer updateDeveloper(int id, Developer newData) {
        Developer developer =developerRepository.findById(id).orElseThrow(()-> new NullPointerException("No data found for update in DB with id"+id));
        System.err.println(("Old developer from DB "+developer));
        System.err.println(("Developer dojvt with value to be updated"+newData));
        developer.setFName(newData.getFName());
        developer.setLName(newData.getLName());
        developer.setAge(newData.getAge());
        developer.setCity(newData.getCity());
        developer.setSalary(newData.getSalary());

        Developer updatedDeveloper = developerRepository.save(developer);
        System.err.println("Developer with updated value "+ updatedDeveloper);

        return updatedDeveloper;
    }

    @Override
    public List<Developer> filterDataByCity(String city){
        List<Developer> developerList = developerRepository.findAll();
        List<Developer> filteredList = developerList.stream().filter(developer -> developer.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
        return filteredList;
    }

    @Override
    public List<Developer> filterDataByGender(String gender) {
        List<Developer> developerList = developerRepository.findAll();
        List<Developer> filteredList = developerList.stream().filter(developer -> developer.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
        return filteredList;
    }
}
