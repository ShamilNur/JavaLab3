package ru.kpfu.itis.group903.nurkaev.services;

import ru.kpfu.itis.group903.nurkaev.models.User;
import ru.kpfu.itis.group903.nurkaev.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public List<User> getUsersByAge(int age) {
        return usersRepository.findAllByAge(age);
    }

    @Override
    public void save(User entity) {
        usersRepository.save(entity);
    }

    @Override
    public void delete(User entity) {
        usersRepository.delete(entity);
    }

    @Override
    public void update(User entity) {
        usersRepository.update(entity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return usersRepository.findById(id);
    }
}
