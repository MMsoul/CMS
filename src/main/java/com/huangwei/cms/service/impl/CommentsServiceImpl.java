package com.huangwei.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huangwei.cms.dao.CommentsMapper;
import com.huangwei.cms.domain.Comments;
import com.huangwei.cms.service.ICommentsService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章评论表 服务实现类
 * </p>
 *
 * @author bawei
 * @since 2019-07-25
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements ICommentsService {

}
