package kr.book.search;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KakaoBookApi {
    private static final String API_KEY = "787b075a35b54d260dc2dd13287e1dc1"; // Rest Key
    private static final String API_BASE_URL = "https://dapi.kakao.com/v3/search/book"; // Open API URL
    private static final OkHttpClient okhttpclient = new OkHttpClient();
    private static final Gson gson = new Gson();

    // 책검색 메서드
    public static List<Book> searchBooks(String title) throws IOException {
        HttpUrl.Builder urlbuilder = HttpUrl.parse(API_BASE_URL).newBuilder();
        urlbuilder.addQueryParameter("query", title);

        Request request = new Request.Builder()
                .url(urlbuilder.build())
                .addHeader("Authorization", "KakaoAK " + API_KEY)
                .build();

        try (Response response = okhttpclient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Request failed : " + response);

            JsonObject jsonResponse = gson.fromJson(response.body().charStream(), JsonObject.class);
            JsonArray documents = jsonResponse.getAsJsonArray("documents");

            List<Book> books = new ArrayList<>();
            for (JsonElement document : documents) {
                JsonObject bookJson = document.getAsJsonObject();
                Book book = new Book(
                        bookJson.get("title").getAsString(),
                        bookJson.get("authors").getAsJsonArray().toString(),
                        bookJson.get("publisher").getAsString(),
                        bookJson.get("price").getAsInt(),
                        bookJson.get("sale_price").getAsInt(),
                        bookJson.get("thumbnail").getAsString()
                );
                books.add(book);
            }
        return books;
        }
    }
}