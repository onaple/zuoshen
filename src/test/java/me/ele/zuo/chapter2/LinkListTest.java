package me.ele.zuo.chapter2;

import static org.junit.Assert.*;

/**
 * Created by onaple on 2017/2/7.
 */
public class LinkListTest {
    public static void main(String[] args) {
        LinkList linkList1 = new LinkList();
        linkList1.addFirstNode(20);
        linkList1.addFirstNode(21);
        linkList1.addFirstNode(19);
        //print19,21,20  
        linkList1.add(1, 22); //print19,22,21,20
        linkList1.add(2, 23); //print19,22,23,21,20  
        linkList1.add(3, 99); //print19,22,23,99,21,20  
        //调用此方法会print 19,22,23,99,21,20 
        linkList1.displayAllNodes();


        LinkList linkList2 = new LinkList();
        linkList2.addFirstNode(200);
        linkList2.addFirstNode(231);
        linkList2.addFirstNode(19);
        //print19,21,20
        linkList2.add(1, 22); //print19,22,21,20
        linkList2.add(2, 23); //print19,22,23,21,20
        linkList2.add(3, 9329); //print19,22,23,99,21,20
        //调用此方法会print 19,22,23,99,21,20
        linkList2.displayAllNodes();


        linkList1.printCommonPart(linkList1.first, linkList2.first);
    }




}