package com.example.ogh_test_backend.board.model.dto;

import com.example.ogh_test_backend.board.model.Board;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "게시글 목록 조회 응답 객체")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardListRes {

    @Schema(description = "게시글의 고유 아이디", example = "1")
    private Long idx;

    @Schema(description = "게시글 제목", example = "Spring Boot와 JPA 활용법")
    private String title;

    @Schema(description = "게시글 작성자", example = "홍길동")
    private String writer;

    @Schema(description = "게시글에 달린 댓글 수", example = "5")
    private int commentCount;

    public static BoardListRes fromEntity(Board board) {
        return BoardListRes.builder()
                .idx(board.getIdx())
                .title(board.getTitle())
                .writer(board.getWriter())
                .commentCount(board.getComments().size()) // 댓글 수 계산
                .build();
    }
}
