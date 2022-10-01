package vn.tmt.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @PostMapping("/create")
    public ResponseEntity<Category> createNew(@RequestBody Category category){
        Category ret  = this.categoryService.createNewCategory(category);
        return ResponseEntity.ok(ret);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategoryById (@PathVariable("id")int id){
        this.categoryService.deleteCategoryById(id);
        return ResponseEntity.ok("Xoa thanh cong");
    }

}
