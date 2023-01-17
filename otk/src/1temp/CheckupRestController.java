package ru.kirillnsb.otk.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kirillnsb.otk.model.Checkup;
import ru.kirillnsb.otk.service.CheckupService;

@RestController
@RequestMapping("/checkups")
public class CheckupRestController {
    final CheckupService checkupService;

    public CheckupRestController(CheckupService checkupService) {
        this.checkupService = checkupService;
    }

    @PostMapping
    public ResponseEntity createCheckup(@RequestBody Checkup checkup, @RequestParam Long employee_id){
        return ResponseEntity.ok(checkupService.createCheckup(checkup, employee_id));
    }
}
