package br.com.technique.process.render.graph;

import java.awt.image.RenderedImage;

import java.io.File;

import java.io.FileInputStream;

import javax.imageio.ImageIO;

import oracle.security.idm.testframework.Test;

public class GraphicTest {
    public GraphicTest() {
        super();
    }
  public static void main(String[] args) throws Exception {    
    
    
     FileInputStream Test = new FileInputStream("C:/GISRenewalsProcess.jpdl.xml");
     JpdlModel jpdlModel = new JpdlModel (new FileInputStream("C:/GISRenewalsProcess.jpdl.xml"));    
     ImageIO.write(new JpdlModelDrawer().draw(jpdlModel), "png", new File("C:/TestIIII.png")); 

     
  } 
}
