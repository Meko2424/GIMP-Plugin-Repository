package com.GIMP_plugin_repository.BackEnd.Author.Service;

import com.GIMP_plugin_repository.BackEnd.Author.Dto.AuthorDto;
import com.GIMP_plugin_repository.BackEnd.Author.Model.Author;
import com.GIMP_plugin_repository.BackEnd.Author.Repository.AuthorRepository;
import com.GIMP_plugin_repository.BackEnd.Category.Dto.CategoryDto;
import com.GIMP_plugin_repository.BackEnd.Category.Model.Category;
import com.GIMP_plugin_repository.BackEnd.Category.Repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ModelMapper modelMapper;

    public AuthorDto createAuthor(AuthorDto authorDto){
        Author author = modelMapper.map(authorDto, Author.class);
        author.setName(authorDto.getName());

        // Save the author to the database
        Author savedAuthor = authorRepository.save(author);

        //Return the saved author as authorDTO
        return modelMapper.map(savedAuthor, AuthorDto.class);

    }
}
