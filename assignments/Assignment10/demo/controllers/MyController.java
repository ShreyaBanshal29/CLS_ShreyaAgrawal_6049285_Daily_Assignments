package com.cg.demo.controllers;  

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.cg.demo.MovieService;
import com.cg.demo.entities.Movies;

@Controller
public class MyController {

    @Autowired
    MovieService mService;

    @RequestMapping("/greet")
    public ModelAndView processGreet() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "Welcome to Movie App");
        mv.setViewName("welcome");
        return mv;
    }

    @RequestMapping("/movies")
    public ModelAndView showMovies() throws Exception {
        List<Movies> list = mService.searchAllMovies();

        ModelAndView mv = new ModelAndView();
        mv.addObject("movies", list);
        mv.addObject("movie",new Movies());
        mv.setViewName("movie");

        return mv;
    }

    @RequestMapping("/addMovie")
    public ModelAndView addMovie(@ModelAttribute("movie") Movies m) throws Exception {
        mService.addMovie(m);

        return new ModelAndView("redirect:/movies");
    }

    @RequestMapping("/searchMovie")
    public ModelAndView searchMovie(@RequestParam String genre) throws Exception {

        List<Movies> list;

        if (genre == null || genre.isEmpty()) {
            list = mService.searchAllMovies();
        } else {
            list = mService.searchByGenre(genre);
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("movies", list);
        mv.setViewName("movie");

        return mv;
    }

    @RequestMapping("/deleteMovie")
    public ModelAndView deleteMovie(@RequestParam String name) throws Exception {

        mService.deleteMovie(name);

        return new ModelAndView("redirect:/movies");
    }
}