package vn.tmt.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.tmt.homework.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
