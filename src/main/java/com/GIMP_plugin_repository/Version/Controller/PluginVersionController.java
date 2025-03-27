package com.GIMP_plugin_repository.Version.Controller;


import com.GIMP_plugin_repository.Version.Dto.PluginVersionDto;
import com.GIMP_plugin_repository.Version.Service.PluginVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pluginVersions")
public class PluginVersionController {

    @Autowired
    private PluginVersionService pluginVersionService;

    // // Get all versions associated with a specific plugin
    @GetMapping("/{pluginId}/versions")
    public ResponseEntity<List<PluginVersionDto>> getPluginVersionsByPluginId(@PathVariable Long pluginId) {
        List<PluginVersionDto> versionDto = pluginVersionService.getPluginVersionsByPluginId(pluginId);
        return ResponseEntity.ok(versionDto);
    }

    // Create version for a plugin
    @PostMapping("/{pluginId}/versions")
    public ResponseEntity<PluginVersionDto> createPluginVersion(@PathVariable Long pluginId, @RequestBody PluginVersionDto pluginVersionDto) {
        PluginVersionDto versionDto = pluginVersionService.createPluginVersion(pluginId, pluginVersionDto);
        return ResponseEntity.ok(versionDto);
    }
}
