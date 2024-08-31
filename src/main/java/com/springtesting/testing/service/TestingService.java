package com.springtesting.testing.service;

import com.springtesting.testing.Entity.Testing;
import com.springtesting.testing.Global.IdAlreadyExist;
import com.springtesting.testing.Global.InvalidAge;
import com.springtesting.testing.Global.NoElementFound;
import com.springtesting.testing.repository.TestingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class TestingService {
    @Autowired
    TestingRepository rep;

    public Testing addData(Testing add) throws IdAlreadyExist, InvalidAge {
//        if(rep.existsById(add.getId())){
//            throw new IdAlreadyExist("Id Exist :"+add.getId());
//        }
        if(add.getAge()<=18){
            throw new InvalidAge("Age must be above 18 : "+add.getAge());
        }
        return rep.save(add);
    }

    public List<Testing> addAllData(List<Testing> addAll)  {
//        List<Testing> list = new ArrayList<>();
       // for (Testing t : addAll) {
//            if (rep.existsById(t.getId())) {
//                throw new IdAlreadyExist("ID Exist :" + t.getId());
//            }
//            if (t.getAge() <= 18) {
//                throw new InvalidAge("Age must be above 18 : " + t.getAge());
//            }
//            list.add(rep.save(t));

            //or
//            if (t.getAge() >= 18) {
//               list.add(rep.save(t));
//            }
//            else {
//                throw new InvalidAge("Age must be 18");
//            }
//        }
        return rep.saveAll(addAll);
    }

    public Testing getById(int id) throws NoElementFound {
        return rep.findById(id).orElseThrow(()-> new NoElementFound("No id Found"));
    }
    public List<Testing> getAll(){
        return rep.findAll();
    }
    public Testing getUpdate(Testing upd, int id){
        Testing find = rep.findById(id).orElseThrow(()-> new NoSuchElementException("Id not found"));
        find.setAge(upd.getAge());
        find.setDepartment(upd.getDepartment());
        find.setGender(upd.getGender());
        find.setName(upd.getName());
        find.setYearOfJoining(upd.getYearOfJoining());
        find.setSalary(upd.getSalary());
        return find;
    }
    public String getDelete(int id){
        rep.deleteById(id);
        return "Deleted";
    }
}
