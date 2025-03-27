package com.GIMP_plugin_repository.BackEnd.Download.Service;

import com.GIMP_plugin_repository.BackEnd.Download.Dto.DownloadPluginDto;
import com.GIMP_plugin_repository.BackEnd.Download.Model.DownloadPlugin;
import com.GIMP_plugin_repository.BackEnd.Download.Repository.DownloadRepository;
import com.GIMP_plugin_repository.BackEnd.User.Model.User;
import com.GIMP_plugin_repository.BackEnd.User.Repository.UserRepository;
import com.GIMP_plugin_repository.BackEnd.Version.Model.PluginVersion;
import com.GIMP_plugin_repository.BackEnd.Version.Repository.PluginVersionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DownloadService {
    @Autowired
    private DownloadRepository downloadRepository;

    private PluginVersionRepository pluginVersionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public DownloadPluginDto createPluginDownload(DownloadPluginDto downloadPluginDto){
        DownloadPlugin downloadPlugin = modelMapper.map(downloadPluginDto, DownloadPlugin.class);

        User user = userRepository.findById(downloadPluginDto.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        PluginVersion pluginVersion = pluginVersionRepository.findById(downloadPluginDto.getPluginVersion().getId())
                .orElseThrow(() -> new RuntimeException("Plugin not found"));

        downloadPlugin.setUser(user);
        downloadPlugin.setPluginVersion(pluginVersion);

        downloadPlugin.setDownloadDate(LocalDate.now());

        DownloadPlugin savedDownload = downloadRepository.save(downloadPlugin);
        return  modelMapper.map(savedDownload, DownloadPluginDto.class);
    }

    public DownloadPluginDto getDownloadById(Long id){
        DownloadPlugin downloadPlugin = downloadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Download not found"));
        return modelMapper.map(downloadPlugin, DownloadPluginDto.class);

    }


}
