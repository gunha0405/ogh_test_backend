package com.example.ogh_test_backend.board.model.dto;

import com.example.ogh_test_backend.board.model.Board;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

public class BoardRegisterDto {

    @Schema(description = "게시글 작성시 필요한 정보를 받아오는 객체")
    @Getter
    @Builder
    public static class BoardRegisterReq{
        private String title;
        private String content;
        private String writer;
        public Board toEntity() {
            return Board.builder().title(title).content(content).writer(writer).build();
        }
    }

    @Schema(description = "게시글 작성완료시 응답 객체")
    @Getter
    @Builder
    public static class BoardRegisterRes{
        private String title;
        private String writer;

        public static BoardRegisterRes fromEntity(Board board) {
            return BoardRegisterRes.builder().title(board.getTitle()).writer(board.getWriter()).build();
        }
    }
}
