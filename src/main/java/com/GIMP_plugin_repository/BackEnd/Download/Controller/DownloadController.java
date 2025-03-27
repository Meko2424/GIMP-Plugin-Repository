package com.GIMP_plugin_repository.BackEnd.Download.Controller;

import com.GIMP_plugin_repository.BackEnd.Download.Dto.DownloadPluginDto;
import com.GIMP_plugin_repository.BackEnd.Download.Service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/download")

public class DownloadController {
    @Autowired
    private DownloadService downloadService;

    @PostMapping("/createDownload")
    public ResponseEntity<DownloadPluginDto> createDownloadPlugin(@RequestBody DownloadPluginDto downloadPluginDto){
        DownloadPluginDto createdPluginDownload = downloadService.createPluginDownload(downloadPluginDto);
        return ResponseEntity.ok(createdPluginDownload);
    }

    public ResponseEntity<DownloadPluginDto> getDownloadById(@PathVariable Long id){
        DownloadPluginDto download = downloadService.getDownloadById(id);
        return ResponseEntity.ok(download);
    }
}
