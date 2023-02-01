package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> cocuguolmayandugumler=new ArrayList<>();
        ArrayList<Kisi> kangrubulist =new ArrayList<>();
        List<String> uveykardes =new ArrayList<>();
        HashSet<String> uveyliste= new HashSet<String>();
        List<String> siraliuveyliste =new ArrayList<>();

        List<Kisi> people = ReadExcel.readFromExcel("/Users/silasener/IdeaProjects/proje3/src/main/java/org/example/testdosyasi.xlsx");

            System.out.println("Listedeki kişi sayısı : "+people.size());
            System.out.println(people);

            TreeNode root = new TreeNode(people.get(0));

            for (int i = 1; i < people.size(); i++) {
                TreeNode foundNode = BreadthFirstSearch.searchParent(people.get(i), root);
                //TreeNode foundwife = BreadthFirstSearch.searchWife(people.get(i), root);


                if (foundNode == null) {
                   // System.out.println("Not found " + people.get(i).getIsim());
                } else {
                    foundNode.addChild(people.get(i));
                    //System.out.println("Added " + people.get(i).getIsim());
                }
//                if (foundwife == null) {
//                    System.out.println("Not found " + people.get(i).getIsim());
//                } else {
//                    foundwife.setWife(people.get(i));
//
//                    System.out.println("Added " + people.get(i).getIsim());
//                }
            }

            System.out.println("----------Tree----------");
            TreeNode.printNAryTree(root);
            int depth = Functions.depthOfTree(root);


while(true){
    System.out.println("\nMENU");
    System.out.println("1-Çocuğu olmayan düğümlerin listesinin yaş sıralamasına göre kaydedilmesi");
    System.out.println("2-Üvey kardeşlerin harf sıralamasına göre kaydedilmesi");
    System.out.println("3-Kan grubu A olanların listesi ");
    System.out.println("4-Soyunda aynı mesleği yapan çocuklar veya torunlar");
    System.out.println("5-Soy ağacında aynı isme sahip kişilerin ismi ve yaşları ");
    System.out.println("6-Alınacak 2 tane isim girdisinden sonra büyük olan kişinin küçük olan kişiye yakınlığı ");
    System.out.println("7-Alınacak kişi bilgisi ile o kişiye ait soy ağacının gösterilmesi");
    System.out.println("8-Soy ağacının kaç nesilden oluştuğunu görmek (Ağacın maksimum derinliği)");
    System.out.println("9-Kullanıcıdan alınan isim girdisinden sonra o isimden sonra kaç nesil geldiğini görmek");
    System.out.println("10-Soy Ağacını arayüzde görmek");
    System.out.println("0-Çıkış");
    System.out.print("Yapmak istediginiz islemi secin: ");
    Scanner scanner=new Scanner(System.in);
    int islem=scanner.nextInt();
    switch (islem) {
        case 1:
            List<TreeNode> leaves = DepthFirstSearch.findLeaves(root);
            for (TreeNode leaf : leaves) {
                int lastfor=leaf.kisi.dogumTarihi.length()-4;
                int birth= Integer.parseInt(leaf.kisi.dogumTarihi.substring(lastfor));
                int age=2022-birth;
                System.out.println("Leaf: "+leaf.kisi.isim+"("+age+")");
                cocuguolmayandugumler.add(age);
            }
            Collections.sort(cocuguolmayandugumler);
            System.out.println("\n"+cocuguolmayandugumler);
            break;
        case 2:
            uveykardes=BreadthFirstSearch.findSiblings(root);
            uveyliste.addAll(uveykardes);
            siraliuveyliste.addAll(uveyliste);
            Collections.sort(siraliuveyliste);
            System.out.println(siraliuveyliste);
            break;
        case 3:
            System.out.print("Aranacak kan grubunu girin: ");
            Scanner scanner1=new Scanner(System.in);
            String kangrubu=scanner1.nextLine();
            for (Kisi search:people) {
                if(search.kanGrubu.contains(kangrubu)){
                    System.out.print(search.getIsim()+" ");
                    kangrubulist.add(search);
                }
            }
            System.out.println("\n"+kangrubulist);
            break;
        case 4:
           TreeNode.MeslekTree(root);
            TreeNode rootes = new TreeNode(people.get(1));

            for (int i = 2; i < people.size(); i++) {
                TreeNode foundNodes = BreadthFirstSearch.searchParent(people.get(i), rootes);
                if (foundNodes == null) {
                   // System.out.println("Not found " + people.get(i).getIsim());
                } else {
                    foundNodes.addChild(people.get(i));
                    //System.out.println("Added " + people.get(i).getIsim());
                }
            }
           TreeNode.MeslekTree(rootes);
            break;
        case 5:
            for (int i = 0; i < people.size(); i++) {
                for (int j = i+1; j <people.size() ; j++) {
                    if(people.get(i).getIsim().equals(people.get(j).getIsim())){
                        int lastfouri=people.get(i).getDogumTarihi().length()-4;
                        int lastfourj=people.get(j).getDogumTarihi().length()-4;
                        int birthi= Integer.parseInt(people.get(i).getDogumTarihi().substring(lastfouri));
                        int birthj= Integer.parseInt(people.get(j).getDogumTarihi().substring(lastfourj));
                        int agei=2022-birthi;
                        int agej=2022-birthj;
                        System.out.println(people.get(i).getIsim()+" yasi: "+agei+"----"+people.get(j).getIsim()+" yasi: "+agej);
                    }
                }
            }
            break;
        case 6:
            System.out.println("Ad soyad giriniz");
            Scanner kisibilgisi=new Scanner(System.in);
            String kisi1=kisibilgisi.nextLine();
            System.out.println("Ad soyad giriniz");
            String kisi2=kisibilgisi.nextLine();
            String buyukkisi="",kucukkisi="";
            for (Kisi k1:people) {
                for (Kisi k2:people) {
                    if((k1.getIsim()+" "+k1.getSoyisim()).equals(kisi1) && (k2.getIsim()+" "+k2.getSoyisim()).equals(kisi2)){
                      int lastfourk1=k1.getDogumTarihi().length()-4;
                        int lastfourk2=k2.getDogumTarihi().length()-4;
                        int birthk1= Integer.parseInt(k1.getDogumTarihi().substring(lastfourk1));
                        int birthk2= Integer.parseInt(k2.getDogumTarihi().substring(lastfourk2));
                        if(birthk1>birthk2){
                            kucukkisi=k1.getIsim();
                            buyukkisi=k2.getIsim();


                        }else if(birthk2>birthk1){
                             kucukkisi=k2.getIsim();
                             buyukkisi=k1.getIsim();
                        }
                    }
                }

            }

            List<Kisi> visited;
            visited = DepthFirstSearch.searchRelationship(buyukkisi, kucukkisi, root);
            Functions.findRelations(visited);

            break;
        case 7:
            System.out.println("İsim ve Soyisim giriniz");
            Scanner scanner7=new Scanner(System.in);
            String findtree=scanner7.nextLine();
            for (Kisi aranankisi: people) {
                if((aranankisi.getIsim()+" "+aranankisi.getSoyisim()).equals(findtree)){
                    TreeNode personfind= new TreeNode(aranankisi);

                    for (int i = 2; i < people.size(); i++) {
                        TreeNode foundperson = BreadthFirstSearch.searchParent(people.get(i), personfind);
                        if (foundperson == null) {
                            // System.out.println("Not found " + people.get(i).getIsim());
                        } else {
                            foundperson.addChild(people.get(i));
                            //System.out.println("Added " + people.get(i).getIsim());
                        }
                    }
                    DepthFirstSearch dfs=new DepthFirstSearch();
                    dfs.Dugumler(personfind,people.size());
                    System.out.println("----------Tree----------");
                    TreeNode.printNAryTree(personfind);
                }
            }
            

            break;
        case 8:
            System.out.println("Nesil sayisi: "+depth);
            break;
        case 9:
            System.out.println("İsim ve Soyisim giriniz");
            Scanner scanner2=new Scanner(System.in);
            String find=scanner2.nextLine();
            int say=0;
            for (Kisi search:people) {
                if((search.getIsim()+" "+search.getSoyisim()).equals(find)){
                    TreeNode root2 = new TreeNode(search);
                    for (int i = say; i < people.size(); i++) {
                        TreeNode foundNodefind= BreadthFirstSearch.searchParent(people.get(i), root2);


                        if (foundNodefind == null) {
                            //System.out.println("Not found " + people.get(i).getIsim());
                        } else {
                            foundNodefind.addChild(people.get(i));
                            //System.out.println("Added " + people.get(i).getIsim());
                        }
//
                    }
                    TreeNode.printNAryTree(root2);
                    int depthfind = Functions.depthOfTree(root2);
                    System.out.println("Kisiden sonra gelen nesil sayisi: "+(depthfind-1));


                }
                say++;
            }
            break;
        case 10:
            //soyağacı çizer
            DepthFirstSearch dfs=new DepthFirstSearch();
            dfs.Dugumler(root,people.size());
            break;
    }
    if(islem==0){
        System.out.println("Cikis yapilmistir");
        break;
    }
}

    }
    }
