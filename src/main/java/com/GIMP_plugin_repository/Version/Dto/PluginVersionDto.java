package com.GIMP_plugin_repository.Version.Dto;

import com.GIMP_plugin_repository.Plugin.Model.Plugin;
import com.GIMP_plugin_repository.User.Model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.Date;
import java.util.List;

public class PluginVersionDto {
    private Long id;
    private Plugin plugin;
    private String versionNumber;
    private Date uploadDate;
    private List<User> users;

    public PluginVersionDto(Long id, Plugin plugin, String versionNumber, Date uploadDate, List<User> users) {
        this.id = id;
        this.plugin = plugin;
        this.versionNumber = versionNumber;
        this.uploadDate = uploadDate;
        this.users = users;
    }

    public PluginVersionDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public void setPlugin(Plugin plugin) {
        this.plugin = plugin;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "PluginVersionDto{" +
                "id=" + id +
                ", plugin=" + plugin +
                ", versionNumber='" + versionNumber + '\'' +
                ", uploadDate=" + uploadDate +
                ", users=" + users +
                '}';
    }
}
