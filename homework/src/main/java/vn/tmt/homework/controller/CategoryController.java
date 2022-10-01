package vn.tmt.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.tmt.homework.entity.Category;
import vn.tmt.homework.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/homework")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> getallCategory(){
        var ret = this.categoryService.getAllCategory();
        return ResponseEntity.ok(ret);
    }
}
