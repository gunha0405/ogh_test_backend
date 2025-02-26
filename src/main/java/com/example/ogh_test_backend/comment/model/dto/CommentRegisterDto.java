package com.example.ogh_test_backend.comment.model.dto;

import com.example.ogh_test_backend.board.model.Board;
import com.example.ogh_test_backend.comment.model.Comment;
import lombok.Builder;
import lombok.Getter;

public class CommentRegisterDto {
    @Getter
    @Builder
    public static class CommentRegisterReq{
        private String content;
        private String writer;
        private Board board;
        public Comment toEntity(Board board){
            return Comment.builder().content(content).writer(writer).board(board).build();
        }
    }

    @Getter
    @Builder
    public static class CommentRegisterRes{
        private String writer;
        public static CommentRegisterRes fromEntity(Comment comment){
            return CommentRegisterRes.builder().writer(comment.getWriter()).build();
        }
    }
}
