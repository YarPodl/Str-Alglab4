package Main;
import digSearch2.DigSearch;

public class Main {
    public static void main(String[] args) {
        DigSearch digSearch = new DigSearch();
        digSearch.add("qwer");
        digSearch.add("tuty");
        digSearch.add("luy");
        digSearch.add("luaqqe");
        System.out.println(digSearch.search(""));
        System.out.println(digSearch.search("qw"));
        System.out.println(digSearch.search("qwer"));
        System.out.println(digSearch.search("qwert"));
        System.out.println(digSearch.search("luy"));
        System.out.println(digSearch.search("luaqqe"));
        System.out.println(digSearch.search("qwert"));
    }
}
