package com.spring.springFactory;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SpringFactoriesLoaderDemo {
    static final Map<ClassLoader,Map<String,List<String>>> cache = new ConcurrentHashMap<>();

    private static Map<String, List<String>> loadSpringFactories(ClassLoader classLoader) throws IOException {
        //根据classloader获取
        Map<String, List<String>> result = cache.get(classLoader);

        if (result != null) {
            return result;
        } else {
            result = new HashMap<>();

            Enumeration<URL> urls = classLoader.getResources("META-INF/spring.factories");
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                UrlResource resource = new UrlResource(url);
                Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                //读取数据
//                InputStream is = resource.getInputStream();
//                String filename = resource.getFilename();
                Iterator<Map.Entry<Object, Object>> var6 = properties.entrySet().iterator();

                while (var6.hasNext()){
                    Map.Entry<?, ?> entry = var6.next();
                    String factoryTypeName = ((String)entry.getKey()).trim();




                }


            }



        }return null;




    }

    public static void main(String[] args) {
        Map<Integer,Map<String,List<String>>> cache = new ConcurrentHashMap<>();
        Iterator<Integer> iterator = cache.keySet().iterator();
        Map<String, List<String>> ressult = cache.get(iterator.next());
        Iterator<Map.Entry<String, List<String>>> iterator1 = ressult.entrySet().iterator();


    }

//    private static Map<String, List<String>> loadSpringFactories1(ClassLoader classLoader) {
//        Map<String, List<String>> result = (Map)cache.get(classLoader);
//        if (result != null) {
//            return result;
//        } else {
//            HashMap result = new HashMap();
//
//            try {
//                Enumeration urls = classLoader.getResources("META-INF/spring.factories");
//
//                while(urls.hasMoreElements()) {
//                    URL url = (URL)urls.nextElement();
//                    UrlResource resource = new UrlResource(url);
//                    Properties properties = PropertiesLoaderUtils.loadProperties(resource);
//                    Iterator var6 = properties.entrySet().iterator();
//
//                    while(var6.hasNext()) {
//                        Map.Entry<?, ?> entry = (Map.Entry)var6.next();
//                        String factoryTypeName = ((String)entry.getKey()).trim();
//                        String[] factoryImplementationNames = StringUtils.commaDelimitedListToStringArray((String)entry.getValue());
//                        String[] var10 = factoryImplementationNames;
//                        int var11 = factoryImplementationNames.length;
//
//                        for(int var12 = 0; var12 < var11; ++var12) {
//                            String factoryImplementationName = var10[var12];
//                            ((List)result.computeIfAbsent(factoryTypeName, (key) -> {
//                                return new ArrayList();
//                            })).add(factoryImplementationName.trim());
//                        }
//                    }
//                }
//
//                result.replaceAll((factoryType, implementations) -> {
//                    return (List)implementations.stream().distinct().collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
//                });
//                cache.put(classLoader, result);
//                return result;
//            } catch (IOException var14) {
//                throw new IllegalArgumentException("Unable to load factories from location [META-INF/spring.factories]", var14);
//            }
//        }
//    }

}
