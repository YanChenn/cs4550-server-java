package com.example.ass1serverjava.services;

import com.example.ass1serverjava.models.Topic;
import com.example.ass1serverjava.models.Widget;
import com.example.ass1serverjava.repositories.TopicRepository;
import com.example.ass1serverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WidgetService {

  @Autowired
  TopicRepository topicRepository;

  @Autowired
  WidgetRepository repository;

  List<Widget> widgets = new ArrayList<Widget>();
  {
    widgets.add(new Widget(123, "Widget 1", "HEADING"));
    widgets.add(new Widget(234, "Widget 2", "PARAGRAPH"));
    widgets.add(new Widget(345, "Widget 3", "YOUTUBE"));
    widgets.add(new Widget(432, "Widget 4", "IMAGE"));
    widgets.add(new Widget(567, "Widget 5", "PARAGRAPH"));
  }
  public List<Widget> findWidgetsForTopic(Integer tid) {
    return repository.findWidgetsForTopic(tid);

  }
  public Widget findWidgetById(Integer wid) {
    for (Widget w: widgets) {
      if(w.getId().equals(wid)) {
        return w;
      }
    }
    return null;
  }

  public List<Widget> findAllWidgets() {
    return widgets;
  }

  public int deleteWidget(Integer wid) {
    repository.deleteById(wid);
    if(repository.findWidgetById(wid) != null) {
      return 0;
    }
    return 1;
  }

  public Widget createWidget(Integer tid, Widget newWidget) {
    Topic topic = topicRepository.findTopicById(tid);
    newWidget.setTopic(topic);
    return repository.save(newWidget);
//        newWidget.setId(widgets.size() * 20);
//        this.widgets.add(newWidget);
//        return newWidget;
  }

  public int updateWidget(Integer widgetId, Widget updatedWidget) {
    try {
      Widget widget = repository.findWidgetById(widgetId);

      widget.setType(updatedWidget.getType());
      widget.setName(updatedWidget.getName());
      widget.setText(updatedWidget.getText());
      widget.setUrl(updatedWidget.getUrl());
      widget.setValue(updatedWidget.getValue());
      widget.setWidgetOrder(updatedWidget.getWidgetOrder());
      repository.save(widget);
    } catch (Exception e) {
      return 0;
    }
    return 1;
  }
}