package ru.stqa.pft.sandbox;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] arg){
    String[] langs = {"Java", "C#", "Python", "PHP"};

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

    for (String l : languages){
      System.out.println("I want to learn "+ l);
    }
  }
}
