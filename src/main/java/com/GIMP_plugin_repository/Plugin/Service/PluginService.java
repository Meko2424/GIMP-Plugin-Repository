package com.GIMP_plugin_repository.Plugin.Service;

import com.GIMP_plugin_repository.Author.Model.Author;
import com.GIMP_plugin_repository.Author.Repository.AuthorRepository;
import com.GIMP_plugin_repository.Plugin.Dto.PluginDto;
import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.Plugin.Repository.PluginRepository;
import com.GIMP_plugin_repository.Version.Dto.PluginVersionDto;
import com.GIMP_plugin_repository.Version.Model.PluginVersion;
import com.GIMP_plugin_repository.Version.Repository.PluginVersionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PluginService {

    @Autowired
    private  PluginRepository pluginRepository;

   @Autowired
    private PluginVersionRepository pluginVersionRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private  ModelMapper modelMapper;

//    @Autowired
    public PluginService(PluginRepository pluginRepository, PluginVersionRepository pluginVersionRepository , ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.pluginRepository = pluginRepository;
        this.pluginVersionRepository = pluginVersionRepository;
    }

    //  Create or add a plugin
    public PluginDto createPlugin(PluginDto pluginDto) {
        Plugin plugin =  modelMapper.map(pluginDto, Plugin.class);

        Author author = authorRepository.findByName(pluginDto.getAuthorName())
                .orElseGet(() -> {
                    Author newAuthor = new Author();
                    newAuthor.setName(pluginDto.getAuthorName());
                    return authorRepository.save(newAuthor);
                });
        plugin.setAuthor(author);

        List<PluginVersion> pluginVersions = pluginDto.getPluginVersions().stream()
                .map(versionDto -> modelMapper.map(versionDto, PluginVersion.class))
                .collect(Collectors.toList());
        plugin.setPluginVersions(pluginVersions);

        pluginVersions.forEach(version -> version.setPlugin(plugin));
        Plugin savedPlugin = pluginRepository.save(plugin);
        return modelMapper.map(savedPlugin, PluginDto.class);
    }

    // Create a version

    public PluginVersionDto createPluginVersion(Long pluginId, PluginVersionDto pluginVersionDto){
        Plugin plugin = pluginRepository.findById(pluginId)
                .orElseThrow(() -> new RuntimeException("Plugin not found"));
        PluginVersion pluginVersion = modelMapper.map(pluginVersionDto, PluginVersion.class);
        pluginVersion.setPlugin(plugin);
        PluginVersion savedPluginVersion = pluginVersionRepository.save(pluginVersion);
        return modelMapper.map(savedPluginVersion, PluginVersionDto.class);
    }

    // Get all plugins

    public List<PluginDto> getAllPlugins() {
        List<Plugin> pluginList = pluginRepository.findAll();
        return   pluginList.stream().map(plugin -> modelMapper.map(plugin, PluginDto.class)).toList();

    }

    // Get a plugin by id
    public Optional<PluginDto> getPluginById(Long id){
        Plugin plugin = pluginRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return Optional.ofNullable(modelMapper.map(plugin, PluginDto.class));
    }

//    @GetMapping("/{id}/{versionId}")
    public PluginDto getPluginByVersionId(Long versionId){
        PluginVersion version =  pluginVersionRepository.findById(versionId)
                .orElseThrow(() -> new RuntimeException("Plugin with ID " + versionId +  " not found"));

        return modelMapper.map(version.getPlugin(), PluginDto.class);


    }

    public PluginDto updatePlugin(Long id, PluginDto pluginDto){
        Plugin plugin = pluginRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        Author author = authorRepository.findById(pluginDto.getId()).orElseThrow(() -> new RuntimeException("Author not found"));
        modelMapper.map(pluginDto, plugin);
        plugin.setAuthor(author);
        Plugin updatedPlugin = pluginRepository.save(plugin);
        return modelMapper.map(updatedPlugin, PluginDto.class);
    }

    public void deletePlugin(Long id) {
        pluginRepository.deleteById(id);
    }
}
