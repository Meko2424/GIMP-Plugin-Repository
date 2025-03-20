package com.GIMP_plugin_repository.Plugin.Controller;

import com.GIMP_plugin_repository.Plugin.Dto.PluginDto;
import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.Plugin.Service.PluginService;
import com.GIMP_plugin_repository.Review.Dto.ReviewDto;
import com.GIMP_plugin_repository.Version.Dto.PluginVersionDto;
import com.GIMP_plugin_repository.Version.Model.PluginVersion;
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

    // Get a plugin by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getPluginById(@PathVariable Long id){
        Optional<PluginDto> pluginDto = pluginService.getPluginById(id);
        return  ResponseEntity.ok(pluginDto);
    }

    // Get all versions by pluginId
    @GetMapping("/{pluginId}/versions")
    public ResponseEntity<List<PluginVersionDto>> getPluginVersionsByPluginId(@PathVariable Long pluginId){
        List<PluginVersionDto> versionDto = pluginService.getPluginVersionsByPluginId(pluginId);
        return ResponseEntity.ok(versionDto);
    }

    // Create version for a plugin
    @PostMapping("/{pluginId}/versions")
    public ResponseEntity<PluginVersionDto> createPluginVersion(@PathVariable Long pluginId, @RequestBody PluginVersionDto pluginVersionDto){
        PluginVersionDto versionDto = pluginService.createPluginVersion(pluginId, pluginVersionDto);
        return ResponseEntity.ok(versionDto);
    }

    @PostMapping("/{pluginId}/versions/{versionNumber}/reviews")
    public ResponseEntity<ReviewDto> createReview(@PathVariable Long pluginId,
                                                  @PathVariable String versionNumber,
                                                  @RequestBody ReviewDto reviewDto){

        ReviewDto createdReview = pluginService.createReview(pluginId, versionNumber, reviewDto);
        return ResponseEntity.ok(createdReview);
    }

    @GetMapping("/{pluginId}/versions/{versionNumber}/reviews")
    public ResponseEntity<List<ReviewDto>> getReviewsByPluginAndVersion(@PathVariable Long pluginId, @PathVariable String versionNumber){
        List<ReviewDto> reviews = pluginService.getReviewsByPluginAndVersion(pluginId, versionNumber);
        return ResponseEntity.ok(reviews);
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
