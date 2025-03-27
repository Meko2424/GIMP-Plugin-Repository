package com.GIMP_plugin_repository.Review.Service;

import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.Plugin.Repository.PluginRepository;
import com.GIMP_plugin_repository.Review.Dto.ReviewDto;
import com.GIMP_plugin_repository.Review.Model.Review;
import com.GIMP_plugin_repository.Review.Repository.ReviewRepository;
import com.GIMP_plugin_repository.User.Repository.UserRepository;
import com.GIMP_plugin_repository.Version.Model.PluginVersion;
import com.GIMP_plugin_repository.Version.Repository.PluginVersionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private  PluginRepository pluginRepository;

    @Autowired
    private PluginVersionRepository pluginVersionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;





    public ReviewDto createReview(Long pluginId, Long pluginVersionId, ReviewDto reviewDto) {
        Plugin plugin = pluginRepository.findById(pluginId).orElseThrow(() -> new RuntimeException("Plugin not found"));
        // Retrieve plugin version by pluginId and version number
//        PluginVersion pluginVersion = pluginVersionRepository.findByPluginAndVersion(plugin, pluginVersion);
        PluginVersion pluginVersion = pluginVersionRepository.findByPluginIdAndId(pluginId, pluginVersionId);
        if (pluginVersion == null) {
            throw new RuntimeException("PluginVersion not found for given Plugin ID and Version ID");
        }
//        PluginVersion pluginVersion = pluginVersionRepository.findById(pluginVersionId).orElseThrow(() -> new RuntimeException("Version not found"));

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





    public List<ReviewDto> getReviewsByPluginAndVersion(Long pluginId, Long pluginVersionId) {
//        Plugin plugin = pluginRepository.findById(pluginId)
//                .orElseThrow(() -> new RuntimeException("Plugin not found"));
        PluginVersion pluginVersion = pluginVersionRepository.findByPluginIdAndId(pluginId, pluginVersionId);
        //      .orElseThrow(() -> new RuntimeException("Plugin with ID  not found"));

        List<Review> reviews = reviewRepository.findByPluginVersion(pluginVersion);
        return reviews.stream().map(review -> modelMapper.map(review, ReviewDto.class))
                .collect(Collectors.toList());
    }





}
