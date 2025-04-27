package com.GIMP_plugin_repository.BackEnd.Version.Repository;

import com.GIMP_plugin_repository.BackEnd.Version.Model.PluginVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PluginVersionRepository extends JpaRepository<PluginVersion, Long> {

    List<PluginVersion> findByPluginId(Long pluginId);
}
