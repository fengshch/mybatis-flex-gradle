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
import com.example.mybatis.po.UsersPo;
import com.example.mybatis.repo.UsersRepo;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *  控制层。
 *
 * @author bill
 * @since 2024-12-10
 */
@RestController
@RequestMapping("/usersPo")
public class UsersController {

    @Autowired
    private UsersRepo usersRepo;

    /**
     * 添加。
     *
     * @param usersPo 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody UsersPo usersPo) {
        return usersRepo.save(usersPo);
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Integer id) {
        return usersRepo.removeById(id);
    }

    /**
     * 根据主键更新。
     *
     * @param usersPo 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody UsersPo usersPo) {
        return usersRepo.updateById(usersPo);
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<UsersPo> list() {
        return usersRepo.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public UsersPo getInfo(@PathVariable Integer id) {
        return usersRepo.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Page<UsersPo> page(Page<UsersPo> page) {
        return usersRepo.page(page);
    }

}
