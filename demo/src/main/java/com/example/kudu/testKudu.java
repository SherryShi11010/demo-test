package com.example.kudu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser;
import lombok.SneakyThrows;
import org.apache.kudu.client.KuduClient;
import org.apache.kudu.client.KuduClient.KuduClientBuilder;
import org.apache.poi.hssf.record.DVALRecord;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class testKudu {
    final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static String data = "{\"projectId\":1,\"connectorType\":\"hive\",\"connectorName\":\"ludp-hive_default2-copy1\",\"type\":0,\"info\":[{\"path\":\"/user/jinwm1/user\",\"mapping\":\"1\",\"parseRulesList\":[{\"func\":\"DEFAULT\",\"column\":\"label\",\"key\":\"modeOfTrspn\"}],\"processId\":\"0\",\"delimiter\":\"_\",\"tableName\":\"aaa1226.connect_test\"},{\"path\":\"/user/jinwm1/user\",\"mapping\":\"1\",\"parseRulesList\":[{\"func\":\"DEFAULT\",\"column\":\"brand\",\"key\":\"modeOfTrspn\"}],\"processId\":\"0\",\"delimiter\":\"_\",\"tableName\":\"aaa1226.hive_table5\"},{\"path\":\"/user/jinwm1/user\",\"mapping\":\"1\",\"parseRulesList\":[{\"func\":\"DEFAULT\",\"column\":\"abc\",\"key\":\"dlvrdQty\"},{\"func\":\"DEFAULT\",\"column\":\"id\",\"key\":\"podEntryDate\"}],\"processId\":\"0\",\"delimiter\":\"_\",\"tableName\":\"aaa1226.new_kudu_test\"},{\"path\":\"/user/jinwm1/user\",\"mapping\":\"3\",\"parseRulesList\":[{\"func\":\"DEFAULT\",\"column\":\"dopackagesreservedfield10\",\"key\":\"doPackages_reservedField10\"},{\"func\":\"DEFAULT\",\"column\":\"associateddepartureairportlocation\",\"key\":\"associated_departureAirportLocation\"},{\"func\":\"DEFAULT\",\"column\":\"doitemmaterialgroup1desc\",\"key\":\"doItem_materialGroup1Desc\"},{\"func\":\"DEFAULT\",\"column\":\"huunitofdimension\",\"key\":\"hu_unitOfDimension\"},{\"func\":\"DEFAULT\",\"column\":\"reservedfield1\",\"key\":\"reservedField1\"}],\"processId\":\"0\",\"delimiter\":\"_\",\"tableName\":\"c.fandl_test\"},{\"path\":\"/stream/add\",\"mapping\":\"1\",\"parseRulesList\":[{\"func\":\"DEFAULT\",\"column\":\"ma_last_update_date\",\"key\":\"modeOfTrspn\"}],\"processId\":\"0\",\"delimiter\":\"_\",\"tableName\":\"wqz.connect_test\"}]}";

    public static void main(String[] args) throws InterruptedException {
//        testExceptionInWhile();
//        testDate();
//        testSystemMillis();
        stream();
//        testJson();

    }
    public static void testJson()
    {
        JSONObject jsonObject = new JSONObject();
        JSONObject parse = (JSONObject)JSON.parse(data);
        System.out.println(jsonObject);
//        JSON.pa


    }

    @SneakyThrows
    static void testExceptionInWhile() {
        while (true) {
            throw new Exception("异常");

        }
    }

    static void testDate() {
//        long retryTime = System.currentTimeMillis();
//
//        Date retryDate = new Date(retryTime);
//        String format = simpleDateFormat.format(retryDate);
//        System.out.println(format);

        long hourTime = 30 * 60 * 1000;
        long minutes = hourTime / 1000 / 60;
        System.out.println(minutes);


    }

    //测试
    static void testSystemMillis() throws InterruptedException {
        long begins = System.currentTimeMillis();
        Thread.sleep(2000);
        Long i = begins - System.currentTimeMillis();

        System.out.println(i);


    }

    static void stream() {
        Product prod1 = new Product(1L, 1, new BigDecimal("15.5"), "面包", "零食");
        Product prod2 = new Product(2L, 2, new BigDecimal("20"), "饼干", "零食");
        Product prod3 = new Product(3L, 3, new BigDecimal("30"), "月饼", "零食");
        Product prod4 = new Product(4L, 3, new BigDecimal("10"), "青岛啤酒", "啤酒");
        Product prod5 = new Product(5L, 10, new BigDecimal("15"), "百威啤酒", "啤酒");
        Product prod6 = new Product(5L, 7, new BigDecimal("25"), "百威啤酒", "啤酒");

        List<Product> prodList = Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6);
        Map<String, List<Product>> collect = prodList.stream().collect(Collectors.groupingBy(Product::getName));
//
//        HashMap<String, String> map = new HashMap<>();
//        map.put("name","sherry");
//        map.put("city","NewYork");
//        Set<Map.Entry<String, String>> entries = map.entrySet();
//        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
//        if (iterator.hasNext()) {
//            Map.Entry<String, String> next = iterator.next();
//            String key = next.getKey();
//            System.out.println(key+next.getValue());
//        }
        String[] var = "青岛".split(",");
        for (String s : var) {
            System.out.println(s);
        }


    }


    private static class Product {
        Long id;
        Integer num;
        BigDecimal price;
        String name;

        public Product(Long id, Integer num, BigDecimal price, String name, String category) {
            this.id = id;
            this.num = num;
            this.price = price;
            this.name = name;
            this.category = category;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        String category;




    }


}
