import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // Task 1
        List<Integer> numberList = new ArrayList<>();
        numberList.add(23);
        numberList.add(12);
        numberList.add(21);
        numberList.add(3);
        numberList.add(7);
        numberList.add(54);
        numberList.add(16);
        numberList.add(14);
        numberList.add(28);
        numberList.add(11);
        Stream<Integer> integerStream = numberList.stream();
        findMinMax(integerStream, Integer::compareTo,
                (x, y) -> System.out.println("Минимальное значение в stream: " + x + "\n" + "Максимальное значение в stream: " + y));
        countEvenNumbers(numberList);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> arrayList;
        T min = null;
        T max = null;
        arrayList = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (arrayList.size() != 0) {
            min = arrayList.get(0);
            max = arrayList.get(arrayList.size() - 1);
        }
        minMaxConsumer.accept(min, max);
    }

    public static void countEvenNumbers(List<Integer> list) {
        System.out.println(" Четное количество: " + list.stream()
                .filter(x -> x % 2 == 0)
                .count());
    }
}