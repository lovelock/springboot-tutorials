package fun.happyhacker.springbootdemo.http;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Slide {
    private List<String> items = new ArrayList<>();
    private String title;
    private String type;
}
