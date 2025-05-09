package com.GIMP_plugin_repository.BackEnd.Version.Controller;


import com.GIMP_plugin_repository.BackEnd.Version.Dto.PluginVersionDto;
import com.GIMP_plugin_repository.BackEnd.Version.Service.PluginVersionService;
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
    @GetMapping("/plugin/{pluginId}")
    public ResponseEntity<List<PluginVersionDto>> getPluginVersionsByPluginId(@PathVariable Long pluginId) {
        List<PluginVersionDto> versions = pluginVersionService.getPluginVersionsByPluginId(pluginId);
        return ResponseEntity.ok(versions);
    }

    // Create version for a plugin
    @PostMapping("/{pluginId}")
    public ResponseEntity<PluginVersionDto> createPluginVersion(@PathVariable Long pluginId, @RequestBody PluginVersionDto pluginVersionDto) {
        PluginVersionDto savedVersion = pluginVersionService.createPluginVersion(pluginId, pluginVersionDto);
        return ResponseEntity.ok(savedVersion);
    }
}
