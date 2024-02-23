package kz.baltabayev.reviewerservice.client;

import kz.baltabayev.reviewerservice.model.dto.Submission;
import kz.baltabayev.reviewerservice.model.dto.SubmissionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "dev-service")
public interface SubmissionServiceClient {

    @PostMapping("/submit")
    Submission sumbit(@RequestBody SubmissionDto submissionDto);
}
