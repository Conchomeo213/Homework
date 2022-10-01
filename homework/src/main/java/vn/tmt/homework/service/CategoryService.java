package vn.tmt.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tmt.homework.entity.Category;
import vn.tmt.homework.exception.InvalidSizeException;
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
}
