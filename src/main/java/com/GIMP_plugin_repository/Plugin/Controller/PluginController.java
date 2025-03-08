package com.GIMP_plugin_repository.Plugin.Controller;

import com.GIMP_plugin_repository.Plugin.Dto.PluginDto;
import com.GIMP_plugin_repository.Plugin.Repository.PluginRepository;
import com.GIMP_plugin_repository.Plugin.Service.PluginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plugin")
public class PluginController {


    @Autowired
    private PluginService pluginService;

    @PostMapping("/createPlugin")
    public ResponseEntity<PluginDto> addPlugin(@RequestBody PluginDto pluginDto){
        PluginDto createPlugin =  pluginService.createPlugin(pluginDto);
//        pluginDto =  pluginService.createPlugin(pluginDto);

        return ResponseEntity.ok(createPlugin);
    }


}
