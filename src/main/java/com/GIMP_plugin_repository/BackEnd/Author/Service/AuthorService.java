package com.GIMP_plugin_repository.BackEnd.Author.Service;

import com.GIMP_plugin_repository.BackEnd.Author.Dto.AuthorDto;
import com.GIMP_plugin_repository.BackEnd.Author.Model.Author;
import com.GIMP_plugin_repository.BackEnd.Author.Repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ModelMapper modelMapper;

   // @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = modelMapper.map(authorDto, Author.class);
        Author savedAuthor = authorRepository.save(author);
        return modelMapper.map(savedAuthor, AuthorDto.class);

    }

    //@Override
    public AuthorDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException((" not found")));
        return modelMapper.map(author, AuthorDto.class);
    }

    //@Override
    public List<AuthorDto> getAllAuthor() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(author -> modelMapper.map(author, AuthorDto.class)).collect(Collectors.toList());
    }

    //@Override
    public AuthorDto updateAuthor(Long id, AuthorDto updatedAuthorDto) {
        return null;
    }

    //@Override
    public void deleteAuthor(Long id) {

    }
}
