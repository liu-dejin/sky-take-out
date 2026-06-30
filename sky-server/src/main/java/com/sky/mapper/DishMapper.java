package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.dto.DishQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {


    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    /**
     * 新增菜品
     * @param dish
     */
    @AutoFill(OperationType.INSERT)
    void insert(Dish dish);

    /**
     * 菜品分页查询
     * @param dishPageQueryDTO
     * @return
     */
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);



    /**
     * 根据主键查询菜品
     * @param id
     */
    @Select("select * from dish where id = #{id};")
    Dish getByid(Long id);

    // /**
    //  * 根据主键删除菜品
    //  * @param id
    //  */
    // @Delete("delete from dish where id = #{id};")
    // void deleteById(Long id);


    /**
     * 根据菜品id集合批量删除
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 更新基本信息
     *  @param dish
     */
    @AutoFill(OperationType.UPDATE)
    void update(Dish dish);

    /**
     * 根据分类id查询菜品
     * @param dishQueryDTO
     * @return
     */

    List<Dish> getDish(DishQueryDTO dishQueryDTO);


    /**
     * 根据套餐id查询菜品
     * @param id
     * @return
     */
    @Select("select d.* from dish d left join setmeal_dish sd on d.id = sd.dish_id where sd.setmeal_id = #{id}")
     List<Dish> getBySetmealId(Long id);

}
