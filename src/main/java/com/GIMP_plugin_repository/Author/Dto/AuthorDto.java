package com.GIMP_plugin_repository.Author.Dto;

public class AuthorDto {

    private Long id;
    private String name;

    public AuthorDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AuthorDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
