package com.sky.service;

import com.sky.entity.DishFlavor;

import java.util.List;

public interface DishFlavorService {
    /**
     * 批量新增口味
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 根据菜品id删除口味
     * @param DishId
     */
    void deleteByDishId(Long DishId);
}
