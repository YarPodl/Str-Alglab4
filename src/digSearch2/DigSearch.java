package digSearch2;

public class DigSearch {
    private Element tree;
    private Element current;

    public DigSearch() {
        tree = null;
    }


    private int compare(String word){   // ищет в дереве совпадения, возвращает число совпадений и
                                       // присваивает "current" последнюю совпадающую вершину
        Element element, nextElement = tree;
        block:
        for (int i = 0; i < word.length(); i++) {
            element = nextElement;
            while (nextElement != null) {
                if (nextElement.name == word.charAt(i)) {
                    nextElement = nextElement.son;
                    continue block;
                }
                nextElement = nextElement.brother;
            }
            current = element;
            return i;
        }
        return -1;
    }


    public boolean add(String word){
        word += "\0";
        int countOfSimilarity;
        if (tree != null) {
            countOfSimilarity = compare(word);
            if (countOfSimilarity == -1) {
                return false;   // слово уже имеется
            }
            current.brother = new Element(word.charAt(countOfSimilarity));
            current = current.brother;
        } else {
            countOfSimilarity = 0;
            current = tree = new Element(word.charAt(0));
        }
        for (int i = countOfSimilarity + 1; i < word.length(); i++) {
            current.son = new Element(word.charAt(i));
            current = current.son;
        }
        return true;
    }

    public boolean search(String word){
        return compare(word + "\0") == -1;
    }

    private class Element {
        char name;
        Element brother;
        Element son;

        Element(char name) {
            this.name = name;
            brother = null;
            son = null;
        }
    }
}


