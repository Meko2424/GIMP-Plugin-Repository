package com.GIMP_plugin_repository.BackEnd.Version.Service;

import com.GIMP_plugin_repository.BackEnd.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.BackEnd.Plugin.Repository.PluginRepository;
import com.GIMP_plugin_repository.BackEnd.Version.Dto.PluginVersionDto;
import com.GIMP_plugin_repository.BackEnd.Version.Model.PluginVersion;
import com.GIMP_plugin_repository.BackEnd.Version.Repository.PluginVersionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PluginVersionService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PluginVersionRepository pluginVersionRepository;

    @Autowired
    private PluginRepository pluginRepository;



    // Get all versions associated with a specific plugin
    public List<PluginVersionDto> getPluginVersionsByPluginId(Long pluginId) {
        List<PluginVersion> versions = pluginVersionRepository.findByPluginId(pluginId);
        return versions.stream().map(version -> modelMapper.map(version, PluginVersionDto.class))
                .collect(Collectors.toList());
    }

    // Create a version
    public PluginVersionDto createPluginVersion(Long pluginId, PluginVersionDto pluginVersionDto) {
        // Retrieve plugin by pluginId
        Plugin plugin = pluginRepository.findById(pluginId)
                .orElseThrow(() -> new RuntimeException("Plugin not found"));
        PluginVersion pluginVersion = modelMapper.map(pluginVersionDto, PluginVersion.class);
        pluginVersion.setPlugin(plugin);
        PluginVersion savedPluginVersion = pluginVersionRepository.save(pluginVersion);
        return modelMapper.map(savedPluginVersion, PluginVersionDto.class);
    }









}
