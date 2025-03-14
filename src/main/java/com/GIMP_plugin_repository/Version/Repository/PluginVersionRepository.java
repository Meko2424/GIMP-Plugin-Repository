package com.GIMP_plugin_repository.Version.Repository;

import com.GIMP_plugin_repository.Author.Model.Author;
import com.GIMP_plugin_repository.Version.Model.PluginVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PluginVersionRepository extends JpaRepository<PluginVersion, Long> {
    PluginVersion findByPluginIdAndId(Long pluginId, Long versionId);

}
