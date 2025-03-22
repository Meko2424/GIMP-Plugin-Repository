package com.GIMP_plugin_repository.Plugin.Service;

import com.GIMP_plugin_repository.Author.Model.Author;
import com.GIMP_plugin_repository.Author.Repository.AuthorRepository;
import com.GIMP_plugin_repository.Category.Model.Category;
import com.GIMP_plugin_repository.Category.Repository.CategoryRepository;
import com.GIMP_plugin_repository.Plugin.Dto.PluginDto;
import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.Plugin.Repository.PluginRepository;
import com.GIMP_plugin_repository.Review.Dto.ReviewDto;
import com.GIMP_plugin_repository.Review.Model.Review;
import com.GIMP_plugin_repository.Review.Repository.ReviewRepository;
import com.GIMP_plugin_repository.Version.Dto.PluginVersionDto;
import com.GIMP_plugin_repository.Version.Model.PluginVersion;
import com.GIMP_plugin_repository.Version.Repository.PluginVersionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PluginService {

    @Autowired
    private PluginRepository pluginRepository;
    @Autowired
    private ReviewRepository reviewRepository;

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

        Author author = authorRepository.findByName(pluginDto.getAuthorName())
                .orElseGet(() -> {
                    Author newAuthor = new Author();
                    newAuthor.setName(pluginDto.getAuthorName());
                    return authorRepository.save(newAuthor);
                });
        Category category = categoryRepository.findByName(pluginDto.getCategoryName())
                .orElseGet(() -> {
                    Category newCategory = new Category();
                    newCategory.setName(pluginDto.getCategoryName());
                    return categoryRepository.save(newCategory);
                });
        plugin.setAuthor(author);
        plugin.setCategory(category);

        List<PluginVersion> pluginVersions = pluginDto.getPluginVersions().stream()
                .map(versionDto -> modelMapper.map(versionDto, PluginVersion.class))
                .collect(Collectors.toList());
        plugin.setPluginVersions(pluginVersions);

        pluginVersions.forEach(version -> version.setPlugin(plugin));
        Plugin savedPlugin = pluginRepository.save(plugin);
        return modelMapper.map(savedPlugin, PluginDto.class);
    }

    // Get all plugins
    public List<PluginDto> getAllPlugins() {
        List<Plugin> pluginList = pluginRepository.findAll();
        return pluginList.stream().map(plugin -> modelMapper.map(plugin, PluginDto.class)).toList();
    }

    // Get a plugin by id
    public Optional<PluginDto> getPluginById(Long id) {
        Plugin plugin = pluginRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return Optional.ofNullable(modelMapper.map(plugin, PluginDto.class));
    }

    // There is no update method in Jpa, so play with save method
    public PluginDto updatePlugin(Long id, PluginDto pluginDto) {
        Plugin existingplugin = pluginRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        Author author = authorRepository.findByName(pluginDto.getAuthorName()).orElseThrow(() -> new RuntimeException("Author not found"));
        Category category = categoryRepository.findByName(pluginDto.getCategoryName()).orElseThrow(() -> new RuntimeException("Category not found"));
        List<PluginVersion> pluginVersions = pluginVersionRepository.findByPluginId(id);

        // Update the fields
        existingplugin.setTitle(pluginDto.getTitle());
        existingplugin.setDescription(pluginDto.getDescription());
        existingplugin.setAuthor(author);
        existingplugin.setCategory(category);
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
