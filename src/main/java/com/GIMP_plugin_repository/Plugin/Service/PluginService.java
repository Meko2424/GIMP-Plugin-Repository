package com.GIMP_plugin_repository.Plugin.Service;

import com.GIMP_plugin_repository.Author.Model.Author;
import com.GIMP_plugin_repository.Author.Repository.AuthorRepository;
import com.GIMP_plugin_repository.Plugin.Dto.PluginDto;
import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.Plugin.Repository.PluginRepository;
import com.GIMP_plugin_repository.Version.Model.PluginVersion;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PluginService {

    @Autowired
    private  PluginRepository pluginRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private  ModelMapper modelMapper;

    @Autowired
    public PluginService(PluginRepository pluginRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.pluginRepository = pluginRepository;
    }

    public PluginDto createPlugin(PluginDto pluginDto) {
        Author author = authorRepository.findByName(pluginDto.getAuthorName())
                .orElseGet(() -> {
                    Author newAuthor = new Author();
                    newAuthor.setName(pluginDto.getAuthorName());
                    return authorRepository.save(newAuthor);
                });
        Plugin plugin =  modelMapper.map(pluginDto, Plugin.class);
        plugin.setAuthor(author);

        List<PluginVersion> pluginVersions = pluginDto.getPluginVersions().stream()
                .map(versionDto -> modelMapper.map(versionDto, PluginVersion.class))
                .collect(Collectors.toList());
        plugin.setPluginVersions(pluginVersions);
        pluginVersions.forEach(version -> version.setPlugin(plugin));
        Plugin savedPlugin = pluginRepository.save(plugin);
        return modelMapper.map(savedPlugin, PluginDto.class);

    }

    public List<PluginDto> getAllPlugins() {
        List<Plugin> pluginList = pluginRepository.findAll();
        return   pluginList.stream().map(plugin -> modelMapper.map(plugin, PluginDto.class)).toList();

    }


    public Optional<PluginDto> getPluginById(Long id){
        Plugin plugin = pluginRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));;
        return Optional.ofNullable(modelMapper.map(plugin, PluginDto.class));
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
