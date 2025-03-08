package com.GIMP_plugin_repository.Plugin.Repository;

import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PluginRepository extends JpaRepository<Plugin, Long> {
}
