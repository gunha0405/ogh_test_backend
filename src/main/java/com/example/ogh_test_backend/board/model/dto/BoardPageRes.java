package com.example.ogh_test_backend.board.model.dto;

import com.example.ogh_test_backend.board.model.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardPageRes {
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean hasNext;
    private boolean hasPrevious;

    private List<BoardReadDto.BoardReadRes> boardList;
    public static BoardPageRes from(Page<Board> boardPage) {
        return BoardPageRes.builder()
                .page(boardPage.getNumber())
                .size(boardPage.getSize())
                .totalElements(boardPage.getTotalElements())
                .totalPages(boardPage.getTotalPages())
                .hasNext(boardPage.hasNext())
                .hasPrevious(boardPage.hasPrevious())
                .boardList(boardPage.stream().map(BoardReadDto.BoardReadRes::fromEntity).collect(Collectors.toList()))
                .build();
    }
}
