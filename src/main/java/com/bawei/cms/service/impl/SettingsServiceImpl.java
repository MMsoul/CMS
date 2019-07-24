package com.bawei.cms.service.impl;

import com.bawei.cms.domain.Settings;
import com.bawei.cms.dao.SettingsMapper;
import com.bawei.cms.service.ISettingsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置表 服务实现类
 * </p>
 *
 * @author bawei
 * @since 2019-07-21
 */
@Service
public class SettingsServiceImpl extends ServiceImpl<SettingsMapper, Settings> implements ISettingsService {

}
