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
import com.example.mybatis.entity.Authorities;
import com.example.mybatis.repo.AuthoritiesRepo;
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
@RequestMapping("/authorities")
public class AuthoritiesController {

    @Autowired
    private AuthoritiesRepo authoritiesRepo;

    /**
     * 添加。
     *
     * @param authorities 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody Authorities authorities) {
        return authoritiesRepo.save(authorities);
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Serializable id) {
        return authoritiesRepo.removeById(id);
    }

    /**
     * 根据主键更新。
     *
     * @param authorities 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody Authorities authorities) {
        return authoritiesRepo.updateById(authorities);
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<Authorities> list() {
        return authoritiesRepo.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public Authorities getInfo(@PathVariable Serializable id) {
        return authoritiesRepo.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Page<Authorities> page(Page<Authorities> page) {
        return authoritiesRepo.page(page);
    }

}
