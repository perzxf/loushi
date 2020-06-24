package com.ls.service.system.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ls.entity.system.SysNotice;
import com.ls.mapper.system.SysNoticeMapper;
import com.ls.service.system.SysNoticeService;
import org.springframework.stereotype.Service;

/**
 * @author zhangchuanfei
 */
@Service
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeMapper, SysNotice> implements SysNoticeService {
}
