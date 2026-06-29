package com.sky.service.impl;

import com.sky.entity.DishFlavor;
import com.sky.mapper.DishFlavorMapper;
import com.sky.service.DishFlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishFlavorServiceImpl implements DishFlavorService {

    @Autowired
    private DishFlavorMapper dishFlavorMapper;

    /**
     * 批量新增口味
     *
     * @param flavors
     */
    @Override
    public void insertBatch(List<DishFlavor> flavors) {
        dishFlavorMapper.insertBatch(flavors);
    }

    /**
     * 根据菜品id删除口味
     *
     * @param DishId
     */
    @Override
    public void deleteByDishId(Long DishId) {
        dishFlavorMapper.deleteByDishId(DishId);
    }
}
