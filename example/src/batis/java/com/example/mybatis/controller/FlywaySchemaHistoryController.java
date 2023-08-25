package com.example.mybatis.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.mybatis.entity.FlywaySchemaHistory;
import com.example.mybatis.repo.FlywaySchemaHistoryRepo;
import org.springframework.web.bind.annotation.RestController;
import java.io.Serializable;
import java.util.List;

/**
 *  控制层。
 *
 * @author bill
 * @since 2023-08-25
 */
@RestController
@RequestMapping("/flywaySchemaHistory")
public class FlywaySchemaHistoryController {

    @Autowired
    private FlywaySchemaHistoryRepo flywaySchemaHistoryRepo;

    /**
     * 添加。
     *
     * @param flywaySchemaHistory 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody FlywaySchemaHistory flywaySchemaHistory) {
        return flywaySchemaHistoryRepo.save(flywaySchemaHistory);
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Serializable id) {
        return flywaySchemaHistoryRepo.removeById(id);
    }

    /**
     * 根据主键更新。
     *
     * @param flywaySchemaHistory 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody FlywaySchemaHistory flywaySchemaHistory) {
        return flywaySchemaHistoryRepo.updateById(flywaySchemaHistory);
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<FlywaySchemaHistory> list() {
        return flywaySchemaHistoryRepo.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public FlywaySchemaHistory getInfo(@PathVariable Serializable id) {
        return flywaySchemaHistoryRepo.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Page<FlywaySchemaHistory> page(Page<FlywaySchemaHistory> page) {
        return flywaySchemaHistoryRepo.page(page);
    }

}
