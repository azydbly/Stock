package com.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @类描述：酒的实体类
 * @Author: xiaoshitou
 * @时间： 2018/6/20 18:09
 */
public class Alcohol {

    //主键
    private int id;

    //酒的名称
    private String name;

    //所属种类
    private int pid;

    //描述
    private String describe;

    //图片地址
    private String url;

    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String insertdatetime;

    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updatedatetime;

    //每箱几瓶
    private int boxNumber;

    //每箱的进价
    private Double boxPurchasePrice;

    //每箱的售价
    private Double boxPrice;

    //购买箱数为多少箱，价格为批发价
    private int boxWholesaleNumber;

    //批发每箱的价格
    private Double boxWholesalePrice;

    //每瓶的进价
    private Double bottlePurchasePrice;

    //每瓶的售价
    private Double bottlePrice;

    //购买多少瓶时，价格为批发价
    private int bottleWholesaleNumber;

    //批发价格每瓶的价格
    private Double bottleWholesalePrice;

    //剩余箱数
    private int surplusBoxNumber;

    //剩余瓶数
    private int surplusWholesaleNumber;

    //标识
    private int state;

    //种类的实体类
    private Varieties varieties;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInsertdatetime() {
        return insertdatetime;
    }

    public void setInsertdatetime(String insertdatetime) {
        this.insertdatetime = insertdatetime;
    }

    public String getUpdatedatetime() {
        return updatedatetime;
    }

    public void setUpdatedatetime(String updatedatetime) {
        this.updatedatetime = updatedatetime;
    }

    public int getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(int boxNumber) {
        this.boxNumber = boxNumber;
    }

    public Double getBoxPurchasePrice() {
        return boxPurchasePrice;
    }

    public void setBoxPurchasePrice(Double boxPurchasePrice) {
        this.boxPurchasePrice = boxPurchasePrice;
    }

    public Double getBoxPrice() {
        return boxPrice;
    }

    public void setBoxPrice(Double boxPrice) {
        this.boxPrice = boxPrice;
    }

    public int getBoxWholesaleNumber() {
        return boxWholesaleNumber;
    }

    public void setBoxWholesaleNumber(int boxWholesaleNumber) {
        this.boxWholesaleNumber = boxWholesaleNumber;
    }

    public Double getBoxWholesalePrice() {
        return boxWholesalePrice;
    }

    public void setBoxWholesalePrice(Double boxWholesalePrice) {
        this.boxWholesalePrice = boxWholesalePrice;
    }

    public Double getBottlePurchasePrice() {
        return bottlePurchasePrice;
    }

    public void setBottlePurchasePrice(Double bottlePurchasePrice) {
        this.bottlePurchasePrice = bottlePurchasePrice;
    }

    public Double getBottlePrice() {
        return bottlePrice;
    }

    public void setBottlePrice(Double bottlePrice) {
        this.bottlePrice = bottlePrice;
    }

    public int getBottleWholesaleNumber() {
        return bottleWholesaleNumber;
    }

    public void setBottleWholesaleNumber(int bottleWholesaleNumber) {
        this.bottleWholesaleNumber = bottleWholesaleNumber;
    }

    public Double getBottleWholesalePrice() {
        return bottleWholesalePrice;
    }

    public void setBottleWholesalePrice(Double bottleWholesalePrice) {
        this.bottleWholesalePrice = bottleWholesalePrice;
    }

    public int getSurplusBoxNumber() {
        return surplusBoxNumber;
    }

    public void setSurplusBoxNumber(int surplusBoxNumber) {
        this.surplusBoxNumber = surplusBoxNumber;
    }

    public int getSurplusWholesaleNumber() {
        return surplusWholesaleNumber;
    }

    public void setSurplusWholesaleNumber(int surplusWholesaleNumber) {
        this.surplusWholesaleNumber = surplusWholesaleNumber;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Varieties getVarieties() {
        return varieties;
    }

    public void setVarieties(Varieties varieties) {
        this.varieties = varieties;
    }
}
