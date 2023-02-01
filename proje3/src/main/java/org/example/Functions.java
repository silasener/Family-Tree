package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Functions {
    public static List<Kisi> searchBloodGroup(List<Kisi> allPersons, String kanGrubu) {
        List<Kisi> members = new ArrayList<>();

        for (Kisi kisi : allPersons) {

                if (kisi.kanGrubu.equals(kanGrubu)) {
                    if (members.size() == 0) {
                        members.add(kisi);
                    } else {
                        boolean flag = false;
                        for (Kisi member : members) {
                            if (member.id == kisi.id) {
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            members.add(kisi);
                        }
                    }

                }
            }


        return members;
    }

    static int depthOfTree(TreeNode root) {
        // recursive function
        if (root == null)
            return 0;

        int depth = 0;
        for (TreeNode it : root.children) {
            depth = Math.max(depth, depthOfTree(it));
        }

        return depth + 1;

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


    public static TreeNode findRelations(List<Kisi> visited) {
        Collections.reverse(visited);
        String relation = "";
        for(int i = 1; i < visited.size(); i++){
           // System.out.println(visited.get(i).isim);
            if(visited.get(i).cinsiyet.equals("Kadın")){
//                System.out.println("Anne");
                relation += "Anne ";
            }
            else if(visited.get(i).cinsiyet.equals("Erkek")){
//                System.out.println("Baba");
                relation += "Baba ";
            }

        }
        System.out.println(relation);
        return null;
    }

}
