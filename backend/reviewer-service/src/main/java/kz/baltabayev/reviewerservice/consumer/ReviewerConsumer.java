package kz.baltabayev.reviewerservice.consumer;

import kz.baltabayev.reviewerservice.model.dto.ReviewerConsumerRequest;
import kz.baltabayev.reviewerservice.model.entity.Reviewer;
import kz.baltabayev.reviewerservice.model.entity.ReviewerInfo;
import kz.baltabayev.reviewerservice.service.ReviewerService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewerConsumer {

    private final ReviewerService reviewerService;

    @KafkaListener(topics = "${spring.kafka.queues.reviewer}", groupId = "reviewer-service")
    public void consumeStudent(ReviewerConsumerRequest request) {
        reviewerService.save(Reviewer.builder()
                .email(request.email())
                .reviewerInfo(ReviewerInfo.builder()
                        .firstname(request.name())
                        .build())
                .build());
    }
}
