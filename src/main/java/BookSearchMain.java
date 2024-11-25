import kr.book.search.Book;
import kr.book.search.KakaoBookApi;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BookSearchMain {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("도서 제목을 입력하세요");
            String bookName = sc.nextLine();
            List<Book> bookList = KakaoBookApi.searchBooks(bookName);

            if (bookList.isEmpty()) {
                System.out.println("검색 결과가 없습니다");
            } else {
                for (Book book : bookList) {
                    System.out.println(book);
                }
//                String fileName = "도서목록.pdf";
//                PdfGenerator.generateBookListPdf(books, fileName);
//                System.out.println(fileName + " 파일이 생성되었습니다");
            }
        }catch (IOException e) {
            System.out.println("에러가 발생하었습니다" + e.getMessage());
        }
    }
}