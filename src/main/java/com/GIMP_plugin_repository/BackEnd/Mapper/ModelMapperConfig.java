package com.GIMP_plugin_repository.BackEnd.Mapper;

import com.GIMP_plugin_repository.BackEnd.User.Dto.UserRegisterDto;
import com.GIMP_plugin_repository.BackEnd.User.Model.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
//        return new ModelMapper();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setSkipNullEnabled(true)  // Ignore null values
                .setFieldMatchingEnabled(true);
        modelMapper.typeMap(UserRegisterDto.class, User.class)
                .addMappings(mapper -> mapper.skip(User::setId));
        modelMapper.typeMap(UserRegisterDto.class, User.class)
                .addMappings(mapper -> mapper.skip(User::setId));
        return modelMapper;
    }


}
