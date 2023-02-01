package org.example;


import java.util.*;
import java.util.List;


public class BreadthFirstSearch {

    public static TreeNode searchParent(Kisi kisi, TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {

//            System.out.println("Current queue: ");
//            for (TreeNode node : queue) {
//                System.out.print(node.kisi.getIsim() + " ");
//            }
//            System.out.println();

            TreeNode current = queue.remove();

            if (current.kisi.isim.equals(kisi.babaAdi) || current.kisi.isim.equals(kisi.anneAdi)) {
                    return current;
//                System.out.println("Found " + kisi.getIsim());

            } else {
                queue.addAll(current.children);
            }
        }
        return null;
    }

    public static TreeNode searchWife(Kisi kisi, TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            String esadi = current.kisi.esi.split(" ")[0];
            if (esadi.equals(kisi.isim)) {
                return current;
            } else {
                queue.addAll(current.children);

            }
        }
        return null;
    }

    public static List<String> findSiblings(TreeNode node) {
        // Üvey kardeşlerin bulunacağı liste
        List<String> siblings = new ArrayList<>();

        // Tarama sırasında kullanılacak kuyruk
        Queue<TreeNode> queue = new LinkedList<>();

        // Tarama işlemine başla
        queue.add(node);
        while (!queue.isEmpty()) {
            ArrayList<Kisi> kardesler = new ArrayList<>();
            // Kuyruktan bir düğüm al
            TreeNode current = queue.remove();
            // System.out.print("\n"+current.kisi.getIsim());
            // Eğer taranan düğüm tarama başlangıcındaki düğümün ana düğümü ise,
            // taranan düğümün çocuklarını tarama sırasına göre üvey kardeşlerdir.
            if (current.children != null) {
                //System.out.print("children: ");
                //System.out.println(current.children);
                // Taranan düğümün çocuklarını tarama sırasına göre ekle
                for (TreeNode child : current.children) {
                    //  System.out.print(child.kisi.getIsim()+" ");
                    kardesler.add(child.kisi);

                }
                System.out.println();
                for (int i = 0; i < kardesler.size(); i++) {
                    String esadi;
                    for (int j = i + 1; j < kardesler.size(); j++) {
                        //System.out.println(kardesler.get(i).getIsim()+" ve"+kardesler.get(j).getIsim());
                        // System.out.println(current.kisi.getEsi());
                        int adindis = current.kisi.getEsi().indexOf(" ");
                        if (adindis != -1) {
                            esadi = current.kisi.getEsi().substring(0, adindis);
                        } else {
                            esadi = current.kisi.getEsi();
                        }
                        // System.out.println(esadi);

                        if (kardesler.get(i).getBabaAdi() == kardesler.get(j).getBabaAdi()) {
                            //System.out.println("öz");
                        } else { //babalar farklı
                            if (kardesler.get(i).getBabaAdi() != esadi) {
                                //System.out.println("uvey olan"+kardesler.get(i).getIsim());
                                siblings.add(kardesler.get(i).getIsim());
                            } else if (kardesler.get(j).getBabaAdi() != esadi) {
                                //System.out.println("uvey olan"+kardesler.get(j).getIsim());
                                siblings.add(kardesler.get(j).getIsim());
                            }
                        }


                        if (kardesler.get(i).getAnneAdi() == kardesler.get(j).getAnneAdi()) {
                            // System.out.println("öz");
                        } else {//anneler farklı
                            if (kardesler.get(i).getAnneAdi() != esadi) {
                                // System.out.println("uvey olan"+kardesler.get(i).getIsim());
                                siblings.add(kardesler.get(i).getIsim());
                            } else if (kardesler.get(j).getAnneAdi() != esadi) {
                                // System.out.println("uvey olan"+kardesler.get(j).getIsim());
                                siblings.add(kardesler.get(j).getIsim());

                            }
                        }


                    }

                }
            }

            // Taranan düğümün çocuklarını kuyruğa ekle
            for (TreeNode child : current.children) {
                queue.add(child);
            }
        }

        // Bulunan üvey kardeşleri döndür
        return siblings;
    }


}