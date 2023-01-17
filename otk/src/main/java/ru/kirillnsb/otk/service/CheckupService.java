package ru.kirillnsb.otk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kirillnsb.otk.model.Checkup;
import ru.kirillnsb.otk.repository.CheckupRepository;

import java.util.List;

@Service
public class CheckupService {
    private final CheckupRepository checkupRepository;

    public CheckupService(CheckupRepository checkupRepository) {
        this.checkupRepository = checkupRepository;
    }
    public void deleteById(Long id){checkupRepository.deleteById(id);    }

    public Checkup findById(Long id){
        return checkupRepository.getOne(id);
    }

    public List<Checkup> findAll(){
        return checkupRepository.findAll();
    }

    public List<Checkup> findByEmployeeRef(Long employeeRef){
        return checkupRepository.findAll();
    }

    public Checkup saveCheckup(Checkup checkup){
        return checkupRepository.save(checkup);
    }







}
