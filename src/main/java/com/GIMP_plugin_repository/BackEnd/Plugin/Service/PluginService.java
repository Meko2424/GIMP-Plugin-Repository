package com.GIMP_plugin_repository.BackEnd.Plugin.Service;

import com.GIMP_plugin_repository.BackEnd.Plugin.Dto.PluginDto;
import com.GIMP_plugin_repository.BackEnd.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.BackEnd.Plugin.Repository.PluginRepository;
//import com.GIMP_plugin_repository.BackEnd.Review.Repository.ReviewRepository;
import com.GIMP_plugin_repository.BackEnd.Version.Dto.PluginVersionDto;
import com.GIMP_plugin_repository.BackEnd.Version.Model.PluginVersion;
import com.GIMP_plugin_repository.BackEnd.Version.Repository.PluginVersionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PluginService {

    @Autowired
    private PluginRepository pluginRepository;

    @Autowired
    private PluginVersionRepository pluginVersionRepository;


    @Autowired
    private ModelMapper modelMapper;

    //    @Autowired
    public PluginService(PluginRepository pluginRepository, PluginVersionRepository pluginVersionRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.pluginRepository = pluginRepository;
        this.pluginVersionRepository = pluginVersionRepository;
    }

    //  Create or add a plugin
    public PluginDto createPlugin(PluginDto pluginDto) {
        Plugin plugin = modelMapper.map(pluginDto, Plugin.class);
        plugin.setFileUrl(pluginDto.getFileUrl());

        List<PluginVersion> pluginVersions = new ArrayList<>();
        if (pluginDto.getPluginVersions() != null){
            pluginVersions = pluginDto.getPluginVersions().stream()
                    .map(versionDto -> modelMapper.map(versionDto, PluginVersion.class))
                    .collect(Collectors.toList());
        }

        plugin.setPluginVersions(pluginVersions);
        pluginVersions.forEach(version -> version.setPlugin(plugin));
        Plugin savedPlugin = pluginRepository.save(plugin);
        return modelMapper.map(savedPlugin, PluginDto.class);
    }


    public List<PluginDto> getAllPlugins(){
        List<Plugin> plugins = pluginRepository.findAll();
        return plugins.stream().map(plugin -> modelMapper.map(plugin, PluginDto.class)).toList();
    }

    public PluginDto getPluginById(Long id) {
        Plugin plugin = pluginRepository.findById(id).orElseThrow(() -> new RuntimeException("Plugin not found"));

        PluginDto dto = new PluginDto();
        dto.setId(plugin.getId());
        dto.setTitle(plugin.getTitle());
        dto.setDescription(plugin.getDescription());
        dto.setImageUrl(plugin.getImageUrl());

//        if (plugin.getCategory() != null) {
//            dto.setCategoryId(plugin.getCategory().getId());
//        }

        if (plugin.getPluginVersions() != null) {
            List<PluginVersionDto> versions = plugin.getPluginVersions().stream()
                    .map(version -> modelMapper.map(version, PluginVersionDto.class))
                    .collect(Collectors.toList());
            dto.setPluginVersions(versions);
        }
        return dto;
    }

//    public List<PluginDto> getPluginsByCategoryId(Long categoryId) {
//        List<Plugin> plugins = pluginRepository.findByCategoryId(categoryId);
//        return plugins.stream().map(extension -> modelMapper.map(extension, PluginDto.class)).collect(Collectors.toList());
//    }

    // There is no update method in Jpa, so play with save method
    public PluginDto updatePlugin(Long id, PluginDto pluginDto) {
        Plugin existingplugin = pluginRepository.findById(id).orElseThrow(() -> new RuntimeException("Plugin not found"));

        List<PluginVersion> pluginVersions = pluginVersionRepository.findByPluginId(id);

        // Update the fields
        existingplugin.setTitle(pluginDto.getTitle());
        existingplugin.setDescription(pluginDto.getDescription());

        existingplugin.setPluginVersions(pluginVersions);

        // Save the updated plugin
        Plugin updatedPlugin = pluginRepository.save(existingplugin);

        // Return the updated DTO
        return modelMapper.map(updatedPlugin, PluginDto.class);
    }

    public void deletePlugin(Long id) {
        pluginRepository.deleteById(id);
    }

}
