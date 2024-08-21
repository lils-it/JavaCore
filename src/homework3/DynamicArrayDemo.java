package homework3;

public class DynamicArrayDemo {

    public static void main(String[] args) {

        DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.add(5);
        dynamicArray.add(4);
        dynamicArray.add(53);
        dynamicArray.add(34);
        dynamicArray.add(12);
        dynamicArray.add(73);
        dynamicArray.add(4);
        dynamicArray.add(512);
        dynamicArray.add(23);
        dynamicArray.add(48);
        dynamicArray.add(42);

        dynamicArray.print();

        System.out.println(dynamicArray.getByIndex(5));
        dynamicArray.set(1, 7);
        dynamicArray.print();

        System.out.println(dynamicArray.getIndexByValue(53));
        dynamicArray.set(16, 7);

        System.out.println();
        dynamicArray.add(5, 8);
        dynamicArray.print();

        System.out.println();
        dynamicArray.deleteByIndex(5);
        dynamicArray.print();
        System.out.println(dynamicArray.exists(512));


    }
}
