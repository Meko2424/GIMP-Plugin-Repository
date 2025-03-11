//package com.GIMP_plugin_repository.Tag.Dto;
//
//import com.GIMP_plugin_repository.Plugin.Model.Plugin;
//import jakarta.persistence.ManyToMany;
//
//public class TagDto {
//
//    private Long id;
//    private String name;
//    private Plugin plugins;
//
//    public TagDto(Long id, String name, Plugin plugins) {
//        this.id = id;
//        this.name = name;
//        this.plugins = plugins;
//    }
//
//    public TagDto() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Plugin getPlugins() {
//        return plugins;
//    }
//
//    public void setPlugins(Plugin plugins) {
//        this.plugins = plugins;
//    }
//
//    @Override
//    public String toString() {
//        return "TagDto{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", plugins=" + plugins +
//                '}';
//    }
//}
