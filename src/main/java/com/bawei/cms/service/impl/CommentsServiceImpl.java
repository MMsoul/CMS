package com.bawei.cms.service.impl;

import com.bawei.cms.domain.Comments;
import com.bawei.cms.dao.CommentsMapper;
import com.bawei.cms.service.ICommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
