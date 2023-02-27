package com.example.jsonObject;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.math3.stat.inference.GTest;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class parseJson {

    void jsonParse() {

        //定义json object被解析的数据
        JSONObject object = new JSONObject();
        //拿到所有的key
        Set<String> keys = object.keySet();
        //放目标数据的地方--listMap也相当于json,展平的json
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        list.add(map);
        //目标数据的key
        Set<String> lastKeys =null;

        keys.forEach(key ->{

            Object value = object.get(key);

            //判断value有没有包裹
            if (value!=null && lastKeys.contains(key)){
//                map.put(key,value);


            }else if(value instanceof JSONArray){
                ((JSONArray)value).forEach(
                        j ->{
                            JSONObject a = (JSONObject) j;
                            Set<String> strings = a.keySet();
                            strings.forEach(
                                    s -> {

                                    }
                            );

                        }


                );


            }

        });


    }

//    public static void main(String[] args) {
////        List<Integer> num = Lists.newArrayList();
////        num.add(2);
////        num.stream().filter(integer -> integer>0).forEach(new Consumer<Integer>() {
////            @Override
////            public void accept(Integer integer) {
////                System.out.println(integer);
////            }
////        });
////
////        String[] process = "1,2,3".split(",");
////        List<Integer> collect = new ArrayList<>();
////
////
////
////
////        System.out.println(collect);
////
////    stringToJson();
////        Map<String, String> map = Collections.singletonMap("name", "sherry");
////        map.put("city","beijign");
////        System.out.println(map);
//        StringBuilder result = new StringBuilder();
//        String ip = "http://10.122.36.9:8086/connectors";
//        String[] split = ip.split("/");
//        String s = result.append(split[0]).append(split[1]).append(split[2]).toString();
//        System.out.println(s);
//
//    }

    private static void stringToJson() {
        String s = "{\n" +
                "  \"id\": 1001,\n" +
                "  \"type\": \"site\",\n" +
                "  \"name\": \"Runoob\",\n" +
                "  \"description\": \"https://www.runoob.com\",\n" +
                "  \"price\": 2.55,\n" +
                "  \"available\": {\n" +
                "    store: 42,\n" +
                "    likes: 600\n" +
                "  },\n" +
                "  \"toppings\": [\n" +
                "    { \"id\": 5001, \"type\": \"A\" },\n" +
                "    { \"id\": 5002, \"type\": \"B\" },\n" +
                "    { \"id\": 5005, \"type\": \"C\" },\n" +
                "    { \"id\": 5003, \"type\": \"D\" },\n" +
                "    { \"id\": 5004, \"type\": \"E\" }\n" +
                "  ],\n" +
                "  \"uuids\": [\n" +
                "    \"826b23ce-2669-4122-981f-3e2e4429159d\",\n" +
                "    \"e32111a0-6a87-49ab-b58f-a01bf8d28ba0\",\n" +
                "    \"c055a894-698e-41c0-b85f-7510a7351d9d\",\n" +
                "  ],\n" +
                "}";


        JSONObject jsonObject = JSONObject.parseObject(s);
        List<Map<String, Object>> tem = new ArrayList<>();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        list.add(map);
        Set<String> keys = jsonObject.keySet();
        keys.forEach(
                key ->{
                    //第一层
                    Object obj = jsonObject.get(key);
                    //判断1
                    if (obj instanceof String){
                        list.forEach(lmap->{lmap.put(key,obj);});
                    }
                    if (obj instanceof JSONArray){
                        JSONArray j =(JSONArray)obj;
                        j.forEach( ja ->{
                            if (ja instanceof JSONObject){
                                JSONObject jaj =(JSONObject)ja;
                                Set<String> strings = jaj.keySet();
                                //处理array的第一个
                                Map<String, Object> arrMap = new HashMap<>();
                                strings.forEach( b->{
                                    arrMap.put(key+","+b,((JSONObject) ja).get(b));
                                });

                                tem.add(arrMap);
                            }
                            list.forEach( lmap->{
                                lmap.put(key,tem);
                            });

                        });

                    }


                }
        );


    }

    public static void main(String[] args) throws IOException {
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> l1 = new ArrayList<>();
        Collections.addAll(l1,"1","2","3","4");
        map.put("sherry",l1);
//
//        Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
//        String key = iterator.next().getKey();
//        Object value = iterator.next().getValue();
//        String[] factoryImplementationNames = StringUtils.commaDelimitedListToStringArray((String)value);
//        System.out.println(factoryImplementationNames);

//        Enumeration urls = new Object().getClass().getClassLoader().getResources("META-INF/spring.factories");
//        System.out.println(urls);

        List<String> rex = map.computeIfAbsent("sherry", new Function<String, List<String>>() {
            @Override
            public List<String> apply(String s) {

                return new ArrayList<>();
            }
        });
        Class parseJsonClass = parseJson.class;



        System.out.println(rex);


        test(2,"sherry",3);

    }

    public static void test(Integer a,Object...args){
        for (int i = 0; i < args.length; i++) {

            System.out.println(args[i].toString());
        }
        Class[] classes = new Class[0];
        Class b = parseJson.class;
        classes[0] = b;
        System.out.println(classes[0]);



    }

}
