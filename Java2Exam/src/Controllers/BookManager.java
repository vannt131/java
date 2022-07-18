/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class BookManager {
    public ArrayList<Book> list;

    public BookManager() {
        list = new ArrayList<Book>();
    }
    public void AddStudent()
    {
        Scanner sc = new Scanner(System.in);
        Book st =  new Book();
        System.out.println("Book ID:");
        st.setBookID(sc.nextLine());
        System.out.println("Book Title:");
        st.setBookTitle(sc.nextLine());
        System.out.println("Author:");
        st.setAuthor(sc.nextLine());
        System.out.println("Price:");
        st.setPrice(sc.nextInt());
        list.add(st);
    }
    
    public void DisplayAll()
    {
        System.out.println("Display all students");
        System.out.println("  Book ID                Book Name                Author        Price");
        for(Book book : list)
        {
            System.out.printf("%9s    ", book.getBookID());
            System.out.printf("%20s     ", book.getBookTitle());
            System.out.printf("%15s     ", book.getAuthor());
            System.out.printf("%5s\n", book.getPrices());
        }
    }
    
    //ghi list sinh viên ra tệp
    public boolean Save(){
        boolean ok;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream("books.dat");
            oos = new ObjectOutputStream(fos);
            
            oos.writeInt(list.size());
            for(int i=0; i<list.size();i++)
            {
                oos.writeObject(list.get(i));
            }
            list.clear();
            System.out.println("Ghi tệp thành công");
            ok=true; 
        } catch (FileNotFoundException ex) {
            System.out.println("Có lỗi mở tệp để ghi!");
            Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
             ok=false;
        }
        catch(Exception e){
            System.out.println("Có lỗi!");
            ok=false;
        }
        finally{
            try{
                if(fos!=null)
                    fos.close();
                if(oos!=null)
                    oos.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        } 
        return ok;
    }
    
    //tải các bản ghi sinh viên từ Student.dat vào list
    public boolean Load()
    {
        boolean ok;
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("books.dat");
            ois = new ObjectInputStream(fis);
            int n = ois.readInt();//đọc số nguyên là số đối tượng đã ghi
            list.clear();
            for(int i=0; i<n;i++)
            {
                Book sv = (Book)ois.readObject();//Phải ép kiểu object về kiểu object khi write
                list.add(sv);
            }
            System.out.println("Tải dữ liệu thành công!");
            ok = true;
        } catch (FileNotFoundException ex) {
            System.out.println("Có lỗi mở tệp để đọc!");
            //Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;    
        }
        catch(Exception e){
            System.out.println("Có lỗi đọc tệp!");
            e.printStackTrace();
            ok = false;
        }
        finally{
            try{
                if(ois!=null)
                    ois.close();
                if(fis!=null)
                    fis.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return ok;
    }
}
