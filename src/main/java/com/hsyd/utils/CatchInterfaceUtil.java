package com.hsyd.utils;

import okhttp3.*;

import java.io.IOException;

/**
 * Created by vie1224 on 2017/7/5.
 */
public class CatchInterfaceUtil {

    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
    private static final OkHttpClient client = new OkHttpClient();

    /**
     * post请求
     * @param postBody
     * @param url
     * @return
     * @throws IOException
     */
    public static String catchInterface(String postBody,String url) throws IOException {

        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody))
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!response.isSuccessful()) try {
            throw new IOException("Unexpected code " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.body().string();
    }

}
