package com.example.persistents.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.persistents.po.ProductsPO;
import com.example.persistents.repo.ProductsRepo;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *  控制层。
 *
 * @author bill
 * @since 2026-03-18
 */
@RestController
@RequestMapping("/productsPO")
public class ProductsController {

    @Autowired
    private ProductsRepo productsRepo;

    /**
     * 保存。
     *
     * @param productsPO 
     * @return {@code true} 保存成功，{@code false} 保存失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody ProductsPO productsPO) {
        return productsRepo.save(productsPO);
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Integer id) {
        return productsRepo.removeById(id);
    }

    /**
     * 根据主键更新。
     *
     * @param productsPO 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody ProductsPO productsPO) {
        return productsRepo.updateById(productsPO);
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<ProductsPO> list() {
        return productsRepo.list();
    }

    /**
     * 根据主键获取。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public ProductsPO getInfo(@PathVariable Integer id) {
        return productsRepo.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Page<ProductsPO> page(Page<ProductsPO> page) {
        return productsRepo.page(page);
    }

}
