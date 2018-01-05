package com.qf.ttshop.web;

import com.qf.ttshop.dto.Page;
import com.qf.ttshop.dto.Result;
import com.qf.ttshop.pojo.po.TbItem;
import com.qf.ttshop.pojo.vo.TbItemCustom;
import com.qf.ttshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: DHC
 * Date: 2017/12/29
 * Time: 14:13
 * Version:V1.0
 */
@Controller
public class ItemAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    public TbItem getItemById(@PathVariable("itemId") Long itemId) {
        return itemService.getItemById(itemId);
    }

//    @ResponseBody
//    @RequestMapping(value = "/items",method = RequestMethod.POST)
//    public List<TbItem> listItems() {
//        List<TbItem> list = null;
//        try {
//            list = itemService.listItems();
//            System.out.println(list);
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            e.printStackTrace();
//        }
//        return list;
//    }

    @ResponseBody
    @RequestMapping(value = "/items",method = RequestMethod.POST)
    public Result<TbItemCustom> listItems(Page page) {
        Result<TbItemCustom>  result = null;
        try {
            result = itemService.listItemsByPage(page);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }
}
