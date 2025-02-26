package com.example.ogh_test_backend.comment;

import com.example.ogh_test_backend.board.BoardRepository;
import com.example.ogh_test_backend.board.model.Board;
import com.example.ogh_test_backend.comment.model.Comment;
import com.example.ogh_test_backend.comment.model.dto.CommentRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    public CommentRegisterDto.CommentRegisterRes register(Long boardIdx, CommentRegisterDto.CommentRegisterReq dto) {
        Optional<Board> board = boardRepository.findById(boardIdx);
        Comment comment = commentRepository.save(dto.toEntity(board.get()));
        return CommentRegisterDto.CommentRegisterRes.fromEntity(comment);
    }
}
