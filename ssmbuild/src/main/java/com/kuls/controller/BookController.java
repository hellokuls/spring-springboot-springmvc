package com.kuls.controller;

import com.kuls.pojo.Books;
import com.kuls.service.BookService;
import com.kuls.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/27 11:13 上午
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    //查询所有书籍
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = bookService.queryAllBooks();
        model.addAttribute("list",books);
        return "allBook";
    }


    //跳转到添加书籍页面
    @RequestMapping("/toaddBook")
    public String toAddBook(){
        return "addBook";
    }


    //添加书籍
    @RequestMapping("/addBook")
    public String addBook(Books books){

        bookService.addBook(books);

        return "redirect:/book/allBook";
    }


    //跳转到修改书籍页面
    @RequestMapping("/toUpdateAddBook")
    public String toUpdateAddBook(int id,Model model){
        Books book = bookService.queryBookByID(id);
        model.addAttribute("Qbook",book);
        return "updateBook";
    }


    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){

        bookService.updateBook(books);

        return "redirect:/book/allBook";
    }


    //删除书籍
    @RequestMapping("/deleteBook/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id){

        bookService.deleteBook(id);

        return "redirect:/book/allBook";
    }


    //搜索书籍
    @RequestMapping("/searchBook")
    public String searchBook(String queryBookName,Model model){

        Books books = bookService.queryBooksByName(queryBookName);
        List<Books> books1 = new ArrayList<>();
        books1.add(books);
        if (books == null){
            books1 = bookService.queryAllBooks();
            model.addAttribute("error","未查到");
        }

        model.addAttribute("list",books1);

        return "allBook";
    }



}
