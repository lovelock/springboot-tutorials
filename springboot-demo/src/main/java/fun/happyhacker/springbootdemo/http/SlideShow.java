package fun.happyhacker.springbootdemo.http;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SlideShow {
    private String author;
    private String date;
    private List<Slide> slides = new ArrayList<>();
    private String title;
}
