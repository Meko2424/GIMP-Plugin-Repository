package com.GIMP_plugin_repository.BackEnd.Plugin.Repository;

import com.GIMP_plugin_repository.BackEnd.Plugin.Model.Plugin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PluginRepository extends JpaRepository<Plugin, Long> {
//    Optional<Object> findByIdByIdAndVersionId(Long id, Long versionId);
    List<Plugin> findByCategoryId(Long categoryId);

}
