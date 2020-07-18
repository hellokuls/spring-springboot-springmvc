package com.kuls.service;

import com.kuls.pojo.Books;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/27 10:02 上午
 */

public interface BookService {

    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBook( int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookByID(int id);

    //查询所有书
    List<Books> queryAllBooks();

    //根据书名查书
    Books queryBooksByName(String bookName);
}
