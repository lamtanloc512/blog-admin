package org.jdev.blog.app.services.impl;

import org.jdev.blog.app.dto.UserDto;
import org.jdev.blog.app.entity._User;
import org.jdev.blog.app.repository.UserRepository;
import org.jdev.blog.app.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
	}

	@Override
    public void createUser(UserDto userDto) {
        try {
            _User user = this.modelMapper.map(userDto, _User.class);
            userRepository.save(user);
        } catch (Exception e) {
            log.error("Exception occured when save new user: {}", e.getMessage());
        }
        
	}
    
}
