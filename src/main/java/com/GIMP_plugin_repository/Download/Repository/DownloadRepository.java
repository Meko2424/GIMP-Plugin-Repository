package com.GIMP_plugin_repository.Download.Repository;

import com.GIMP_plugin_repository.Download.Model.DownloadPlugin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DownloadRepository extends JpaRepository<DownloadPlugin, Long> {
}
