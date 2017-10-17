package Main;
import digSearch2.DigSearch;

public class Main {
    public static void main(String[] args) {
        DigSearch digSearch = new DigSearch();
        digSearch.add("qwer");          // Ошибается с пустой строкой
        System.out.println(digSearch.search(""));
        System.out.println(digSearch.search("qw"));
        System.out.println(digSearch.search("qwer"));
        System.out.println(digSearch.search("qwert"));
    }
}
