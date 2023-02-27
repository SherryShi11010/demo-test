package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.exception.TimeoutException;
import lombok.SneakyThrows;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}


	static void aa() throws Exception {
		try {
			throw new TimeoutException("超时");
		} catch (Exception e) {
//			throw new RuntimeException(e);
			throw new Exception(e);

		}

	}

	static void aa1() {
		try {
			aa();
		} catch (Exception e) {
//			throw new RuntimeException("超时");
//			throw e;
		}

	}

	static void exceptionInLam() {
		List<Integer> list = new ArrayList<>();
		Collections.addAll(list, 1, 2, 3, 4);
		list.stream().forEach(new Consumer<Integer>() {
			@SneakyThrows
			@Override
			public void accept(Integer integer) {
				try {
					aa();
				} catch (Exception e) {
					throw e;
				}

			}
		});
	}
//	static void exceptionInLam2(){
//		List<Integer> list = new ArrayList<>();
//		Collections.addAll(list,1,2,3,4);
//		list.stream().forEach(integer -> {throw new Exception("测试");});
//	}


	public static void main(String[] args) {
//		try {
//			aa();
//		} catch (Exception e) {
//			System.out.println( e instanceof TimeoutException);
//		}
		//map流的测试
//		testMapStream();
//		test();


		Product prod1 = new Product(1L, 1, new BigDecimal("15.5"), "面包", "零食");
		Product prod2 = new Product(2L, 2, new BigDecimal("20"), "饼干", "零食");
		Product prod3 = new Product(3L, 3, new BigDecimal("30"), "月饼", "零食");
		Product prod4 = new Product(4L, 3, new BigDecimal("10"), "青岛啤酒", "啤酒");
		Product prod5 = new Product(5L, 10, new BigDecimal("15"), "百威啤酒", "啤酒");
//		List<Product> prodList = Lists.newArrayList(prod1, prod2, prod3, prod4, prod5);
		List<Product> prodList = Lists.newArrayList();
		Collections.addAll(prodList,prod1, prod2, prod3, prod4, prod5);
		System.out.println(prodList.toString());
//		//按类目分组
//		Map<String, List<Product>> prodMap= prodList.stream().collect(Collectors.groupingBy(Product::getCategory));
//		System.out.println(prodMap);

		Integer collect = prodList.stream().map(Product::getNum).collect(Collectors.reducing(0, new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer identity, Integer integer2) {
				return identity + integer2;
			}
		}));
		System.out.println(collect);

//
//
//		//按照拼接字段分组
//		Map<String, List<Product>> prodMap2 = prodList.stream().collect(Collectors.groupingBy(item -> item.getCategory() + "_" + item.getName()));
//		System.out.println(prodMap2);
//
//		//按照不同的条件分组
//		Map<String, List<Product>> prodMap3= prodList.stream().collect(Collectors.groupingBy(item -> {
//			if(item.getNum() < 3) {
//				return "3";
//			}else {
//				return "other";
//			}
//		}));
//		System.out.println(prodMap3);
//
//		//多级分组
//		Map<String, Map<String, List<Product>>> prodMap4= prodList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.groupingBy(item -> {
//			if(item.getNum() < 3) {
//				return "3";
//			}else {
//				return "other";
//			}
//		})));
//		System.out.println(prodMap4);














	}
	public static class Product{
		Long id;
		Integer num;
		BigDecimal price;
		String name;
		String category;

		@Override
		public String toString() {
			return "Product{" +
					"id=" + id +
					", num=" + num +
					", price=" + price +
					", name='" + name + '\'' +
					", category='" + category + '\'' +
					'}';
		}

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
	}
	static void reduce() {
		int[] arr={1,2,3};

		int result=0;

		for (int i : arr) {
			result=result+i;
		}



//		System.out.println(keysArr);

//		public static void main(String[] args) {
//			exceptionInLam();
//
//	}

	}



	static void testJson() {
		JSONObject json = new JSONObject();
		json.put("name", "sherry");
		json.put("name", 1);
//		System.out.println(json);

		JSONObject json2 = new JSONObject();
		json2.put("家庭", "湖南");
		StringBuilder sb = new StringBuilder();
		sb.append(json).append(json2);
		System.out.println(sb);
	}

	static void testMapStream() {
		ConcurrentHashMap<String, List<String>> map = new ConcurrentHashMap();
		List<String> list1 = new ArrayList<>();
		Collections.addAll(list1, "石雨婷", "简爱", "梅尼");
		List<String> list2 = new ArrayList<>();
		Collections.addAll(list2, "湖南", "河南", "山东");
		map.put("name", list1);
		map.put("city", list2);
		ConcurrentHashMap<String, String> mapString = new ConcurrentHashMap();
		map.forEachKey(2, new Consumer<String>() {
			@Override
			public void accept(String key) {
				String value = map.get(key).stream().reduce(new BinaryOperator<String>() {
					@Override
					public String apply(String s, String s2) {
						if (s.compareTo(s2) < 0)
							return s;
						else
							return s2;


					}
				}).get();
				mapString.put(key, value);
			}
		});


		System.out.println(mapString.toString());
	}

	static void test() {
		AtomicInteger atom = new AtomicInteger(0);
		String ruleSplit = ",";
		Set<String> keys = new HashSet<>();
		keys.add("brand");
		keys.add("category");
		keys.add("price");
		keys.add("number");
		List<String[]> keysArr = keys.stream().map(key -> {
			String[] splits = key.split(ruleSplit);
			int length = splits.length;
			int max = atom.get();
			if (max < length) atom.set(length);
			//新建跟key同样长度的字符串
			String[] arr = new String[length];
			for (int i = 0; i < length; i++) {
				String str = "";
				for (int j = 0; j < i + 1; j++) {
					if (j < i)
						str = str + splits[j] + ruleSplit;
					else
						str = str + splits[j];
				}
				arr[i] = str;
			}
			return arr;
		}).collect(Collectors.toList());
		Iterator<String[]> iterator = keysArr.iterator();

		while (iterator.hasNext()) {
			String[] next = iterator.next();
			System.out.println(Arrays.toString(next));

		}

//		System.out.println(keysArr);

//		public static void main(String[] args) {
//			exceptionInLam();
//
//	}

	}
}
