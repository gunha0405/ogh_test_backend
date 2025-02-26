package com.example.ogh_test_backend.board.model.dto;

import com.example.ogh_test_backend.board.model.Board;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

public class BoardReadDto {
    @Schema(description = "게시글 읽기 요청시 필요한 정보를 주는 객체")
    @Getter
    @Builder
    public static class BoardReadRes{
        private String title;
        private String content;
        private String writer;

        public static BoardReadRes fromBoard(Board board){
            return BoardReadRes.builder().title(board.getTitle()).content(board.getContent()).writer(board.getWriter()).build();
        }
    }
}
