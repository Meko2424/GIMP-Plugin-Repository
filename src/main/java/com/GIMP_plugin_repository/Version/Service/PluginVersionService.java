package com.GIMP_plugin_repository.Version.Service;

import com.GIMP_plugin_repository.Version.Dto.PluginVersionDto;
import com.GIMP_plugin_repository.Version.Model.PluginVersion;
import com.GIMP_plugin_repository.Version.Repository.PluginVersionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PluginVersionService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PluginVersionRepository pluginVersionRepository;

    public PluginVersionDto getPluginByIdAndVersionId(Long pluginId, Long versionId){
        PluginVersion pluginVersion = pluginVersionRepository.findByPluginIdAndId(pluginId, versionId);
        return modelMapper.map(pluginVersion, PluginVersionDto.class);

    }


}
