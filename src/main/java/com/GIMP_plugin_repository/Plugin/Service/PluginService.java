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

    // Get all versions associated with a specific plugin
    public List<PluginVersionDto> getPluginVersionsByPluginId(Long pluginId){
        List<PluginVersion> versions = pluginVersionRepository.findByPluginId(pluginId);
        return versions.stream().map(version -> modelMapper.map(version, PluginVersionDto.class))
                .collect(Collectors.toList());
    }

    public ReviewDto createReview(Long pluginId, String versionNumber, ReviewDto reviewDto) {
        Plugin plugin = pluginRepository.findById(pluginId).orElseThrow(() -> new RuntimeException("Plugin not found"));
        // Retrieve plugin version by pluginId and version number
        PluginVersion pluginVersion = pluginVersionRepository.findByPluginAndVersionNumber(plugin, versionNumber);

        // Create a new Review entity and set values form ReviewDto
        Review review = modelMapper.map(reviewDto, Review.class);

        review.setPluginVersion(pluginVersion);
        review.setRating(reviewDto.getRating());
        review.setComment(reviewDto.getComment());
        review.setReviewDate(reviewDto.getReviewDate());

        // Save the review to the database
        Review savedReview = reviewRepository.save(review);

        //Return the saved Review as ReviewDTO, including pluginId
        return modelMapper.map(savedReview, ReviewDto.class);
    }

    public List<ReviewDto> getReviewsByPluginAndVersion(Long pluginId, String versionNumber) {
        Plugin plugin = pluginRepository.findById(pluginId)
                .orElseThrow(() -> new RuntimeException("Plugin not found"));
        PluginVersion pluginVersion = pluginVersionRepository.findByPluginAndVersionNumber(plugin, versionNumber);
          //     .orElseThrow(() -> new RuntimeException("Plugin with ID  not found"));

        List<Review> reviews = reviewRepository.findByPluginVersion(pluginVersion);
        return reviews.stream().map(review -> modelMapper.map(review, ReviewDto.class))
                .collect(Collectors.toList());
    }

    //    @GetMapping("/{id}/{versionId}")
//    public PluginDto getPluginByVersionId(Long versionId) {
//        PluginVersion version = pluginVersionRepository.findById(versionId)
//                .orElseThrow(() -> new RuntimeException("Plugin with ID " + versionId + " not found"));
//
//        return modelMapper.map(version.getPlugin(), PluginDto.class);
//
//    }


    public PluginDto updatePlugin(Long id, PluginDto pluginDto) {
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

    public PluginVersion getPluginVersionByPluginAndVersion(Long pluginId, String versionNumber) {
        Plugin plugin = pluginRepository.findById(pluginId)
                .orElseThrow(() -> new RuntimeException("plugin not found"));
        return pluginVersionRepository.findByPluginAndVersionNumber(plugin, versionNumber);

    }
}
