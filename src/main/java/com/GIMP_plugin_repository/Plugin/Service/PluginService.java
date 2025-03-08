package com.GIMP_plugin_repository.Plugin.Service;

import com.GIMP_plugin_repository.Plugin.Dto.PluginDto;

public interface PluginService {
   // void createPlugin(PluginDto pluginDto);

    public PluginDto getPluginById(Long id);

    public PluginDto createPlugin(PluginDto pluginDto);
}
