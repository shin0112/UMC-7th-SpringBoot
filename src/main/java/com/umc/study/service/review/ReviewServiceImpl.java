package com.umc.study.service.review;

import com.umc.study.domain.Member;
import com.umc.study.domain.Review;
import com.umc.study.domain.Store;
import com.umc.study.dto.service.review.ReviewServiceRequest;
import com.umc.study.repository.member.MemberRepository;
import com.umc.study.repository.review.ReviewRepository;
import com.umc.study.repository.store.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    public void createReview(
        final Long storeId,
        final ReviewServiceRequest.Create request
    ) {
        Member member = memberRepository.findById(request.memberId())
            .orElseThrow(() -> new RuntimeException("회원 없음"));
        Store store = storeRepository.findById(storeId)
            .orElseThrow(() -> new RuntimeException("가게 없음"));

        reviewRepository.save(Review.builder()
            .content(request.content())
            .star(request.star())
            .member(member)
            .store(store)
            .build());
    }
}
