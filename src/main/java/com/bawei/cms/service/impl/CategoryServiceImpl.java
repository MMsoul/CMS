package com.bawei.cms.service.impl;

import com.bawei.cms.domain.Category;
import com.bawei.cms.dao.CategoryMapper;
import com.bawei.cms.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章分类表 服务实现类
 * </p>
 *
 * @author bawei
 * @since 2019-07-21
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
