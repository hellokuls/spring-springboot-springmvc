package com.kuls.service;

import com.kuls.dao.BooksMapper;
import com.kuls.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/27 10:03 上午
 */
@Service
public class BookServiceImpl implements BookService {

    //service层调dao层
    @Autowired
    private BooksMapper booksMapper;

//    public void setBooksMapper(BooksMapper booksMapper) {
//        this.booksMapper = booksMapper;
//    }

    public int addBook(Books books) {
        return booksMapper.addBook(books);
    }

    public int deleteBook(int id) {
        return booksMapper.deleteBook(id);
    }

    public int updateBook(Books books) {
        return booksMapper.updateBook(books);
    }

    public Books queryBookByID(int id) {
        return booksMapper.queryBookByID(id);
    }

    public List<Books> queryAllBooks() {
        return booksMapper.queryAllBooks();
    }

    @Override
    public Books queryBooksByName(String bookName) {
        return booksMapper.queryBooksByName(bookName);
    }
}
