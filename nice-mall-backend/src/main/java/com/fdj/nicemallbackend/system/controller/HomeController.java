package com.fdj.nicemallbackend.system.controller;

import com.fdj.nicemallbackend.system.dto.Findgoods;
import com.fdj.nicemallbackend.system.dto.Result;
import com.fdj.nicemallbackend.system.entity.Goods;
import com.fdj.nicemallbackend.system.service.IGoodsService;
import com.fdj.nicemallbackend.system.service.ITypeGoodsService;
import com.fdj.nicemallbackend.system.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @Classname HomeController
 * @Description TODO
 * @Date 19-9-3 下午8:58
 * @Created by xns
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    ITypeGoodsService iTypeGoodsService;

    @Autowired
    IGoodsService goodsService;

    /**
     * 获取商品分类
     * @return
     */
    @GetMapping("/sort")
    public Result getSort(){
        Result result = iTypeGoodsService.getSort();
        return result;
    }

    /**
     * 搜索查询
     * @param field
     * @return
     */
    @GetMapping("/{field}")
    public Result fuzzyQuery(@PathVariable String field){
        Set<Findgoods> goods = goodsService.findByField(field);
        if(goods.isEmpty()) {
            return new Result().fail("查询失败,无对应的数据!!!");
        }
        else{
            return new Result().success(goods, "查询成功!!!");
        }
    }

    /**
     * 首页中根据分类获取数据
     * @param type
     * @return
     */
    @GetMapping("/{type}")
    public Result typeQuery(@PathVariable String type){
        List<Findgoods> typeGoods = iTypeGoodsService.getSortGoods(type);
        if(typeGoods.isEmpty()) {
            return new Result().fail("查询失败,无对应的数据!!!");
        }
        else{
            return new Result().success(typeGoods, "查询成功!!!");
        }
    }
}
