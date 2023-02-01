package org.example;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.util.*;
import java.util.List;


public class DepthFirstSearch {
    JFrame f;
    public static TreeNode searchParent(Kisi kisi, TreeNode root) {

        if (root == null) return null;

        if (root.kisi.isim.equals(kisi.babaAdi) || root.kisi.isim.equals(kisi.anneAdi)) {
            return root;
        }
        for (TreeNode it : root.children) {
            TreeNode result = searchParent(kisi, it);
            if (result != null) return result;
        }
        return null;
    }


    public static List<TreeNode> findLeaves(TreeNode root) {

        List<TreeNode> leaves  = new ArrayList<>();

        if (root == null) {
            return leaves;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            // If the current node has no children, it is a leaf node
            if (current.children.isEmpty()) {
                leaves.add(current);
            } else {
                // Add the children of the current node to the stack to be visited later
                stack.addAll(current.children);
            }
        }

        return leaves;



    }


    public static List<Kisi> searchRelationship(String isim1,String isim2, TreeNode root) {
        List<Kisi> visited  = new ArrayList<>();
        boolean flag = false;
        Kisi ilkkisi = null;

        if (root == null) {
            return visited;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
//            System.out.println(current.kisi.isim);
            if (current.kisi.isim.equals(isim1)) {
                ilkkisi = current.kisi;
                flag = true;
            }
            if (flag) {
                visited.add(current.kisi);
            }

//            System.out.println(visited);
            if(current.children.isEmpty()&& !current.kisi.isim.equals(isim2)){
                visited.clear();
            }
            if (current.kisi.isim.equals(isim2) && flag) {
//                return visited;
                break;
            } else {
                stack.addAll(current.children);
            }
        }

        if(visited.contains(ilkkisi)){
//            System.out.println("Zaten var");
        }
        else {
            Collections.reverse(visited);
            visited.add(ilkkisi);
            Collections.reverse(visited);
//            System.out.println("Eklendi");
        }

        return visited;
    }




    public  void Dugumler(TreeNode node,int size) {

        f=new JFrame("Family Tree");
        // Tarama sırasında kullanılacak kuyruk
        Queue<TreeNode> queue = new LinkedList<>();
        // Tarama işlemine başla
        queue.add(node);
        ArrayList<Kisi> kardesler=new ArrayList<>();
        // Kuyruktan bir düğüm al
        TreeNode current = queue.remove();

        DefaultMutableTreeNode first=new DefaultMutableTreeNode(current.kisi.getIsim()+current.kisi.getKizlikSoyismi()+current.kisi.getSoyisim()+"-"+current.kisi.getEsi());

        //System.out.print("\n"+current.kisi.getIsim());
        if (current.children!=null) {
            //System.out.print("children: ");
            // System.out.println(current.children);
            // Taranan düğümün çocuklarını tarama sırasına göre ekle
            for (TreeNode child : current.children) {

        DefaultMutableTreeNode second = new DefaultMutableTreeNode(child.kisi.getIsim()+" "+child.kisi.getKizlikSoyismi()+" "+child.kisi.getSoyisim() + "-" + child.kisi.getEsi());
           first.add(second);
                // System.out.print(child.kisi.getIsim() + " ");
                    kardesler.add(child.kisi);
                    for (int i = 0; i < child.children.size(); i++) {
                        DefaultMutableTreeNode third = new DefaultMutableTreeNode(child.children.get(i).kisi.getIsim()+" "+child.children.get(i).kisi.getKizlikSoyismi()+" "+child.children.get(i).kisi.getSoyisim() + "-" + child.children.get(i).kisi.getEsi());
                       // System.out.println("\n"+child.kisi.getIsim() + child.children.get(i).kisi.getIsim());
                        second.add(third);
                        for (int j = 0; j < child.children.get(i).children.size(); j++) {
                            DefaultMutableTreeNode fourth = new DefaultMutableTreeNode(child.children.get(i).children.get(j).kisi.getIsim() +" "+child.children.get(i).children.get(j).kisi.getKizlikSoyismi()+" "+child.children.get(i).children.get(j).kisi.getSoyisim()+ "-" + child.children.get(i).children.get(j).kisi.getEsi());
                            third.add(fourth);
                            for (int k = 0; k < child.children.get(i).children.get(j).children.size(); k++) {
                                DefaultMutableTreeNode fifth = new DefaultMutableTreeNode(child.children.get(i).children.get(j).children.get(k).kisi.getIsim() + "-" + child.children.get(i).children.get(j).children.get(k).kisi.getIsim());
                                fourth.add(fifth);
                            }
                        }
                }
            }


            System.out.println();

            // Taranan düğümün çocuklarını kuyruğa ekle
            for (TreeNode child : current.children) {
                queue.add(child);
            }
            JTree jt=new JTree(first);
            jt.setRowHeight(50);
            f.add(jt);
            f.setSize(800,1200);
            f.setVisible(true);

        }


}

}


