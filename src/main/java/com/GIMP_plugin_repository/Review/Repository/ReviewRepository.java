package com.GIMP_plugin_repository.Review.Repository;

import com.GIMP_plugin_repository.Review.Model.Review;
import com.GIMP_plugin_repository.Version.Model.PluginVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    //    List<Review> findByPluginIdAndVersionId( Long pluginId, Long pluginVersionId);
    List<Review> findByPluginVersion(PluginVersion pluginVersion);

}
