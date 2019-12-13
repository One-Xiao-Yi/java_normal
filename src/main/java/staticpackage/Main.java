package staticpackage;

public class Main {

    // static 静态变量共同指向同一块空间，变化会影响所有对象。

    public static void main(String[] args) {

        Person wang = new Person();
        Person hao = new Person();

        wang.number = 88;

        System.out.println(wang.number);
        System.out.println(hao.number);

    }

}

class Person
{
    public static int number;
}
