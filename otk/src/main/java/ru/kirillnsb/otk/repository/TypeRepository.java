package ru.kirillnsb.otk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirillnsb.otk.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
