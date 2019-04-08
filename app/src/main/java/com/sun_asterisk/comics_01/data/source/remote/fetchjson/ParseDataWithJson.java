package com.sun_asterisk.comics_01.data.source.remote.fetchjson;

import com.sun_asterisk.comics_01.data.model.Comic;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseDataWithJson {
    private static final int TIME_OUT = 15000;
    private static final String METHOD_GET = "GET";

    static String getJsonFromUrl(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(TIME_OUT);
        httpURLConnection.setReadTimeout(TIME_OUT);
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setRequestMethod(METHOD_GET);
        httpURLConnection.connect();
        if (httpURLConnection.getResponseCode() != HttpURLConnection.HTTP_OK) return null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
        }
        return stringBuffer.toString();
    }

    static List<Comic> parseJsonToComicList(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(Comic.ComicEntry.COMIC_LIST);
            return parseJsonArrayToComicList(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    static List<Comic> parseJsonArrayToComicList(JSONArray jsonArrayComicList) {
        List<Comic> comicList = new ArrayList<>();
        try {
            for (int index = 0; index < jsonArrayComicList.length(); index++) {
                JSONObject comicJson = jsonArrayComicList.getJSONObject(index);
                Comic comic = parseJsonObjectToComic(comicJson);
                comicList.add(comic);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return comicList;
    }

    private static Comic parseJsonObjectToComic(JSONObject jsonObjectComic) {
        Comic comic = new Comic();
        try {
            comic = new Comic.ComicBuilder().id(jsonObjectComic.getInt(Comic.ComicEntry.ID))
                    .name(jsonObjectComic.getString(Comic.ComicEntry.NAME))
                    .otherName(jsonObjectComic.getString(Comic.ComicEntry.OTHER_NAME))
                    .thumbnail(jsonObjectComic.getString(Comic.ComicEntry.THUMBNAIL))
                    .description(jsonObjectComic.getString(Comic.ComicEntry.DESCRIPTION))
                    .dateCreated(jsonObjectComic.getString(Comic.ComicEntry.DATE_CREATED))
                    .build();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return comic;
    }
}
