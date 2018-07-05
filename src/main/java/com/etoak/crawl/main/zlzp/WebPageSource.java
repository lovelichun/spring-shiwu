package com.etoak.crawl.main.zlzp;
import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import java.net.URL;

public class WebPageSource {

    public static void getJob(String link){    

        URL url;

        int responsecode;

        HttpURLConnection urlConnection;

        BufferedReader reader;

        String line;

        try{

            //生成一个URL对象，要获取源代码的网页地址为：http://www.sina.com.cn

            url=new URL(link);

            //打开URL

            urlConnection = (HttpURLConnection)url.openConnection();

            //获取服务器响应代码

            responsecode=urlConnection.getResponseCode();
            StringBuffer sb = new StringBuffer();
            if(responsecode==200){

                //得到输入流，即获得了网页的内容

                reader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                while((line=reader.readLine())!=null){

                	sb.append(line);

                }
//                System.out.println(sb.toString());
                System.out.println(sb.toString().split("职位描述")[1].split("工作地址")[0].replaceAll("[<][.*]{0,100}[>]", ""));
                System.out.println("gggg");

            }

            else{

                System.out.println("获取不到网页的源码，服务器响应代码为："+responsecode);

            }

        }

        catch(Exception e){

            System.out.println("获取不到网页的源码,出现异常："+e);

        }

    }
    
    public static void main(String[] args) {
	}

}