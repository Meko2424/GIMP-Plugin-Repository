package com.GIMP_plugin_repository.Plugin.Controller;

import com.GIMP_plugin_repository.Plugin.Dto.PluginDto;
import com.GIMP_plugin_repository.Plugin.Service.PluginService;
import com.GIMP_plugin_repository.Version.Dto.PluginVersionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plugin")
public class PluginController {

    @Autowired
    private  PluginService pluginService;

    @PostMapping("/createPlugin")
    public ResponseEntity<PluginDto> createPlugin(@RequestBody PluginDto pluginDto){
        PluginDto createdPlugin = pluginService.createPlugin(pluginDto);
        return ResponseEntity.ok(createdPlugin);
    }

    // Get all plugins
    @GetMapping
    public ResponseEntity<List<PluginDto>> getAllPlugins(){
      List<PluginDto> plugins = pluginService.getAllPlugins();
      return  ResponseEntity.ok(plugins);
    }

    // Get a plugin by Id
    @GetMapping("/{id}")
    public ResponseEntity<?> getPluginById(@PathVariable Long id){
        Optional<PluginDto> pluginDto = pluginService.getPluginById(id);
        return  ResponseEntity.ok(pluginDto);
    }

    // Get a plugin by id and version id
    @GetMapping("/{pluginId}/version/{versionId}")
    public ResponseEntity<PluginDto> getPluginByVersionId(@PathVariable Long versionId){
        PluginDto plugin = pluginService.getPluginByVersionId(versionId);
        return ResponseEntity.ok(plugin);
    }

    // Create version for a plugin
    @PostMapping("/{pluginId}/versions")
    public ResponseEntity<PluginVersionDto> createPluginVersion(@PathVariable Long pluginId, @RequestBody PluginVersionDto pluginVersionDto){
        PluginVersionDto versionDto = pluginService.createPluginVersion(pluginId, pluginVersionDto);
        return ResponseEntity.ok(versionDto);
    }


    @PutMapping("/updatePlugin/{id}")
    public ResponseEntity<PluginDto> updatePlugin(@PathVariable Long id, @RequestBody PluginDto pluginDto){
        PluginDto updatedPlugin = pluginService.updatePlugin(id, pluginDto);
        return ResponseEntity.ok(updatedPlugin);
    }

    @DeleteMapping("deletePlugin/{id}")
    public ResponseEntity<Void> deletePlugin(@PathVariable Long id){
        pluginService.deletePlugin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
