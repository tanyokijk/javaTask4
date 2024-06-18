
import com.aimiko.task4.persistence.entity.Device;
import com.aimiko.task4.persistence.entity.Product;
import com.aimiko.task4.persistence.entity.Projector;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        int size = 20;

        List<Integer> list = new Random().ints(size, -100, 101)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.print("Список: ");
        list.forEach(num -> System.out.print(num + " "));
        System.out.println();

        int countPositive = (int) list.stream().filter(x -> x > 0).count();
        System.out.println("Кількість додатних: " + countPositive);

        int countNegative = (int) list.stream().filter(x -> x < 0).count();
        System.out.println("Кількість від'ємних: " + countNegative);

        int countTwoDigit= (int) list.stream().filter(x -> (x < 100 && x > 9) || (x > -100 && x < -9)).count();
        System.out.println("Кількість двозначних: " + countTwoDigit);

        int countMirrorNumbers = (int)list.stream().filter(Main::isMirrorNumber).count();
        System.out.println("Кількість дзеркальних чисел: " + countMirrorNumbers);

        List<Product> products = new ArrayList<>();
        products.add(Product.newBuilder()
                .name("Смартфон")
                .category("Електроніка")
                .price(4999.99)
                .build());

        products.add(Product.newBuilder()
                .name("Ноутбук")
                .category("Електроніка")
                .price(14999.99)
                .build());

        products.add(Product.newBuilder()
                .name("Кавоварка")
                .category("Побутова техніка")
                .price(2999.99)
                .build());

        products.add(Product.newBuilder()
                .name("Телевізор")
                .category("Електроніка")
                .price(8999.99)
                .build());

        products.add(Product.newBuilder()
                .name("Гіроборд")
                .category("Спортивні товари")
                .price(3999.99)
                .build());

        products.add(Product.newBuilder()
                .name("Книга")
                .category("Література")
                .price(299.99)
                .build());

        products.add(Product.newBuilder()
                .name("Фотокамера")
                .category("Фототехніка")
                .price(7999.99)
                .build());

        products.add(Product.newBuilder()
                .name("Холодильник")
                .category("Побутова техніка")
                .price(11999.99)
                .build());

        products.add(Product.newBuilder()
                .name("Дитячий велосипед")
                .category("Дитячі товари")
                .price(1999.99)
                .build());

        products.add(Product.newBuilder()
                .name("Молоко 3.2% 1л")
                .category("Молоко")
                .price(25.99)
                .build());

        products.add(Product.newBuilder()
                .name("Чай")
                .category("Продукти")
                .price(15.99)
                .build());

        products.add(Product.newBuilder()
                .name("Кава")
                .category("Продукти")
                .price(34.99)
                .build());

        products.add(Product.newBuilder()
                .name("Кефір 2.5% 500мл")
                .category("Молоко")
                .price(15.49)
                .build());

        products.add(Product.newBuilder()
                .name("Рюкзак")
                .category("Туризм і відпочинок")
                .price(499.99)
                .build());

        System.out.println("\nВсі продукти: ");
        for ( Product product : products){
            System.out.println(product);
        }

        System.out.println("\nВсі продукти з назвою менше п’яти символів: ");
        List<Product> products5Characters = products.stream()
                .filter(product -> product.getName().length() < 5)
                .collect(Collectors.toList());
        for ( Product product : products5Characters){
            System.out.println(product);
        }

        System.out.println("\nВсі продукти з категорією \"Молоко\": ");
        List<Product> productsMilk = products.stream()
                .filter(product -> product.getCategory() == "Молоко")
                .collect(Collectors.toList());
        for ( Product product : productsMilk){
            System.out.println(product);
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("\nВведіть назву продукту: ");
            String name = scanner.nextLine();

            List<Product> productsName = products.stream()
                    .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
            if(productsName.size()!=0) {
                System.out.println("\nПродукти, що містять це слово: ");
                for ( Product product : productsName){
                    System.out.println(product);
                }
            }
            else {
                System.out.println("Продуктів, що містять це слово, не знайдено!");
            }

            System.out.print("\nВведіть букву, з якої починається назва продукту: ");
            String letter = scanner.nextLine();

            List<Product> productsLetter = products.stream()
                    .filter(product -> product.getName().toLowerCase().startsWith(letter.toLowerCase()))
                    .collect(Collectors.toList());
            if(productsLetter.size()!=0) {
                System.out.println("\nПродукти, що починаються на цю букву: ");
                for ( Product product : productsLetter){
                    System.out.println(product);
                }
            }
            else {
                System.out.println("Продуктів, що починаються на цю букву, не знайдено!");
            }

        }
        List<Device> devices = new ArrayList<>();

            devices.add(Device.newBuilder()
                    .name("Смартфон")
                    .year(2023)
                    .price(999.99)
                    .color("Рожевий")
                    .type("Мобільний")
                    .build());

            devices.add(Device.newBuilder()
                    .name("Ноутбук")
                    .year(2024)
                    .price(1499.99)
                    .color("Сріблястий")
                    .type("Портативний")
                    .build());

            devices.add(Device.newBuilder()
                    .name("Планшет")
                    .year(2023)
                    .price(599.99)
                    .color("Рожевий")
                    .type("Мобільний")
                    .build());

            devices.add(Device.newBuilder()
                    .name("Смартвотч")
                    .year(2023)
                    .price(299.99)
                    .color("Чорний")
                    .type("Носимий")
                    .build());

            devices.add(Device.newBuilder()
                    .name("Стільний комп'ютер")
                    .year(2024)
                    .price(1999.99)
                    .color("Сірий")
                    .type("Стаціонарний")
                    .build());

            devices.add(Device.newBuilder()
                    .name("Фотокамера")
                    .year(2022)
                    .price(799.99)
                    .color("Рожевий")
                    .type("Фотографічний")
                    .build());

            devices.add(Device.newBuilder()
                    .name("Принтер")
                    .year(2022)
                    .price(299.99)
                    .color("Білий")
                    .type("Офісний")
                    .build());

            devices.add(Device.newBuilder()
                    .name("Навушники")
                    .year(2023)
                    .price(149.99)
                    .color("Червоний")
                    .type("Аудіо")
                    .build());

            devices.add(Device.newBuilder()
                    .name("Монітор")
                    .year(2022)
                    .price(399.99)
                    .color("Чорний")
                    .type("Дисплейний")
                    .build());

            devices.add(Device.newBuilder()
                    .name("Маршрутизатор")
                    .year(2021)
                    .price(79.99)
                    .color("Чорний")
                    .type("Мережевий")
                    .build());

            System.out.println("\nВсі пристрої:");
            for (Device device : devices) {
                System.out.println(device);
            }

            List<Device> pinkDevices = devices.stream()
                    .filter(d -> Objects.equals(d.getColor(), "Рожевий"))
                    .collect(Collectors.toList());

        System.out.println("\nВсі рожеві пристрої:");
        for (Device device : pinkDevices) {
            System.out.println(device);
        }

        List<Device> devices2024 = devices.stream()
                .filter(d -> d.getYear() == 2024)
                .collect(Collectors.toList());

        System.out.println("\nВсі пристрої, які випустилися у 2024 році:");
        for (Device device : devices2024) {
            System.out.println(device);
        }

        List<Device> devicesHigher1000 = devices.stream()
                .filter(d -> d.getPrice() > 1000)
                .collect(Collectors.toList());

        System.out.println("\nВсі пристрої, які дорожче 1000:");
        for (Device device : devicesHigher1000) {
            System.out.println(device);
        }

        List<Device> mobiledevices = devices.stream()
                .filter(d -> Objects.equals(d.getType(), "Мобільний"))
                .collect(Collectors.toList());

        System.out.println("\nВсі мобільні пристрої:");
        for (Device device : mobiledevices) {
            System.out.println(device);
        }
        List<Device> devices20202022 = devices.stream()
                .filter(d -> d.getYear()>=2020 && d.getYear()<=2022)
                .collect(Collectors.toList());

        System.out.println("\nВсі пристрої, випущені в 2020-2022 роках:");
        for (Device device : devices20202022) {
            System.out.println(device);
        }

        List<Projector> projectors = new ArrayList<>();

        projectors.add(Projector.newBuilder()
                .name("Проєктор Samsung The Freestyle 2nd-Gen White")
                .year(2024)
                .price(2999.99)
                .producer("Samsung")
                .build());

        projectors.add(Projector.newBuilder()
                .name("Проєктор Sony VPL-VW590ES")
                .year(2022)
                .price(6999.99)
                .producer("Sony")
                .build());

        projectors.add(Projector.newBuilder()
                .name("Проєктор LG HU85LS")
                .year(2023)
                .price(3999.99)
                .producer("LG")
                .build());

        projectors.add(Projector.newBuilder()
                .name("Проєктор Epson EH-TW9400")
                .year(2021)
                .price(3499.99)
                .producer("Epson")
                .build());

        projectors.add(Projector.newBuilder()
                .name("Проєктор BenQ TK850i")
                .year(2022)
                .price(1499.99)
                .producer("BenQ")
                .build());

        projectors.add(Projector.newBuilder()
                .name("Проєктор Samsung The Premiere SP-LSP9T")
                .year(2024)
                .price(8999.99)
                .producer("Samsung")
                .build());

        System.out.println("\nВсі проєктори:");
        for (Projector projector : projectors) {
            System.out.println(projector);
        }

        List<Projector> samsungProjectors = projectors.stream()
                .filter(p -> Objects.equals(p.getProducer(), "Samsung"))
                .collect(Collectors.toList());

        System.out.println("\nВсі Samsung проєктори:");
        for (Projector projector : samsungProjectors) {
            System.out.println(projector);
        }

        List<Projector> projectors2024 = projectors.stream()
                .filter(p -> Objects.equals(p.getYear(), 2024))
                .collect(Collectors.toList());

        System.out.println("\nВсі проєктори 2024 року:");
        for (Projector projector : projectors2024) {
            System.out.println(projector);
        }

        List<Projector> projectorsHigher5000 = projectors.stream()
                .filter(p -> p.getPrice()>=5000)
                .collect(Collectors.toList());

        System.out.println("\nВсі проєктори дорожче 5000:");
        for (Projector projector : projectorsHigher5000) {
            System.out.println(projector);
        }

        List<Projector> projectorsasc = projectors.stream()
                .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .collect(Collectors.toList());

        System.out.println("\nВсі проєктори, відсортовані за зростанням ціни:");
        for (Projector projector : projectorsasc) {
            System.out.println(projector);
        }

        List<Projector> projectordesc = projectors.stream()
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .collect(Collectors.toList());

        System.out.println("\nВсі проєктори, відсортовані за спаданням ціни:");
        for (Projector projector : projectordesc) {
            System.out.println(projector);
        }

        List<Projector> projectorsyearasc = projectors.stream()
                .sorted((p1, p2) -> Double.compare(p1.getYear(), p2.getYear()))
                .collect(Collectors.toList());

        System.out.println("\nВсі проєктори, відсортовані за зростанням року випуску:");
        for (Projector projector : projectorsyearasc) {
            System.out.println(projector);
        }

        List<Projector> projectorsyeardesc = projectors.stream()
                .sorted((p1, p2) -> Double.compare(p2.getYear(), p1.getYear()))
                .collect(Collectors.toList());

        System.out.println("\nВсі проєктори, відсортовані за спаданням року випуску:");
        for (Projector projector : projectorsyeardesc) {
            System.out.println(projector);
        }
    }

    public static boolean isMirrorNumber(int number) {
        String numStr = String.valueOf(number);
        int length = numStr.length();

        for (int i = 0; i < length / 2; i++) {
            if (numStr.charAt(i) != numStr.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}