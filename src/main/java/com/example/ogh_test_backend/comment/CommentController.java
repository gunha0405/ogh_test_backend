package com.example.ogh_test_backend.comment;

import com.example.ogh_test_backend.comment.model.dto.CommentRegisterDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @Operation(
            summary = "댓글 작성하기",
            description = "주어진 정보에 해당하는 댓글을 작성합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "조회 성공"),
                    @ApiResponse(responseCode = "404", description = "댓글 작성 실패")
            }
    )
    @PostMapping("/register/{boardIdx}")
    public ResponseEntity<CommentRegisterDto.CommentRegisterRes> register(@PathVariable Long boardIdx, @RequestBody CommentRegisterDto.CommentRegisterReq dto){
        CommentRegisterDto.CommentRegisterRes response = commentService.register(boardIdx, dto);
        return ResponseEntity.ok(response);
    }

}
