package com.example.ogh_test_backend.comment;

import com.example.ogh_test_backend.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
