package com.jcrud.Controllers;

import com.jcrud.Entities.Post;
import com.jcrud.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class PostController {

    @Autowired
    PostService postService;
    // Read
//    @RequestMapping("/")
//    public String getPost(Model model) {
//        List<Post> listPosts = postService.getAll();
//        model.addAttribute("listPosts", listPosts);
//        model.addAttribute("post", new Post());
//        return "index";
//    }

    // Using ModelAndView
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView getPost() {
        List<Post> listPosts = postService.getAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listPosts", listPosts);
        mav.addObject("post", new Post());
        return mav;
    }

    // Create
    // Using Model instead of MAV
//    @RequestMapping(value="/", method = RequestMethod.POST)
//    public String savePost(@ModelAttribute("post") Post post) {
//        postService.save(post);
//        return "redirect:/";
//    }

    // Using ModelAndView
    @RequestMapping(value="/", method=RequestMethod.POST)
    public ModelAndView savePost(@ModelAttribute("post") Post post) {
        postService.save(post);
        return new ModelAndView("redirect:/");
    }

    // Update
    // Using ModelAndView
    @RequestMapping("/update_post/{id}")
    public ModelAndView getPost(@PathVariable(name="id") int id) {
        ModelAndView mav = new ModelAndView("update_post");
        Post post = postService.get(id);
        mav.addObject("post", post);
        return mav;
    }

//    //Delete
//    @RequestMapping(value="/deletePost/{id}")
//    public String deletePost(@PathVariable Long id, Model model) {
//        postService.deletePost(id);
//        return "redirect:/";
//    }

    // Using ModelAndView
    @RequestMapping(value="/deletePost/{id}")
    public ModelAndView deletePost(@PathVariable(name="id") int id) {
        postService.deletePost(id);
        return new ModelAndView("redirect:/");
    }
}
