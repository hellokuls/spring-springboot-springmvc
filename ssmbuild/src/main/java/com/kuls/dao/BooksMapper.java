package com.kuls.dao;

import com.kuls.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/27 9:44 上午
 */

public interface BooksMapper {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBook(@Param("bookID") int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookByID(@Param("bookID")int id);

    //查询所有书
    List<Books> queryAllBooks();

    //根据书名查书
    Books queryBooksByName(@Param("bookName") String bookName);
}
