package com.tms.demorest.mapper;

import com.tms.demorest.dto.BookDto;
import com.tms.demorest.entity.Book;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "description", source = "bookDto.desc")
    Book toEntity(BookDto bookDto);

    @Mapping(target = "desc", source = "book.description")
    BookDto toDto(Book book);

    @Mapping(target = "desc", source = "book.description")
    List<BookDto> toDto(List<Book> book);
}
