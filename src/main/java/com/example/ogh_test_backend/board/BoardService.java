package com.example.ogh_test_backend.board;

import com.example.ogh_test_backend.board.model.Board;
import com.example.ogh_test_backend.board.model.dto.BoardPageRes;
import com.example.ogh_test_backend.board.model.dto.BoardReadDto;
import com.example.ogh_test_backend.board.model.dto.BoardRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardRegisterDto.BoardRegisterRes register(BoardRegisterDto.BoardRegisterReq dto) {
        Board board = boardRepository.save(dto.toEntity());
        return BoardRegisterDto.BoardRegisterRes.fromEntity(board);
    }

    public BoardReadDto.BoardReadRes read(Long boardIdx) {
        Optional<Board> board = boardRepository.findById(boardIdx);
        if (board.isPresent()) {
            return BoardReadDto.BoardReadRes.fromEntity(board.get());
        }
        return null;
    }

    public BoardPageRes list(int page, int size) {
        Page<Board> boardList = boardRepository.findAll(PageRequest.of(page, size));
        return BoardPageRes.fromEntity(boardList);
    }
}
