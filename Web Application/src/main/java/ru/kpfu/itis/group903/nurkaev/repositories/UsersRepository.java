package ru.kpfu.itis.group903.nurkaev.repositories;

import ru.kpfu.itis.group903.nurkaev.models.User;

import java.util.List;

public interface UsersRepository extends CrudRepository<User> {
    List<User> findAllByAge(Integer age);
}
