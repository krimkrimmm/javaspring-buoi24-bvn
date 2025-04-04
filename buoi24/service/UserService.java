package vn.scrip.buoi24.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.scrip.buoi24.entity.User;
import vn.scrip.buoi24.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }
}




