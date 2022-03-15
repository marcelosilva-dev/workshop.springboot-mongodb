package com.pbidevs.workshopmongo.resourses;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pbidevs.workshopmongo.domain.Post;
import com.pbidevs.workshopmongo.domain.User;
import com.pbidevs.workshopmongo.dto.UserDTO;
import com.pbidevs.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResourse {
	
	@Autowired
	private PostService postService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		
	 Post post = postService.findById(id);
		
		return ResponseEntity.ok().body(post);
	}
	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteBiId(@PathVariable String id) {
		
		postService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
