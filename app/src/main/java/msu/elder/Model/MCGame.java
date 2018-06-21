package msu.elder.Model;

import java.io.Serializable;

public class MCGame implements Serializable{
    String image;
    String a;
    String b;
    String c;
    String d;
    String CorrectAnswer;

    public MCGame() {
    }

    public MCGame(String image, String a, String b, String c, String d, String correctAnswer) {
        this.image = image;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        CorrectAnswer = correctAnswer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        CorrectAnswer = correctAnswer;
    }

}