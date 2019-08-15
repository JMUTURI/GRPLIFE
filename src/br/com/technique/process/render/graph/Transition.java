/**
 * Technique TI Ltda - Project: PlanetaContabilWeb - www.planetacontabil.com.br
 * @author yeyong - http://jbpm.group.javaeye.com/group/blog/470760?page=2
 * @author Ricardo Alberto Harari - ricardo.harari@gmail.com
 * @date 25/01/2010 12:14:48
 * br.com.technique.process.render.graph
 *
 * TODO
 */

package br.com.technique.process.render.graph;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Transition {  
  private Point labelPosition;  
  private List<Point> lineTrace = new ArrayList<Point>();  
  private String label;  
  private String to;  
  
  public Transition(String label, String to) {  
    this.label = label;  
    this.to = to;  
  }  

  public Point getLabelPosition() {  
    return labelPosition;  
  }  

  public void setLabelPosition(Point labelPosition) {  
    this.labelPosition = labelPosition;  
  }  

  public List<Point> getLineTrace() {  
    return lineTrace;  
  }  

  public void setLineTrace(List<Point> lineTrace) {  
    this.lineTrace = lineTrace;  
  }  

  public void addLineTrace(Point lineTrace) {  
    if (lineTrace != null) {  
      this.lineTrace.add(lineTrace);  
    }  
  }  
  
  public String getLabel() {  
    return label;  
  }  
  public void setLabel(String label) {  
    this.label = label;  
  }  
  
  public String getTo() {  
    return to;  
  }  
  
  public void setTo(String to) {  
    this.to = to;  
  }  
  
}  