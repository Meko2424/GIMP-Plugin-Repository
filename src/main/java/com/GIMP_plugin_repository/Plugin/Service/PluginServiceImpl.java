package com.GIMP_plugin_repository.Plugin.Service;

import com.GIMP_plugin_repository.Author.Model.Author;
import com.GIMP_plugin_repository.Author.Repository.AuthorRepository;
import com.GIMP_plugin_repository.Category.Model.Category;
import com.GIMP_plugin_repository.Category.Repository.CategoryRepository;
import com.GIMP_plugin_repository.Plugin.Dto.PluginDto;
import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.Plugin.Repository.PluginRepository;
import com.GIMP_plugin_repository.Tag.Model.Tag;
import com.GIMP_plugin_repository.Tag.Repository.TagRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PluginServiceImpl implements PluginService{

    @Autowired
    private PluginRepository pluginRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;


//    private PluginVersionRepository pluginVersionRepository;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public PluginDto getPluginById(Long id) {
        return null;
    }


    @Override
    public PluginDto createPlugin(PluginDto pluginDto) {


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

         Plugin plugin = new Plugin();
         plugin.setTitle(pluginDto.getTitle());
         plugin.setDescription(pluginDto.getDescription());
         plugin.setCategory(category);
         plugin.setAuthor(author);
//         plugin.setTag(tag);
         plugin.setVersionNumber(pluginDto.getVersionNumber());
         plugin = pluginRepository.save(plugin);
         return new PluginDto(plugin);






        /*

         // convert pluginDto into entity class
        Plugin plugin = new Plugin();
        // copies all the state in the pluginDto to the plugin object. Source -to-> target
        BeanUtils.copyProperties(pluginDto, plugin);
        plugin = pluginRepository.save(plugin);

        // Convert the object back to pluginDto
        BeanUtils.copyProperties(plugin, pluginDto);

        return pluginDto;

       */


//        return pluginDto;
    }
}
