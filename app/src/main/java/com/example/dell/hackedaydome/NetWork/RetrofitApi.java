package com.example.dell.hackedaydome.NetWork;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

/**
 * Created by dell on 2016/10/29.
 */

public class RetrofitApi {
    public static final String BASE_URL = "https://pets.hustonline.net";
    private static RestAdapter restAdapter;
    private static HackDayService service;

    public interface HackDayService{

    }

    static {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setErrorHandler(new ErrorHandler() {
                    @Override
                    public Throwable handleError(RetrofitError cause) {
                        Response r = cause.getResponse();
                        if (r != null && r.getStatus() == 401) {

                        }
                        return cause;
                    }
                })
                .setConverter(new Converter() {

                    @Override
                    public Object fromBody(TypedInput body, Type type) throws ConversionException {
                        BufferedReader reader = null;

                        try {
                            reader = new BufferedReader(new InputStreamReader(body.in()));
                            StringBuilder builder = new StringBuilder();
                            String line;
                            while (null != (line = reader.readLine())) {
                                builder.append(line);
                            }
                            //String resultStr = Protocol.parseResponse(builder.toString());
                            Log.e("test",builder.toString());
                            Gson gson = new GsonBuilder().create();
                            ApiResult result = gson.fromJson(builder.toString(), type);

                            Log.e("testResult",result.toString());
                            //if (result.getCode() != 0 && result.getMsg_show() == 1) {
                            if (result.getCode() != 0 ) {
                                //ToastUtil.showLongToast(result.getMsg());
                            }
                            return result;

                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            if (reader != null) {
                                try {
                                    reader.close();
                                } catch (IOException ignored) {
                                }
                            }
                        }
                        return null;
                    }

                    @Override
                    public TypedOutput toBody(Object object) {
                        return null;
                    }
                })
                .build();

        service = restAdapter.create(HackDayService.class);
    }
}
