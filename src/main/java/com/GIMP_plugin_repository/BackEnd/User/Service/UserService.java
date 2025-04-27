
package com.GIMP_plugin_repository.BackEnd.User.Service;

import com.GIMP_plugin_repository.BackEnd.User.Dto.UserRegisterDto;
import com.GIMP_plugin_repository.BackEnd.User.Dto.UserLoginDto;
import com.GIMP_plugin_repository.BackEnd.User.Model.User;
import com.GIMP_plugin_repository.BackEnd.User.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserRegisterDto registerUser(UserRegisterDto userRegisterDto) {
        User user = modelMapper.map(userRegisterDto, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserRegisterDto.class);
    }

    public UserLoginDto loginUser(UserLoginDto loginDto) {
        User user = userRepository.findByEmailId(loginDto.getEmailId());
        if (user != null && passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            return modelMapper.map(user, UserLoginDto.class);
        }
        return null;
    }

}

















































//package com.GIMP_plugin_repository.BackEnd.User.Service;
//
//import com.GIMP_plugin_repository.BackEnd.User.Dto.UserRegisterDto;
//import com.GIMP_plugin_repository.BackEnd.User.Dto.UserLoginDto;
//import com.GIMP_plugin_repository.BackEnd.User.Model.User;
//import com.GIMP_plugin_repository.BackEnd.User.Repository.UserRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public UserRegisterDto createUser(UserRegisterDto userDto){
//        User user =  modelMapper.map(userDto, User.class);
//
//
//        User savedUser = userRepository.save(user);
//        return  modelMapper.map(savedUser, UserRegisterDto.class);
//    }
//
//    public UserLoginDto loginUser(UserLoginDto loginDto){
//        User user = userRepository.findByEmailIdAndPasswordAndRole(
//                loginDto.getEmailId(),
//                loginDto.getPassword(),
//                loginDto.getRole()
//        );
//        if(user != null){
//            return modelMapper.map(user, UserLoginDto.class);
//        }
//        return null;
//    }
//
//    public List<UserRegisterDto> getUsersByRole(String role) {
//        List<User> users = userRepository.findByRole(role);
//        return users.stream()
//                .map(user -> modelMapper.map(user, UserRegisterDto.class))
//                .collect(Collectors.toList());
//    }
//
//    public List<UserRegisterDto> getAllUsers(){
//        List<User> user = userRepository.findAll();
//        return user.stream().map(userList -> modelMapper.map(userList, UserRegisterDto.class)).toList();
//
//    }
//
//    public UserRegisterDto getUserById(Long userId){
//        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
//        return modelMapper.map(user, UserRegisterDto.class);
//    }
//
//
//}
