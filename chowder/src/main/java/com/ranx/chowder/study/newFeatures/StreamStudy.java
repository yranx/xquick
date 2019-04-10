package com.ranx.chowder.study.newFeatures;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** 流
 * 流的来源。 可以是集合，数组，I/O channel， 产生器generator 等。
 * @author ranx
 * @create 2019-04-10 9:07
 **/
public class StreamStudy {
    /**
     * 流的两种生成方式：
     */
    //方式一：Stream自己创建
    public static void generateUuid() {
        //使用generate方法生成Stream流
        Stream<String> uuidStream = Stream.generate( () -> UUID.randomUUID().toString());
        uuidStream.forEach(System.out::println);
        //使用of方法生成Stream流
        Stream<String> of = Stream.of(UUID.randomUUID().toString());
        of.forEach(System.out::println);
    }
    //方式二：从集合生成
    public static Stream<Integer> generateStream(List<Integer> list) {
        Stream<Integer> stream = list.stream();
        return stream;
    }


    /**
     * 过滤filter： 对Stram中的元素进行特定条件的过滤，相当于sql中的where后面的判定条件
     * 排序sorted： 相当于Sql中的order by
     * 去重distinct
     * 限制limit: 限制结果集大小
     * 跳过skip: 使用skip和limit实现分页
     * 合并 flatMap/map: 在stream过程中，对产生的分支stream合并为一个stream
     * 收集collect: 对stram中的元素的收集
     */
    /**
     * @param users     用户列表
     * @param pageNo    页码
     * @param itemNum   每页条数
     */
    public static void streamFilter(List<User> users, Integer pageNo, Integer itemNum) {
        List<String> names = users.stream()
                .filter(u -> u.getSex().equals("man"))
                .sorted(Comparator.comparing(User::getAge)) //允许指定一个比较器Comparator来对数据流进行排序
                .map(User::getName)
                .distinct()
                .skip(pageNo*itemNum)
                .limit(itemNum)
                .collect(Collectors.toList()); // 结束操作，将结果集中的信息放入列表
        names.forEach(System.out::println);

        //使用count统计数量
        long count = users.stream()
                .filter(u -> u.getSex().equals("man"))
                .sorted(Comparator.comparing(User::getAge)) //允许指定一个比较器Comparator来对数据流进行排序
                .map(User::getName)
                .distinct()
                .count();
        System.out.println(count);
    }

    /**
     * 匹配：allMatch、anyMatch、findFirst、findAny
     * 检查数据集中元素的某一个属性是否符合要求
     */
    public static void streamMatch(List<User> users) {
        Predicate<User> predicate = user -> user.getHobbys() != null;
        boolean allMatch = users.stream().allMatch(predicate);
        System.out.println(allMatch);

        boolean anyMatch = users.stream().anyMatch(user -> user.getAge() == 18);
        System.out.println(anyMatch);

        Optional<User> findFirst = users.stream().findFirst();
        User user = findFirst.get();
        System.out.println(user);

        Optional<User> findAny = users.stream().findAny();
        System.out.println(findAny.get());
    }


    public static void main(String[] args) {
        generateUuid();

    }
}
