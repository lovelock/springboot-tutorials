package fun.happyhacker.springbootdemo.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SlideShowBody {
    @JsonProperty("slideshow")
    private SlideShow slideShow;
}
