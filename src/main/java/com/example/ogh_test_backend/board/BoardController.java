package com.example.ogh_test_backend.board;

import com.example.ogh_test_backend.board.model.dto.BoardReadDto;
import com.example.ogh_test_backend.board.model.dto.BoardRegisterDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @Operation(
            summary = "게시글 등록",
            description = "게시글을 등록 합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "조회 성공"),
                    @ApiResponse(responseCode = "404", description = "작성 불가")
            }
    )
    @PostMapping("/register")
    public ResponseEntity<BoardRegisterDto.BoardRegisterRes> register(@RequestBody BoardRegisterDto.BoardRegisterReq dto) {
        BoardRegisterDto.BoardRegisterRes response = boardService.register(dto);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "게시글 상세보기",
            description = "주어진 ID에 해당하는 게시글을 조회 합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "조회 성공"),
                    @ApiResponse(responseCode = "404", description = "게시글 찾을 수 없음")
            }
    )
    @GetMapping("/read/{boardIdx}")
    public ResponseEntity<BoardReadDto.BoardReadRes> read(@PathVariable Long boardIdx) {
        BoardReadDto.BoardReadRes response = boardService.read(boardIdx);
        return ResponseEntity.ok(response);
    }
}
