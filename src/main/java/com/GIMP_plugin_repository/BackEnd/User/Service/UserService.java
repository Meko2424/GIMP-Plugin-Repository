package com.GIMP_plugin_repository.BackEnd.User.Service;

import com.GIMP_plugin_repository.BackEnd.User.Dto.UserDto;
import com.GIMP_plugin_repository.BackEnd.User.Model.User;
import com.GIMP_plugin_repository.BackEnd.User.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public UserDto createUser(UserDto userDto){
        User user =  modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
        return  modelMapper.map(savedUser, UserDto.class);
    }

    public List<UserDto> getAllUsers(){
        List<User> user = userRepository.findAll();
        return user.stream().map(userList -> modelMapper.map(userList, UserDto.class)).toList();

    }

    public UserDto getUserById(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(user, UserDto.class);
    }


}
