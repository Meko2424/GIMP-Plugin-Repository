//package com.GIMP_plugin_repository.Plugin.Dto;
//
//
//import com.GIMP_plugin_repository.Plugin.Model.Plugin;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class MappingService {
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public PluginDto toDto(Plugin plugin){
//        return modelMapper.map(plugin, PluginDto.class);
//    }
//
//    public List<PluginDto> toDtoList(List<Plugin> plugins){
//        return plugins.stream()
//                .map(this::toDto)
//                .collect(Collectors.toList());
//    }
//
//
//}
