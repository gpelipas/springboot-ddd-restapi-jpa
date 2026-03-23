package com.gpelipas.bookmarkwebapi.adapter.in.webapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gpelipas.bookmarkwebapi.adapter.in.webapi.model.BookmarkWebDto;
import com.gpelipas.bookmarkwebapi.adapter.in.webapi.model.BookmarkWebDtoMapper;
import com.gpelipas.bookmarkwebapi.adapter.in.webapi.model.WebResponse;
import com.gpelipas.bookmarkwebapi.application.service.BookmarkService;
import com.gpelipas.bookmarkwebapi.domain.model.BookmarksSearchCriteria;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/bookmarks")
public class BookmarkRestController {

    @Autowired
    private BookmarkService bookmarkService;

    @Autowired
    private BookmarkWebDtoMapper bookmarkWebDtoMapper;

    @GetMapping()
    public WebResponse bookmarks(@RequestParam(required = false) String name) {
        if (log.isDebugEnabled()) {
            log.debug("Request received: get all bookmarks using filter {}", name);
        }

        var filter = new BookmarksSearchCriteria(name, true);

        var domainList = bookmarkService.find(filter);

        var payload = bookmarkWebDtoMapper.toDtoList(domainList);

        return response(WebResponse.STATUS.SUCCESS, "bookmark(s) found", payload);
    }

    @GetMapping("/{id}")
    public WebResponse findBookmarkById(@PathVariable String id) {
        if (log.isDebugEnabled()) {
            log.debug("Request received: get bookmark using id {}", id);
        }

        var domain = bookmarkService.find(id);

        var payload = bookmarkWebDtoMapper.toDto(domain);

        return response(WebResponse.STATUS.SUCCESS, "bookmark found", payload);
    }

    @PostMapping
    public WebResponse addBookmark(@RequestBody BookmarkWebDto request) {
        if (log.isDebugEnabled()) {
            log.debug("Request received: add new bookmark with value - {}", request);
        }

        var domain = bookmarkWebDtoMapper.toDomain(request);

        var output = bookmarkService.create(domain);

        var payload = bookmarkWebDtoMapper.toDto(output);

        return response(WebResponse.STATUS.SUCCESS, "bookmark has been added successfully", payload);
    }

    @PutMapping("/{id}")
    public WebResponse updateBookmark(@RequestBody BookmarkWebDto request) {
        if (log.isDebugEnabled()) {
            log.debug("Request received: update bookmark with value - {}", request);
        }

        var domain = bookmarkWebDtoMapper.toDomain(request);

        var output = bookmarkService.update(domain);

        var payload = bookmarkWebDtoMapper.toDto(output);

        return response(WebResponse.STATUS.SUCCESS, "bookmark has been updated successfully", payload);
    }

    @DeleteMapping("/{id}")
    public WebResponse deleteBookmark(@PathVariable String id) {
        if (log.isDebugEnabled()) {
            log.debug("Request received: delete bookmark using id {}", id);
        }

        bookmarkService.delete(id);

        final String message = String.format("Delete operation completed on bookmark - %s", id);

        return response(WebResponse.STATUS.SUCCESS, message, null);
    }

    static WebResponse response(WebResponse.STATUS status, String message, Object payload) {
        return WebResponse.builder().status(status).message(message).payload(payload).build();
    }

}
