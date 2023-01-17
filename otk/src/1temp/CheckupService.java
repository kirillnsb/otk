package ru.kirillnsb.otk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kirillnsb.otk.model.Checkup;
import ru.kirillnsb.otk.model.User;
import ru.kirillnsb.otk.repository.CheckupRepository;
import ru.kirillnsb.otk.repository.UserRepository;

@Service
public class CheckupService {

    private final CheckupRepository checkupRepository;
    private final UserRepository userRepository;
    public CheckupService(CheckupRepository checkupRepository, UserRepository userRepository) {
        this.checkupRepository = checkupRepository;
        this.userRepository = userRepository;
    }

    public Checkup createCheckup(Checkup checkup, Long employee_id){
        User user = userRepository.findById(employee_id).get();
        //checkup.setUser(user);
        return checkupRepository.save(checkup);
    }
}
