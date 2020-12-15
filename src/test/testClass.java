package test;

import java.beans.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class testClass {
    public static void main(String [] args) {
      new testClass();
   }
   public testClass() {
      JFrame frame = new JFrame("First Frame");
      final JLabel label = new JLabel("Observing...");
      label.setFont(new Font("Dialog", Font.PLAIN, 18));
      frame.add(label);
      frame.getRootPane().setBorder(new EmptyBorder(10, 10, 10, 10));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(250, 150);
      frame.setLocation(200, 200);
      frame.setVisible(true);

      MessageBean bean = new MessageBean();
      bean.addPropertyChangeListener(e ->     // lambda expression
         label.setText((String) e.getNewValue())
      );
      new Frame1(bean);
   }
   private class Frame1 {
   private int clicks;
      Frame1(MessageBean bean) {
         JFrame frame = new JFrame("Second Frame");
         JLabel label = new JLabel("Click anywhere to fire a property change event");
         label.setFont(new Font("Dialog", Font.PLAIN, 18));
         frame.add(label);
         frame.getRootPane().setBorder(new EmptyBorder(10, 10, 10, 10));
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(450, 150);
         frame.setLocation(600, 200);
         frame.setVisible(true);
         frame.addMouseListener(new MouseAdapter() {
         @Override
            public void mouseClicked(MouseEvent e) {
               String data = "Click-count [" + ++clicks + "]";
               bean.setValue(data);
            }
         });
      }
   }
}

class MessageBean {
   private final PropertyChangeSupport support = new PropertyChangeSupport(this);
   private String value;
   public void addPropertyChangeListener(PropertyChangeListener listener) {
      support.addPropertyChangeListener(listener);
   }
   public void removePropertyChangeListener(PropertyChangeListener listener) {
      support.removePropertyChangeListener(listener);
   }
   public String getValue() {
      return value;
   }
   public void setValue(String newValue) {
      String oldValue = value;
      value = newValue;
      support.firePropertyChange("value", oldValue, newValue);
   }
}