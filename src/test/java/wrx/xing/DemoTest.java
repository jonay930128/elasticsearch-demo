package wrx.xing;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import wrx.xing.move.Student;
import wrx.xing.util.JsonUtil;

import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-05-28 12:02
 */
public class DemoTest {
    @Test
    public void test1() {
        try {
            test2();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String test2() throws Exception {
        throw new Exception("dljl");
    }

    @Test
    public void test3() throws Exception {
        DepartmentMq mq = new DepartmentMq();
        mq.setDepartLevel(2);
        mq.setDepartName("test");
        mq.setDirectParentId(234L);
        mq.setDirectParentName("test2");
        mq.setHaveChildDepart(true);
        mq.setGrandpaDepartId(342L);
        mq.setGrandpaDepartName("test3");
        mq.setType(3);
        mq.setId(23423L);
        List<Long> list = new ArrayList<Long>() {{
            add(234L);
            add(456L);
            add(789L);
        }};
        mq.setDocIds(list);
        System.out.println(JsonUtil.objToJson(mq));
    }

    @Test
    public void test4() {
        DepartmentMq mq = new DepartmentMq();
        mq.setDepartLevel(2);
        mq.setDepartName("test");
        mq.setId(23423L);
        List<DepartmentMq> l1 = new ArrayList<>();
        l1.add(mq);
        l1.add(mq);
        l1.add(mq);

        List<DepartmentMq> l2 = new ArrayList<>();
        l2.add(mq);
        l2.add(mq);

        for (DepartmentMq m2 : l2) {
            Integer level = m2.getDepartLevel();
            Long id = m2.getId();
            for (DepartmentMq m1 : l1) {
                if (Objects.equals(level, m1.getDepartLevel()) && Objects.equals(id, m2.getId())) {
                    l1.remove(m1);
                    break;
                }
            }
        }
        for (DepartmentMq departmentMq : l1) {
            System.out.println(departmentMq);
        }
    }

    @Test
    public void test5() {
        List<DepartmentMq> list = new ArrayList<>();
        list.add(new DepartmentMq("1"));
        list.add(new DepartmentMq("2"));
        list.add(new DepartmentMq("3"));

        for (DepartmentMq mq : list) {
            mq(Arrays.asList(mq));
            System.out.println(mq);
        }
    }

    public void mq(List<DepartmentMq> list) {
        for (DepartmentMq mq : list) {
            mq.setDepartName("w");
        }
    }

    public static DepartmentMq getMq() {
        DepartmentMq mq = null;
        try {
            mq = new DepartmentMq();
            mq.setDepartName("1");
            return mq;
        } finally {
            mq = new DepartmentMq();
            mq.setDepartName("2");
            return mq;
        }
    }

    @Test
    public void test6() {
        Date now = new Date();
        Date date = addDays(now, -1);
        Date date2 = addDays(now, -2);
        Date date3 = addDays(now, -3);
        List<Date> list = Arrays.asList(date, date2, date3);
        System.out.println(date.equals(list.get(0)));
        System.out.println(date.toString());
    }

    public static Date addDays(Date d, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.MONTH, days);
        Date newD = c.getTime();
        return newD;
    }

    @Test
    public void test7() {
        System.out.println(new ArrayList<Integer>(1) {{
            add(1);
        }});
    }

    @Test
    public void test8() {
        long maxMemory = Runtime.getRuntime().maxMemory();//返回 Java 虚拟机试图使用的最大内存量。
        long totalMemory = Runtime.getRuntime().totalMemory();//返回 Java 虚拟机中的内存总量。
        System.out.println("MAX_MEMORY = " + maxMemory + "（字节）、" + (maxMemory / (double) 1024 / 1024) + "MB");
        System.out.println("TOTAL_MEMORY = " + totalMemory + "（字节）、" + (totalMemory / (double) 1024 / 1024) + "MB");

    }

    @Test
    public void test9() {
        String s = HttpMD5.MD5Encode(HttpMD5.MD5Encode("193010234809", "utf-8"), "utf-8");
        System.out.println(s);
    }

    @Test
    public void test10() {
        LocalDate today = LocalDate.now();
        LocalDate specifyDate = LocalDate.of(2015, 10, 20);
        LocalDate specifyDate2 = LocalDate.of(2015, 10, 20);
        System.out.println(specifyDate2.isAfter(specifyDate));

        LocalDateTime rightNow = LocalDateTime.now();
        String date = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(rightNow);
        System.out.println(date);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        System.out.println(formatter.format(rightNow));
    }

    int num = 0;

    public Integer getNum() {
        if (num > 5) {
            return num;
        }
        num++;
        return getNum();
    }

    @Test
    public void recursion() {
        System.out.println(getNum());
    }

    @Test
    public void intern() {

        String[] pinArr = {"aizhiquan521","jd_6a0f8e2040826","jd_7d218caad4aa3","方培炫","jd_554142f96bbfd", "sequin7299"};
        for (String pin : pinArr) {
            System.out.println(pin.hashCode() % 1000);
        }

    }

    @Test
    public void stringFormat() throws Exception {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            list.add(i);
        }
        List<List<Integer>> lists = splitList(list, 5);
        System.out.println(1);

    }

    /**
     * 切分List list：原始数据 oneSize：单次数量
     * @param list
     * @param oneSize
     * @param <T>
     * @return
     */
    public static  <T> List<List<T>> splitList(List<T> list, int pageSize) {
        int size = list.size();
        int pageNo = size % pageSize == 0 ? size / pageSize : size / pageSize + 1;

        List<List<T>> ll = new ArrayList<>();
        for (int i = 0; i < pageNo; i++) {
            List il = new ArrayList<>();
            int end = (i + 1) * pageSize > size ? size : (i + 1) * pageSize;
            for (int j = pageSize * i; j < end; j++) {
                il.add(list.get(j));
            }
            ll.add(il);
        }

        return ll;
    }

    @Test
    public void treeMap(){
        Map<String,Integer> map = new HashMap<>(8);
        map.put("a",3);
        map.put("b",6);
        map.put("c",2);
        map.put("d",1);

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return Integer.compare(o1.getValue(),o2.getValue());
            }
        });

       /* map.forEach((k,v) -> {
            System.out.println(k + "--------" + v);
        });*/

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + "--------" + entry.getValue());
        }
    }

    @Test
    public void testRandom(){
        Set<String> citySet = new HashSet<>();
        List<String> hotCityList = Arrays.asList("df","k","f","s","wer","sdf","mcbn","puw","wq");
        System.out.println(fillCity(citySet,hotCityList));

    }

    private String fillCity(Set<String> citySet,List<String> hotCityList){
        if (citySet.size() < 9) {
            Collections.shuffle(hotCityList);
            for (String city : hotCityList) {
                citySet.add(city);
                if (citySet.size() == 9){
                    break;
                }
            }
        }
        Object[] array = citySet.toArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            sb.append(array[i]).append("、");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (true) {
            str = sc.next();
            str = str.replace("吗","");
            str = str.replace("?","!");
            System.out.println(str);
        }
    }


    @Test
    public void testMath() throws Exception {
		Class<?> clz = Integer.class;
//		Object integer = clz.newInstance();
		System.out.println(clz.getName());
		System.out.println(Collection.class.isAssignableFrom(clz));
		System.out.println(Map.class.isAssignableFrom(clz));
		System.out.println(Date.class.isAssignableFrom(clz));
		System.out.println(clz.isArray());
		System.out.println(clz.isPrimitive());

		Constructor<?>[] declaredConstructors = clz.getDeclaredConstructors();
//		Constructor<?> declaredConstructor = clz.getDeclaredConstructor();
		System.out.println(declaredConstructors);
//		System.out.println(declaredConstructor);
	}

	@Test
	public void testString(){
		Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
		map.put("a",Arrays.asList(1,2,3));
		List<Integer> a = map.get("a");
		List<Integer> a2 = map.get("a");
		ArrayList<Integer> newList = new ArrayList<>(a);
		map.clear();
		System.out.println(a);
		System.out.println(a2);
		System.out.println(newList);
	}

	@Test
	public void testString2(){
    	Long a = 1345637890151L;
		System.out.println(Math.abs(a.hashCode() ));
		System.out.println(10 % 1000);
	}



}



