//package com.GIMP_plugin_repository.BackEnd.Author.Controller;
//
//import com.GIMP_plugin_repository.BackEnd.Author.Dto.AuthorDto;
//import com.GIMP_plugin_repository.BackEnd.Author.Service.AuthorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/authors")
//@CrossOrigin(origins = "http://localhost:3000")
//public class AuthorController {
//    @Autowired
//    private final AuthorService authorService;
//
//    public AuthorController(AuthorService authorService) {
//        this.authorService = authorService;
//    }
//
//    @PostMapping
//    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
//        AuthorDto savedAuthor = authorService.createAuthor(authorDto);
//        return ResponseEntity.ok(savedAuthor);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Long id){
//        AuthorDto authorDto = authorService.getAuthorById(id);
//        return ResponseEntity.ok(authorDto);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<AuthorDto>> getAllAuthors(){
//        List<AuthorDto> authorDtoList = authorService.getAllAuthor();
//        return ResponseEntity.ok(authorDtoList);
//    }
//}
//
