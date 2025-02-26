package com.example.ogh_test_backend.comment.model;

import com.example.ogh_test_backend.board.model.Board;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "댓글 정보를 담는 객체")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Schema(description = "댓글의 고유 아이디")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @Schema(description = "댓글의 내용")
    private String content;
    @Schema(description = "댓글의 작성자")
    private String writer;

    @Schema(description = "댓글이 속한 게시글 정보")
    @ManyToOne
    @JoinColumn(name = "board_idx")
    private Board board;

}
