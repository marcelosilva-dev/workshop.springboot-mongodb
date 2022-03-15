package com.pbidevs.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbidevs.workshopmongo.domain.Post;
import com.pbidevs.workshopmongo.domain.User;
import com.pbidevs.workshopmongo.dto.UserDTO;
import com.pbidevs.workshopmongo.repositories.PostRepository;
import com.pbidevs.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll() {
		return postRepository.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> user = postRepository.findById(id);
		
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Post insert(Post obj) {
		return postRepository.insert(obj);
	}
	
	public Post update(Post obj) {
		Post newObj = findById(obj.getId());
		updateData(newObj, obj);
		return postRepository.save(newObj);
	}
	
	private void updateData(Post newObj, Post obj) {
		newObj.setAuthor(obj.getAuthor());
		newObj.setBody(obj.getBody());
		newObj.setDate(obj.getDate());
		newObj.setId(obj.getId());
		newObj.setTitle(obj.getTitle());
	}

	public void delete(String id) {
		findById(id);
		postRepository.deleteById(id);;
	}
}
