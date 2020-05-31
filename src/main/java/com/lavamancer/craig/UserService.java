package com.lavamancer.craig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired UserRepository userRepository;


    public User create() {
        User user = new User();
        user.setName("User " + (Math.random() * 1000f + 1000f));
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

}
