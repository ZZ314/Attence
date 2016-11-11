package com.example.administrator.check;

public class ItemBean {
    public String itemId;
    public String itemSno;
    public String itemName;
    public String itemBanji;
    public int itemPosi;
    public ItemBean(String itemId,String itemSno,String itemName,String itemBanji,int itemPosi)
    {
        this.itemPosi=itemPosi;
        this.itemId=itemId;
        this.itemSno=itemSno;
        this.itemName=itemName;
        this.itemBanji=itemBanji;
    }
}
