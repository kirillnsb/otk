package ru.kirillnsb.otk.repository;

import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirillnsb.otk.model.Checkup;

import java.beans.BeanProperty;
import java.util.List;

public interface CheckupRepository extends JpaRepository<Checkup, Long> {

    List<Checkup> findByEmployeeRef(Long employee_ref);
}
