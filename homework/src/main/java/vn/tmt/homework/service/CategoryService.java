package vn.tmt.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tmt.homework.entity.Category;
import vn.tmt.homework.exception.InvalidSizeException;
import vn.tmt.homework.exception.NotFoundException;
import vn.tmt.homework.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepositry;

    public List<Category> getAllCategory(){
        List<Category> list = this.categoryRepositry.findAll();
        if (list.size()<5){
            throw new InvalidSizeException("Category name độ dài phải  lớn hơn 5");
        }
        return list;
    }

    public Category createNewCategory(Category newCategory){
        var ret = this.categoryRepositry.save(newCategory);
        return  ret;
    }

    public void deleteCategoryById(int id){
        var checkId = this.categoryRepositry.findById(id);
        if (checkId==null){
            throw new NotFoundException("không tìm thấy id");
        }
        this.categoryRepositry.deleteById(id);
    }
}
