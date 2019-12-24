package cn.chachae.se.rmao.t4;

public class Animal {
  public String name;
  public String color;

  public Animal() {
    this.name = "Joe";
    this.color = "green";
  }

  public Animal(String name, String color) {
    this.name = name;
    this.color = color;
  }

  public void print() {
    System.out.printf("名字：%s，颜色：%s %n", name, color);
  }
}
