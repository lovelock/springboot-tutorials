package fun.happyhacker.springbootdemo.http.feign;

import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface GitHub {
    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<GitHubService.Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);
}
