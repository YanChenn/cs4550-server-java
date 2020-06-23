package com.example.ass1serverjava.controllers;


import com.example.ass1serverjava.models.Topic;
import com.example.ass1serverjava.services.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {
  @Autowired
  TopicService service;

  @PostMapping("/api/lessons/{lid}/topics")
  public Topic createTopic(@PathVariable String lid, @RequestBody Topic topic) {
    return service.createTopic(lid, topic);
  }

  @DeleteMapping("/api/topics/{tid}")
  public int deleteTopic(@PathVariable int tid) {
    return service.deleteTopic(tid);
  }

  @PutMapping("/api/topics/{tid}")
  public int updateTopic(@PathVariable int tid, @RequestBody Topic topic) {
    return service.updateTopic(tid, topic);
  }

  @GetMapping("/api/topics")
  public List<Topic> findAllTopics() {
    return service.findAllTopics();
  }

  @GetMapping("/api/topics/{topicId}")
  public Topic findTopicById(
      @PathVariable("topicId") Integer tid) {
    return service.findTopicById(tid);
  }

  @GetMapping("/api/lessons/{lessonId}/topics")
  public List<Topic> findTopicsForLesson(
      @PathVariable("lessonId") String lessonId) {
    return service.findTopicsForLesson(lessonId);
  }
}