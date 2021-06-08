package com.toanngo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.toanngo.app.models.Artist;
import com.toanngo.app.service.ArtistService;

@Controller
public class ArtistController {
	
	@Autowired
	ArtistService service;
	
	@RequestMapping(value = "/Artist/all", method = RequestMethod.GET)
	public String showArtistList(Model model) {
		List<Artist> artistList = service.GetAll();
		model.addAttribute("artistList", artistList);
		return "artist_list";
	}
	
}
