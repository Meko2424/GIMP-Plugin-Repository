package com.GIMP_plugin_repository.BackEnd.Author.Controller;

import com.GIMP_plugin_repository.BackEnd.Author.Dto.AuthorDto;
import com.GIMP_plugin_repository.BackEnd.Author.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
        AuthorDto createdAuthor = authorService.createAuthor(authorDto);
        return ResponseEntity.ok(createdAuthor);
    }

}
