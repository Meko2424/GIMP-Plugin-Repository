package com.GIMP_plugin_repository.BackEnd.Plugin.Service;

import com.GIMP_plugin_repository.BackEnd.Author.Model.Author;
import com.GIMP_plugin_repository.BackEnd.Author.Repository.AuthorRepository;
import com.GIMP_plugin_repository.BackEnd.Category.Model.Category;
import com.GIMP_plugin_repository.BackEnd.Category.Repository.CategoryRepository;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PluginService {

    @Autowired
    private PluginRepository pluginRepository;
   // @Autowired
    //private ReviewRepository reviewRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PluginVersionRepository pluginVersionRepository;

    @Autowired
    private AuthorRepository authorRepository;

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
        Optional<Category> category = categoryRepository.findById(pluginDto.getCategoryId());
        Category category1 = null;
        if(category.isPresent()){
            category1 = category.get();
        }
//        Author author = authorRepository.findById(pluginDto.getAuthorId())
//                .orElseGet(() -> {
//                    Author newAuthor = new Author();
//                    return authorRepository.save(newAuthor);
//                });
//        Category category = categoryRepository.findById(pluginDto.getCategoryId())
//                .orElseGet(() -> {
//                    Category newCategory = new Category();
//                    return categoryRepository.save(newCategory);
//                });

 //       plugin.setAuthor(author);
        plugin.setCategory(category1);

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


    // Modified method for getAllPlugins();
    public List<PluginDto> getAllPlugins(){
        List<Plugin> plugins = pluginRepository.findAll();
        return plugins.stream().map(plugin -> modelMapper.map(plugin, PluginDto.class)).toList();
    }

    // Get a plugin by id
    public PluginDto getPluginById(Long id) {
        Plugin plugin = pluginRepository.findById(id).orElseThrow(() -> new RuntimeException("Plugin not found"));

        PluginDto dto = new PluginDto();
        dto.setId(plugin.getId());
        dto.setTitle(plugin.getTitle());
        dto.setDescription(plugin.getDescription());
        dto.setImageUrl(plugin.getImageUrl());

        if (plugin.getCategory() != null) {
            dto.setCategoryId(plugin.getCategory().getId());
        }

        // Uncomment and update if needed
        // if (extension.getAuthor() != null) {
        //     dto.setAuthorId(extension.getAuthor().getId());
        //     dto.setAuthorName(extension.getAuthor().getName());
        // }

        if (plugin.getPluginVersions() != null) {
            List<PluginVersionDto> versions = plugin.getPluginVersions().stream()
                    .map(version -> modelMapper.map(version, PluginVersionDto.class))
                    .collect(Collectors.toList());
            dto.setPluginVersions(versions);
        }

        return dto;
    }

    // There is no update method in Jpa, so play with save method
    public PluginDto updatePlugin(Long id, PluginDto pluginDto) {
        Plugin existingplugin = pluginRepository.findById(id).orElseThrow(() -> new RuntimeException("Plugin not found"));
       // Author author = authorRepository.findById(pluginDto.getAuthorId()).orElseThrow(() -> new RuntimeException("Author not found"));
        //Category category = categoryRepository.findByName(pluginDto.getCategoryName()).orElseThrow(() -> new RuntimeException("Category not found"));
        List<PluginVersion> pluginVersions = pluginVersionRepository.findByPluginId(id);

        // Update the fields
        existingplugin.setTitle(pluginDto.getTitle());
        existingplugin.setDescription(pluginDto.getDescription());
        //existingplugin.setAuthor(author);
        //existingplugin.setCategory(category);
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
