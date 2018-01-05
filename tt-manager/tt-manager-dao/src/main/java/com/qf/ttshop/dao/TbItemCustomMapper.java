package com.qf.ttshop.dao;

import com.qf.ttshop.dto.Page;
import com.qf.ttshop.pojo.vo.TbItemCustom;

import java.util.List;

/**
 * 扩展自商品的数据访问层接口
 * User: DHC
 * Date: 2018/1/2
 * Time: 15:12
 * Version:V1.0
 */
public interface TbItemCustomMapper {

    /**
     * 分页查询商品数据集合
     * @param page
     * @return
     */
    List<TbItemCustom> listItemsByPage(Page page);

    /**
     * 通过条件查询商品数量
     * @return
     */
    Long countItemsByCondition();
}
