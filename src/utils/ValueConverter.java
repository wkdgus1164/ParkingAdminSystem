package utils;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ValueConverter {
   private final PropertyChangeSupport support = new PropertyChangeSupport(this);
   private static int value;
   private static int parkedTime;
   private static String nowTime;
   private int oldValue;
   
   public void addPropertyChangeListener(PropertyChangeListener listener) {
      support.addPropertyChangeListener(listener);
   }
   
   public void removePropertyChangeListener(PropertyChangeListener listener) {
      support.removePropertyChangeListener(listener);
   }
   
   public int getValue() {
      return value;
   }
   
   public void setValue(int newValue) {
       value = newValue;
   }
   
   public int getParkedTime() {
       return parkedTime;
   }
   
   public void setParkedTime(int newValue) {
       parkedTime = newValue;
   }
   
   public String getNowTime() {
       return nowTime;
   }
   
   public void setNowTime(String newValue) {
       nowTime = newValue;
   }
}