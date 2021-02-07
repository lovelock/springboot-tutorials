package fun.happyhacker.springbootdemo.http.feign;

import feign.Feign;
import feign.gson.GsonDecoder;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class FeignTest {
    public static void main(String[] args) {
        GitHub gitHub = Feign.builder().decoder(new GsonDecoder())
                .target(GitHub.class, "https://api.github.com");

        List<GitHubService.Contributor> contributors = gitHub.contributors("OpenFeign", "feign");
        for (GitHubService.Contributor contributor : contributors) {
            log.info(contributor.login + "(" + contributor.contributions + ")");
        }
    }
}
