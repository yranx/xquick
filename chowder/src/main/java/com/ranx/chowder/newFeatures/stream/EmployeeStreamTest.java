package com.ranx.chowder.newFeatures.stream;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
/**
 * @author ranx
 * @create 2020-02-12 11:44
 **/
public class EmployeeStreamTest extends BaseStreamTest {

    //1.Filter是过滤器，也可当查询用
    @Test
    public void filter() {
        //获取包含Alex员工列表
        List<Employee> emps1 = list.stream().filter(e -> e.getName().contains("Alex")).collect(Collectors.toList());
        assertTrue(null != emps1 && emps1.get(0).getId() == 1);

        //获取包含Jacks名称的首位员工
        Optional<Employee> employeeJackFirst2 =
                list.stream().filter(e -> e.getName().contains("Jack")).findFirst();
        assertEquals(employeeJackFirst2.get().getId(), 3);

        //获取所有薪酬为1500的员工
        List<Employee> emp3 = list.stream().filter(employee -> employee.getSalary() == 1500)
                .peek(System.out::println)
                .collect(Collectors.toList());
        assertEquals(2, emp3.size());
    }

    /**
     * 2. 映射操作
     *  employee -> Leader
     */
    @Test
    public void map() {
        List<Leader> leaders = list.stream().filter(e -> e.getSalary()== 2000)
                .map(emp -> {
                    Leader leader = new Leader();
                    leader.setName(emp.getName());
                    leader.setSalary(emp.getSalary());
                    return leader;
                })
                .peek(System.out::println).collect(Collectors.toList());
    }

    class Leader {
        private String name;
        private double salary;

        public void setName(String name) {
            this.name = name;
        }
        public void setSalary(double salary) {
            this.salary = salary;
        }
    }

    /**
     * 3.将多维嵌套列表转换为单维列表
     */
    @Test
    public void flatMap() {
        List<Employee> employeesAll = listFlat.stream().flatMap(Collection::stream)
                .collect(Collectors.toList());
        assertTrue(employeesAll.size() == 5);

        List<Employee> employeesAll2 = listFlat.stream().flatMap(
                emps -> {
                    Stream<Employee> stream = emps.stream();
                    return stream;
                }
        ).collect(Collectors.toList());
        assertEquals(employeesAll, employeesAll2);

        List<Long> listFlatLong = listFlat.stream().flatMap(employees  -> employees.stream())
                .peek(System.out::println)
                .flatMapToLong(employee -> LongStream.of(employee.getId()))
                .peek(System.out::println)
                .boxed()   //数值流(IntStream、DoubleStream、LongStream)在进行collect操作之前，要使用boxed进行装箱操作
                .collect(Collectors.toList());
        System.out.println(listFlatLong.toString());

        List<Long> listFlatLong2 = listFlat.stream().flatMap(employees  -> employees.stream())
                .peek(System.out::println)
                .mapToLong(Employee::getId)
                .peek(System.out::println)
                .boxed().collect(Collectors.toList());

        List<Double> listFlatName = listFlat.stream().flatMap(employees  -> employees.stream())
                .peek(System.out::println)
                .map(employee -> employee.getSalary())
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    /**
     * 4.排序和反向排序
     */
    @Test
    public void sorted() {
        list.stream().forEach(System.out::println);
        //根据名称排序
        list.stream().sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //根据ID反向排序
        list.stream().sorted(Comparator.comparingLong(Employee::getId)
                .reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     *5. 最小值，最大值，平均值
     */
    @Test
    public void minMaxAverage(){
        Employee employeeMin = list.stream()
                .min(Comparator.comparing(Employee::getSalary)).orElse(null);
        assertEquals("Alex", employeeMin.getName());

        Employee employeeMax = list.stream()
                .max(Comparator.comparing(Employee::getSalary)).orElse(null);
        assertEquals("Michael", employeeMax.getName());

        double dMin = list.stream()
                .mapToDouble(e -> e.getSalary())
                .min().orElse(0.00);
        assertTrue(dMin == 1000);

        double dMax = list.stream()
                .mapToDouble(e -> e.getSalary())
                .max().orElse(0.00);
        assertTrue(dMax == 2000);

        double dAverage = list.stream()
                .mapToDouble(e -> e.getSalary())
                .average().orElse(0.00);
        System.out.println(dAverage);
    }

    /**
     * 6.条件匹配
     */
    @Test
    public void match() {
        //列表中所有元素都匹配我们的条件
        boolean isAllMatch = list.stream()
                .allMatch(e -> e.getSalary() >= 1000);
        assertTrue(isAllMatch);

         //列表中任一元素匹配我们的条件
        boolean isManyMatch = list.stream()
                .anyMatch(e -> e.getSalary() == 1500);
        assertTrue(isManyMatch);

         //列表中没有元素都匹配我们的条件
        boolean isNoneMatch = list.stream()
                .noneMatch(e -> e.getSalary() > 3000);
        assertTrue(isNoneMatch);
    }

    /**
     * 7.去重
     */
    @Test
    public void distinct() {
        //常规实现方式
        List<Employee> empDis = list.stream().distinct().collect(Collectors.toList());
        assertEquals(empDis.size(), 5);

        //StreamEx实现方式
//        List<Employee> empDisBySalary = StreamEx.of(list).distinct(Employee::getSalary)
//                .peek(System.out::println).collect(Collectors.toList());

        //Stream filter实现方式
        List<Employee> empDisBySalary2 = list.stream().filter(distinctByKey(Employee::getSalary)).collect(Collectors.toList());
//        assertEquals(empDisBySalary2, empDisBySalary);
    }
    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    /**
     * 8.collector
     */
    @Test
    public void  collector() {
        //转换成连接字符串
        String strName = list.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(strName);

        //转换成Set集合
        Set<String> setName = list.stream().map(Employee::getName).collect(Collectors.toSet());
        System.out.println(strName);

        //转换成Vector
        Vector<String> vectorName = list.stream().map(Employee::getName).collect(Collectors.toCollection(Vector::new));

        //转换成List
        List<String> listName = list.stream().map(Employee::getName).collect(Collectors.toList());

        //转成Map
        Map<Integer, String> mapName = list.stream().collect(
                Collectors.toMap(employee -> employee.getId(), employee -> employee.getName())
        );

    }

    /**
     * 9.计数器
     */
    @Test
    public void count() {
        long lCount = list.stream().count();
        assertTrue(lCount == 5);

        long lCount2 = list.stream().filter(employee -> employee.getSalary() == 2000).count();
        System.out.println(lCount2);
    }

    /**
     * 10.统计汇总
     */
    @Test
    public  void statis() {
        //实现方式一
        DoubleSummaryStatistics statistics = list.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        //实现方式二
        DoubleSummaryStatistics statistics2 = list.stream().mapToDouble(Employee::getSalary).summaryStatistics();

    }

    /**
     * 11.分割列表
     */
    @Test
    public void partitioningBy() {
        //把工资大于1500放在True，小于或等于1500的放在false列表中
        Map<Boolean, List<Employee>> map = list.stream().collect(Collectors.partitioningBy(
                employee -> {
                    return employee.getSalary() > 1500;
                }
        ));
        System.out.println(map.get(Boolean.TRUE));
        System.out.println(map.get(Boolean.FALSE));
     }

    /**
     * 12.分组
     */
    @Test
    public void groupBy() {
        //根据酬薪获取员工列表
        Map<Double, List<Employee>> map = list.stream().collect(
                Collectors.groupingBy(Employee::getSalary));
        System.out.println(map);

        //根据酬薪获取员工数量
        Map<Double, Long> map2 = list.stream().collect(
                Collectors.groupingBy(Employee::getSalary, Collectors.counting())
        );
        System.out.println(map2);

        //根据薪酬获取员工薪酬总数
        Map<Double, Double> map3 = list.stream().collect(
                Collectors.groupingBy(Employee::getSalary, Collectors.summingDouble(Employee::getSalary))
        );
        System.out.println(map3);
    }

    /**
     * 13.并发
     */
    @Test
    public void parallel() {
        list.stream().parallel().forEach(employee ->  {
            cal(employee);
                }
        );
    }
    private static void cal(Employee employee) {
        try {
            long lTime = Double.valueOf(employee.getSalary()).longValue();
            TimeUnit.MICROSECONDS.sleep(lTime);
            System.out.println(employee.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 14.文件读写
     */
    @Test
    public void writeRead() throws IOException {
        //写入文件
        PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(Paths.get("F://Test.txt")));
        list.stream().forEach(printWriter::println);
        printWriter.close();
        //读取文件
        List<String> content = Files.lines(Paths.get("F://Test.txt"))
                .peek(System.out::println).collect(Collectors.toList());
    }
}
