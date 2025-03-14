package com.GIMP_plugin_repository.Review.Repository;

import com.GIMP_plugin_repository.Review.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
