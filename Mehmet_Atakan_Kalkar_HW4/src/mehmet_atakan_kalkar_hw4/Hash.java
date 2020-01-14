/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mehmet_atakan_kalkar_hw4;


import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.Scanner;




/**
 *
 * @author ataka
 */
public class Hash {
     public static  int SIZE = 100;
     public MyLinkedList<Person>[] persontable = (MyLinkedList<Person>[])new MyLinkedList[SIZE];
     public MyLinkedList<Song>[] songtable = (MyLinkedList<Song>[])new MyLinkedList[SIZE];
     public MyLinkedList[] singertable = (MyLinkedList[])new MyLinkedList[SIZE]; 
  
      public int hashperson(String name) throws UnsupportedEncodingException {
      int hashvalue=0;
      byte[] bytes = name.getBytes("US-ASCII");
      int sum = 0;
      for(int i = 0 ; i < bytes.length ; i++){          //ASCII değerleri bulunup toplanıp hash tablenin sizesine bölünüyor.Key bulunuyor.
          sum = sum + bytes [i];   
      }
      hashvalue=sum%SIZE;
      int control=0;
      
      while(control==0){
      if(persontable[hashvalue]==null){
          control++;
      }
      else{
          
          if(persontable[hashvalue].getNodeData(0).PersonName.equals(name)){
          break;
      }
          
          
          if(hashvalue==persontable.length-1){
          hashvalue=0;
          }
          else{
              hashvalue=hashvalue+1;
          }
      }
      }
      return hashvalue;
    }
      public int hashsong(String name) throws UnsupportedEncodingException {
      int hashvalue=0;
      byte[] bytes = name.getBytes("US-ASCII");
      int sum = 0;
      for(int i = 0 ; i < bytes.length ; i++){          //ASCII değerleri bulunup toplanıp hash tablenin sizesine bölünüyor.Key bulunuyor.
          sum = sum + bytes [i];   
      }
        hashvalue= sum%SIZE;
        int control=0;
      
      while(control==0){
      if(singertable[hashvalue]==null){
          control++;
      }
      else{
          
          if(singertable[hashvalue].getNodeData(0).toString().equals(name)){
          break;
      }
          
          
          if(hashvalue==persontable.length-1){
          hashvalue=0;
          }
          else{
              hashvalue=hashvalue+1;
          }
      }
      }
      return hashvalue;
        
      }
      
      
    public void I(String name) throws UnsupportedEncodingException{ 
        int key = hashperson(name);
        Person people = new Person();
        people.PersonName=name;
          persontable[key] = new MyLinkedList<>();
          MyLinkedList<Person> store = persontable[key];
          store.add(people);

        }
        
        
    
    public void L(String name,String music) throws UnsupportedEncodingException{
        int key = hashperson(name); 
        int key2 = hashsong(music);
        Person people2 = new Person();
        people2.PersonName=name;
        Song songs = new Song();
        songs.SongName=music;
        if(persontable[key]!=null){
            if(songtable[key]==null){
        songtable[key]=new MyLinkedList<>();
            }
        MyLinkedList<Song> songlist = songtable[key];
        songlist.add(songs);
        }
        else{
        System.out.println( name +" is not created so Song cannot be liked");
        }    
        if(singertable[key2]==null){
        singertable[key2]=new MyLinkedList<>();
        }
        MyLinkedList singerlist = singertable[key2];
        if(singertable[key2].getNodeData(0)==null ){
            singerlist.add(songs);
        }
        singerlist.add(people2);
        
        
     
 }
        public void E(String name,String music) throws UnsupportedEncodingException{
            int key = hashperson(name);
            int key2 = hashsong(music);
            int control2 = 0;
            if(persontable[key]!=null){  
            if(songtable[key]!=null){
                for(int j=0 ; j<songtable[key].size();j++){
                    if(songtable[key].getNodeData(j).SongName.equals(music)){
                        control2++;
                        songtable[key].remove(j);
                        System.out.println(name + " doesn't like the "+ music);
                    }
                }
              if(control2==0){
        System.out.println(name+" "+ music + " can not be erased");
        }  
            }
            if(singertable[key2]!=null){
                for(int i = 0; i<singertable[key2].size();i++)
               if(singertable[key2].getNodeData(i).toString().equals(name)){
                   singertable[key2].remove(i);
               }
                
            }
       
       // for( int j = 0 ; j<singertable[key2].size();)
            }
        else{
        System.out.println(name+" "+ music + " can not be erased");    
        }
        

           
}
        public void D(String name) throws UnsupportedEncodingException{
            Person tempy = new Person();
            tempy.PersonName="tempy";
            int key = hashperson(name);
            if(persontable[key]!=null){
                if(songtable[key]!=null){
                    for(int i =0; i<songtable[key].size();i++){
                    int temp=hashsong(songtable[key].getNodeData(i).SongName);
                        for(int j=0; j<singertable[temp].size();j++){
                            if(singertable[temp].getNodeData(j).toString().equals(name)){
                                singertable[temp].remove(j);
                            }
                        }
                    }
                }
                     persontable[key].add(tempy);
                     persontable[key].remove(0);
                     songtable[key].clear();
                    
            }
            else{
                System.out.println(name +" is not in the list");
            }

            
        }
        
        public void P(String name) throws UnsupportedEncodingException{
          //  System.out.println("key"+hashperson(name));
            int key = hashperson(name);
            if(persontable[key]!=null){
            System.out.println(name + " likes");
            for(int i =0; i< songtable[key].size();i++){
            System.out.println(  songtable[key].getNodeData(i).SongName);
            }
            }
            else{
                System.out.println(name + " is not in the list");
            }
        }
        
        public void M(String name) throws UnsupportedEncodingException{
            int key = hashperson(name);
            int key2=0;
          
            MyLinkedList <String> store = new MyLinkedList();    
                int controller=0;
            if(persontable[key]!=null){
                if(songtable[key]!=null){
                    controller++;
                for(int i = 0;i<songtable[key].size();i++){
                   key2 =  hashsong(songtable[key].getNodeData(i).SongName);
                    for(int j = 1 ; j <singertable[key2].size();j++ ){
                        if(!(singertable[key2].getNodeData(j).toString().endsWith(name))){
                        store.add(singertable[key2].getNodeData(j).toString());
                       
                        }
                        
                    }
                }
            }
                else{
                System.out.println(name+" does not like any song");
                }
        }
            else{
                System.out.println("There is no person with name "+ name);
            }
            String temp ;
            int sayac=0;
            if(persontable[key]!=null){
                if(controller!=0){
            System.out.println("Possible friends of "+ name);
                }
           for(int m = 0; m<store.size();m++){  
                 temp = store.getNodeData(m);
                
                 for(int z = 0; z<store.size();z++){
                     if(store.getNodeData(z).equals(temp)){
                         sayac++; 
                     }
                 }
                      if(m!=0){
                         int control = 0;
                          for(int t = 0; t<m ;t++){
                              if(temp.equals(store.getNodeData(t))){
                                 control ++; 
                              }  
                         }
                          if(control==0){
                              System.out.println(temp + " %"+ 100*sayac/songtable[key].size() + " match");
                          }
                      }
                      else{
                 System.out.println(temp + " %"+ 100*sayac/songtable[key].size() + " match");
                      }
                     
                 sayac=0;
                 
            }
        }
        }
        public void R(String name) throws UnsupportedEncodingException{
             int key = hashperson(name);
            int key2=0;
            int key3 = 0;
          
            MyLinkedList <String> store = new MyLinkedList();
            MyLinkedList <String> store2 = new MyLinkedList();
                int controller=0;
                
            if(persontable[key]!=null){
                if(songtable[key]!=null){
                    controller++;
                for(int i = 0;i<songtable[key].size();i++){
                   key2 =  hashsong(songtable[key].getNodeData(i).SongName);
                    for(int j = 1 ; j <singertable[key2].size();j++ ){
                        if(!(singertable[key2].getNodeData(j).toString().equals(name))){
                        store.add(singertable[key2].getNodeData(j).toString());
                       
                        }
                        
                    }
                }
            }
                else{
                System.out.println(name+" has no match with other people, system can not recommend any song");
                }
        }
            else{
                System.out.println("There is no person with name "+ name);
            }
            String temp;
            for(int i = 0; i<store.size();i++){
                key3=hashperson(store.getNodeData(i));
                for(int j = 0 ;j<songtable[key3].size();j++){
                    temp=songtable[key3].getNodeData(j).SongName;
                    int control=0;
                    int control2=0;
                    for(int m=0;m<songtable[key].size();m++){
                        if(songtable[key].getNodeData(m).SongName.equals(temp)){
                            control++;
                        }
                    }
                    if(control==0){
                        if(store2!=null){
                        for(int b=0;b<store2.size();b++){
                            if(store2.getNodeData(b).equals(temp)){
                             control2++;   
                            }
                        }
                        if(control2==0){
                     store2.add(temp);
                        }
                    }
                    }
                }
            }
            if(controller!=0){
                
            System.out.println(name + ""
                    + "'s possible friends likes "  );
            for(int t = 0;t<store2.size();t++){
                System.out.println( store2.getNodeData(t) );
            }
        }
        }
        public void O(String FileName) throws FileNotFoundException, IOException{
            File direction = new File(FileName);
           Scanner atk = new Scanner(direction);
            String str ;
            while(atk.hasNextLine()){
            str=atk.nextLine();
            String[] str2 = str.split(" ");
           if(str2[0].equals("I")){
                I(str2[1]);
           }
           else if(str2[0].equals("L")){
               String temp ="";
               for(int i = 2; i<str2.length;i++){
                   if(i!=str2.length-1){
                   temp+= str2[i]+" ";
                   }
                   else{
                       temp=temp+str2[i];
                   }
               }
                   L(str2[1],temp);
           
           }
           else if(str2[0].equals("E")){
               String temp ="";
               for(int i = 2; i<str2.length;i++){
                   if(i!=str2.length-1){
                   temp=temp + str2[i]+" ";
                   }
                   else{
                       temp=temp+str2[i];
                   }
                  
           }
                E(str2[1],temp);
           }
           else if(str2[0].equals("D")){
                D(str2[1]);
           }
           else if(str2[0].equals("P")){
                P(str2[1]);
           }
           else if(str2[0].equals("M")){
                M(str2[1]);
           }
           else if(str2[0].equals("R")){
                R(str2[1]);
           }
           else if(str2[0].equals("X") || str2[0].equals("x")){
                  break;
              }
            }
            
        }
        public void menu() throws UnsupportedEncodingException, IOException{
            String txt="";
            
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter your commands");
            while(true){
              txt = scan.nextLine();             
              String[] str2 = txt.split(" ");
              if(str2[0].equals("X") || str2[0].equals("x")){
                  break;
              }
              else if(str2[0].equals("I")){
                  I(str2[1]);
              }
              else if(str2[0].equals("L")){
               String temp ="";
               for(int i = 2; i<str2.length;i++){
                   if(i!=str2.length-1){
                   temp+= str2[i]+" ";
                   }
                   else{
                       temp=temp+str2[i];
                   }
               }
                   L(str2[1],temp);
           
           }
             else if(str2[0].equals("E")){
               String temp ="";
               for(int i = 2; i<str2.length;i++){
                   if(i!=str2.length-1){
                   temp=temp + str2[i]+" ";
                   }
                   else{
                       temp=temp+str2[i];
                   }
                  
           }
                E(str2[1],temp);
           }
             else if(str2[0].equals("D")){
                D(str2[1]);
           }
             else if(str2[0].equals("P")){
                P(str2[1]);
           }
             else if(str2[0].equals("M")){
                M(str2[1]);
           }
             else if(str2[0].equals("R")){
                R(str2[1]);
           }
             else if(str2[0].equals("O")){
                O(str2[1]);
           }
            
        }
}
      

}

