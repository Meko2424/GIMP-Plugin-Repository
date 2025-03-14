package com.GIMP_plugin_repository.Download.Service;

import com.GIMP_plugin_repository.Download.Dto.DownloadPluginDto;
import com.GIMP_plugin_repository.Download.Model.DownloadPlugin;
import com.GIMP_plugin_repository.Download.Repository.DownloadRepository;
import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.Plugin.Repository.PluginRepository;
import com.GIMP_plugin_repository.User.Model.User;
import com.GIMP_plugin_repository.User.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DownloadService {
    @Autowired
    private DownloadRepository downloadRepository;

    private PluginRepository pluginRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public DownloadPluginDto createPluginDownload(DownloadPluginDto downloadPluginDto){
        DownloadPlugin downloadPlugin = modelMapper.map(downloadPluginDto, DownloadPlugin.class);

        User user = userRepository.findById(downloadPluginDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Plugin plugin = pluginRepository.findById(downloadPluginDto.getPluginId())
                .orElseThrow(() -> new RuntimeException("Plugin not found"));

        downloadPlugin.setUser(user);
        downloadPlugin.setPlugin(plugin);

        downloadPlugin.setDownloadDate(LocalDateTime.now());

        DownloadPlugin savedDownload = downloadRepository.save(downloadPlugin);
        return  modelMapper.map(savedDownload, DownloadPluginDto.class);
    }

    public DownloadPluginDto getDownloadById(Long id){
        DownloadPlugin downloadPlugin = downloadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Download not found"));
        return modelMapper.map(downloadPlugin, DownloadPluginDto.class);

    }


}
