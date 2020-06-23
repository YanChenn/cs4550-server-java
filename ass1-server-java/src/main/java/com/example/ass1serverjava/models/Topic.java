package com.example.ass1serverjava.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "topics")
public class Topic {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String title;
  private String lessonId;
  private String description;

  @OneToMany(mappedBy = "topic")
  private List<Widget> widgets;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLessonId() {
    return lessonId;
  }

  public void setLessonId(String lessonId) {
    this.lessonId = lessonId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Widget> getWidgets() {
    return widgets;
  }

  public void setWidgets(List<Widget> widgets) {
    this.widgets = widgets;
  }

  public Topic() {
  }

  public Topic(String title, String lessonId, String description, List<Widget> widgets) {
    this.title = title;
    this.lessonId = lessonId;
    this.description = description;
    this.widgets = widgets;
  }
}