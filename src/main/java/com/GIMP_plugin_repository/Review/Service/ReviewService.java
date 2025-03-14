package com.GIMP_plugin_repository.Review.Service;

import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.Plugin.Repository.PluginRepository;
import com.GIMP_plugin_repository.Review.Dto.ReviewDto;
import com.GIMP_plugin_repository.Review.Model.Review;
import com.GIMP_plugin_repository.Review.Repository.ReviewRepository;
import com.GIMP_plugin_repository.User.Model.User;
import com.GIMP_plugin_repository.User.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private PluginRepository pluginRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ReviewDto createReview(ReviewDto reviewDto){
        Review review = modelMapper.map(reviewDto, Review.class);
        User user = userRepository.findById(reviewDto.getPluginId())
                .orElseThrow(() -> new RuntimeException("User not found"));
//                .orElseGet(() -> {
//                    User newUser = new User();
//                    newUser.setId(reviewDto.getId());
//                    return userRepository.save(newUser);
//                });
        Plugin plugin = pluginRepository.findById(reviewDto.getPluginId())
                .orElseThrow(() -> new RuntimeException("Plugin not found"));

        review.setUser(user);
        review.setPlugin(plugin);
        review.setReviewDate(LocalDateTime.now());

        Review savedReview = reviewRepository.save(review);
        return modelMapper.map(savedReview, ReviewDto.class);
    }
}
