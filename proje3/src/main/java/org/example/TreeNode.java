package org.example;

import java.util.*;

public class TreeNode {
    public Kisi kisi;
//    public Kisi esi;
    public List<TreeNode> children = new LinkedList<>();
    TreeNode(Kisi kisi){
        this.kisi = kisi;
    }

    TreeNode(Kisi kisi,List<TreeNode> child){
        children = child;
        this.kisi = kisi;
    }
    public void addChild(Kisi kisi){
        children.add(new TreeNode(kisi));
    }

//    public void setWife(Kisi kisi){
//        esi = kisi;
//        System.out.println("Eş eklendi: " + esi.isim +"    --  " +  this.kisi.isim);
//
//    }


    public static void printNAryTree(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) {
                TreeNode node = queue.poll();
                assert node != null;
                System.out.print(node.kisi.isim + " ");
                for (TreeNode item : node.children) {
                    queue.offer(item);
                }
            }
            System.out.println();
        }
    }
    public static void MeslekTree(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) {
                TreeNode node = queue.poll();
                assert node != null;
                //System.out.println(node.kisi.getMeslek() + " ");
                for (TreeNode item : node.children) {
                    if(node.kisi.getMeslek().equals(item.kisi.getMeslek())){
                        System.out.print(node.kisi.getMeslek()+": ");
                        System.out.println(node.kisi.getIsim()+" "+item.kisi.getIsim());
                    }
                    queue.offer(item);
                }
            }
        }
    }



}
