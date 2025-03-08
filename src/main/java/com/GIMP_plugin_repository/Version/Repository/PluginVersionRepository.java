package com.GIMP_plugin_repository.Version.Repository;

import com.GIMP_plugin_repository.Author.Model.Author;
import com.GIMP_plugin_repository.Version.Model.PluginVersion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PluginVersionRepository extends JpaRepository<PluginVersion, Long> {
}
