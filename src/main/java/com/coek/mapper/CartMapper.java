package com.coek.mapper;

import com.coek.domain.Cart;
import com.coek.vo.CartVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-26 21:30:23
 */
public interface CartMapper {

    /**
     * 根据pid和uid查询当前商品是否存在购物车中
     * @param pid   商品id
     * @param uid   用户id
     * @return
     */
    Cart findByPidAndUid(@Param("pid") Integer pid,
                         @Param("uid") Integer uid);

    /**
     * 更新购车中某个商品的数量
     * @param num 新增数量
     * @param pid 商品id
     * @return
     */
    Integer updateNum(@Param("num") Integer num,
                      @Param("pid") Integer pid,
                      @Param("modifiedTime") Date modifiedTime,
                      @Param("uid")Integer uid);

    /**
     * 添加到购物车
     * @param cart 商品
     * @return
     */
    Integer addToCart(Cart cart);


    /**
     * 展示用户购物车信息
     * @param uid 用户id
     * @return
     */
    List<CartVO> showCartList(Integer uid);

    /**
     * 购物车中增加商品数量
     * @param cid   购物车中某条信息id
     * @return
     */
    Integer addNum(@Param("cid") Integer cid,
                   @Param("modifiedTime") Date modifiedTime);

    /**
     * 购物车中减少商品数量
     * @param cid 购物车中某条信息id
     * @param modifiedTime 修改时间
     * @return
     */
    Integer reduceNum(@Param("cid") Integer cid,
                      @Param("modifiedTime") Date modifiedTime );

    /**
     * 根据cid查找数据
     * @param cid
     * @return
     */
    Cart findByCid(Integer cid);

    /**
     * 查询购物车中需结算的商品
     * @param uid  用户id
     * @param cids 需结算的商品的cid
     * @return
     */
    List<CartVO> showSelectedList(@Param("uid") Integer uid,
                                  @Param("array") Integer[] cids);

    /**
     * 根据cid删除购物车中的商品
     * @param cid 商品在购物车中的id
     * @return
     */
    Integer deleteCart(Integer cid);
}
