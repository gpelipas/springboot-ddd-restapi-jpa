package com.gpelipas.bookmarkwebapi.infrastructure.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gpelipas.bookmarkwebapi.application.domain.model.Bookmark;
import com.gpelipas.bookmarkwebapi.application.domain.model.BookmarkFilter;
import com.gpelipas.bookmarkwebapi.application.domain.port.BookmarkApi;
import com.gpelipas.bookmarkwebapi.infrastructure.web.model.BookmarkWebDto;
import com.gpelipas.bookmarkwebapi.infrastructure.web.model.BookmarkWebDtoMapper;


@RestController
@RequestMapping("/api/bookmarks")
public class BookmarkRestController {
   
    @Autowired
    private BookmarkApi bookmarkService;

    @Autowired
    private BookmarkWebDtoMapper bookmarkWebDtoMapper;


    @GetMapping()
    public List<BookmarkWebDto> bookmarks(@RequestParam(required = false) String name) {
        var filter = new BookmarkFilter(name, true);

        var domainList = bookmarkService.findBookmarks(filter);

        return bookmarkWebDtoMapper.toDtoList(domainList);
    }

    @GetMapping("/{id}")
    public BookmarkWebDto bookmarkById(@PathVariable String id) {
        Bookmark domain = bookmarkService.findBookmark(id);

        return bookmarkWebDtoMapper.toDto(domain);
    }


}
