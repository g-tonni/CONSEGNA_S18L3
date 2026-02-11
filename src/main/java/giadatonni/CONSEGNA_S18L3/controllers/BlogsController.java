package giadatonni.CONSEGNA_S18L3.controllers;

import giadatonni.CONSEGNA_S18L3.entities.Blog;
import giadatonni.CONSEGNA_S18L3.payload.BlogPayload;
import giadatonni.CONSEGNA_S18L3.services.BlogsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogsController {
    private final BlogsService blogsService;

    public BlogsController(BlogsService blogsService) {
        this.blogsService = blogsService;
    }

    @GetMapping
    public List<Blog> findAll(){
        return blogsService.getListaBlog();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blog addBlog(@RequestBody BlogPayload body){
        return blogsService.postaBlog(body);
    }

    @GetMapping("/{blogId}")
    public Blog findById(@PathVariable long blogId){
        return blogsService.trovaBlog(blogId);
    }

    @PutMapping("/{blogId}")
    public Blog putBlog(@PathVariable long blogId, @RequestBody BlogPayload body){
        return blogsService.modificaBlog(blogId, body);
    }

    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlog(@PathVariable long blogId){
        blogsService.eliminaBlog(blogId);
    }
}
