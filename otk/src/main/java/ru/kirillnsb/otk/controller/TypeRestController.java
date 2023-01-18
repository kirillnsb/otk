package ru.kirillnsb.otk.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kirillnsb.otk.model.Type;
import ru.kirillnsb.otk.repository.TypeRepository;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypeRestController {

    private final TypeRepository typeRepository;

    public TypeRestController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }


    @GetMapping
    public List<Type> list() {
        return typeRepository.findAll();
    }

    @GetMapping("{id}")
    public Type getOne(@PathVariable("id") Type type) {
        return type;
    }

    @PostMapping
    public Type create(@RequestBody Type type) {
        return typeRepository.save(type);
    }

    @PutMapping("{id}")
    public Type update(
            @PathVariable("id") Type typeFromDb,
            @RequestBody Type type
    ) {
        BeanUtils.copyProperties(type, typeFromDb, "id");

        return typeRepository.save(typeFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Type type) {
        typeRepository.delete(type);
    }
}
