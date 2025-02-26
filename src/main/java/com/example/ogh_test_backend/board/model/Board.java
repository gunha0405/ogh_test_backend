package com.example.ogh_test_backend.board.model;

import com.example.ogh_test_backend.comment.model.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Schema(description = "게시글 정보를 담는 객체")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    @Schema(description = "게시글의 고유 아이디", example = "100")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @Schema(description = "게시글의 제목", example = "안녕하세요. 오늘 가입했습니다.")
    private String title;
    @Schema(description = "게시글의 내용", example = "잘 부탁드립니다.")
    private String content;
    @Schema(description = "게시글의 작성자", example = "초보 개발자")
    private String writer;

    @Schema(description = "댓글 리스트")
    @OneToMany(mappedBy = "board")
    private List<Comment> comments;
}
