package com.qf.ttshop.service.impl;

import com.qf.ttshop.dao.TbItemCustomMapper;
import com.qf.ttshop.dao.TbItemMapper;
import com.qf.ttshop.dto.Page;
import com.qf.ttshop.dto.Result;
import com.qf.ttshop.pojo.po.TbItem;
import com.qf.ttshop.pojo.vo.TbItemCustom;
import com.qf.ttshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品的业务逻辑层实现类
 * 在业务逻辑层实现类中异常处理需要尽量细化
 * 而且每个异常都应该写入日志中
 * User: DHC
 * Date: 2017/12/29
 * Time: 14:21
 * Version:V1.0
 */
@Service
public class ItemServiceImpl implements ItemService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbItemMapper itemDao;
    @Autowired
    private TbItemCustomMapper itemCustomDao;

    @Override
    public TbItem getItemById(Long itemId) {
        return itemDao.selectByPrimaryKey(itemId);
    }

    @Override
    public List<TbItem> listItems() {
        List<TbItem> list = null;
        try {
            list = itemDao.selectByExample(null);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Result<TbItemCustom> listItemsByPage(Page page) {
        Result<TbItemCustom> result = new Result<TbItemCustom>();
        try {
            Long total = itemCustomDao.countItemsByCondition();
            List<TbItemCustom> list = itemCustomDao.listItemsByPage(page);
            //商品总数
            result.setTotal(total);
            //指定页码的商品集合
            result.setRows(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }
}
