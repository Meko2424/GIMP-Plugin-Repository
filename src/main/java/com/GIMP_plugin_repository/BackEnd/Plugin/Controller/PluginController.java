package com.GIMP_plugin_repository.BackEnd.Plugin.Controller;

import com.GIMP_plugin_repository.BackEnd.Plugin.Dto.PluginDto;
import com.GIMP_plugin_repository.BackEnd.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.BackEnd.Plugin.Service.PluginService;
import com.GIMP_plugin_repository.BackEnd.Version.Dto.PluginVersionDto;
import com.GIMP_plugin_repository.BackEnd.Version.Service.PluginVersionService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plugins")
@CrossOrigin(origins = "http://localhost:3000")
public class PluginController {

    @Autowired
    private PluginService pluginService;
    @Autowired
    private PluginVersionService pluginVersionService;

    @PostMapping(value = "/createPlugin", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PluginDto> createPlugin(
            @RequestPart("file") MultipartFile file,
            @RequestPart("title") String title,
            @RequestPart("description") String description,
            @RequestPart("authorName") String authorName,
            @RequestPart("imageUrl") String imageUrl,
            @RequestPart("pluginVersions") String pluginVersions
    ) {
        try {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get("uploads").resolve(fileName);
            Files.createDirectories(filePath.getParent());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);


            String fileUrl = "http://localhost:8080/uploads/" + fileName;
            ObjectMapper objectMapper = new ObjectMapper();
            List<PluginVersionDto> versions = objectMapper.readValue(
                    pluginVersions, new TypeReference<List<PluginVersionDto>>() {});

            PluginDto pluginDto = new PluginDto();
            pluginDto.setTitle(title);
            pluginDto.setDescription(description);
            pluginDto.setAuthorName(authorName);
            pluginDto.setImageUrl(imageUrl);
            pluginDto.setPluginVersions(versions);
            pluginDto.setFileUrl(fileUrl);

            PluginDto createdPlugin = pluginService.createPlugin(pluginDto);
            return ResponseEntity.ok(createdPlugin);

        } catch (Exception e) {
            throw new RuntimeException("Create Plugin failed: " + e.getMessage());
        }
    }

    // Get all plugins
    @GetMapping
    public ResponseEntity<List<PluginDto>> getAllPlugins() {
        List<PluginDto> plugins = pluginService.getAllPlugins();
        return ResponseEntity.ok(plugins);
    }

    // Get a plugin by id
    @GetMapping("/{id}")
    public ResponseEntity<PluginDto> getPluginById(@PathVariable Long id) {
        PluginDto plugin = pluginService.getPluginById(id);
        return ResponseEntity.ok(plugin);
    }



    @GetMapping("/versions/{id}")
    public ResponseEntity<List<PluginVersionDto>> getVersionsByExtensionId(@PathVariable Long id){
        try {
            List<PluginVersionDto> versions = pluginVersionService.getPluginVersionsByPluginId(id);
            return ResponseEntity.ok(versions);
        } catch (Exception e) {
            throw new RuntimeException("Get versions by extension failed");
        }
    }


    @PutMapping("/updatePlugin/{id}")
    public ResponseEntity<PluginDto> updatePlugin(@PathVariable Long id, @RequestBody PluginDto pluginDto) {
        PluginDto updatedPlugin = pluginService.updatePlugin(id, pluginDto);
        return ResponseEntity.ok(updatedPlugin);
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get("uploads").resolve(fileName);
            Files.createDirectories(filePath.getParent());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            String fileUrl = "http://localhost:8080/uploads/" + fileName;
            return ResponseEntity.ok(fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed");
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<String> downloadExtension(@PathVariable Long id) {
        PluginDto plugin = pluginService.getPluginById(id);


        if (plugin.getFileUrl() == null || plugin.getFileUrl().isEmpty()) {
            return ResponseEntity.badRequest().body("No file available for download");
        }

        return ResponseEntity.ok(plugin.getFileUrl());
    }

    @DeleteMapping("deletePlugin/{id}")
    public ResponseEntity<Void> deletePlugin(@PathVariable Long id) {
        pluginService.deletePlugin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
