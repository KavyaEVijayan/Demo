package com.demo.example.service;

import com.demo.example.entity.User;
import com.demo.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class UserService {
private final UserRepository userRepository;
    public User saveUser(User billDetails) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            userRepository.save(billDetails);
            map.put("successFlag", 1);
            map.put("message", "Unit Saved Successfully");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("successFlag", 0);
            map.put("message", "Save Faild , Please Try again");
        }

        return billDetails;
    }
}
