package ql.vn.qlsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ql.vn.qlsp.entity.CommentProductEntity;

public interface CommentProductRepository extends JpaRepository<CommentProductEntity, Integer> {
}
