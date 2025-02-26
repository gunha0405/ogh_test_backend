package com.example.ogh_test_backend.comment.model.dto;

import com.example.ogh_test_backend.comment.model.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Schema(description = "댓글 응답 객체")
@Getter
@Builder
public class CommentReadRes {

    @Schema(description = "댓글 내용", example = "이 글 정말 유익하네요!")
    private String content;

    @Schema(description = "댓글 작성자", example = "작성자01")
    private String writer;

    public static CommentReadRes fromEntity(Comment comment) {
        return CommentReadRes.builder()
                .content(comment.getContent())
                .writer(comment.getWriter())
                .build();
    }
}
