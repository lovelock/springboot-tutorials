package fun.happyhacker.springbootdemo.http;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Data
public class Category {
    private int credibility;
    private Map<String, Integer> features = new HashMap<>();
}
