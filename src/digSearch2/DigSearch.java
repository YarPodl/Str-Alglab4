package digSearch2;

public class DigSearch {
    private Element tree;
    private Element current;

    public DigSearch() {
        tree = new Element('\0');
    }


    private int compare(String word){   // ищет в дереве совпадения, возвращает число совпадений и
                                       // присваивает "current" последнюю совпадающую вершину
        Element element, nextElement = tree;
        for (int i = 0; i < word.length() ; i++) {
            element = nextElement;
            while (nextElement != null){
                if (nextElement.name == word.charAt(i)){
                    break;
                }
                nextElement = nextElement.brother;
            }
            if (nextElement == null){
                current = element;
                return i;
            }
            nextElement = nextElement.son;
        }
        return -1;
    }


    public boolean add(String word){
        word += "\0";
        int countCompare = compare(word);
        if (countCompare == -1){
            return false;   // слово уже имеется
        }
        current.brother = new Element(word.charAt(countCompare));
        current = current.brother;
        for (int i = countCompare + 1; i < word.length(); i++) {
            current.son = new Element(word.charAt(i));
            current = current.son;
        }
        return true;
    }

    public boolean search(String word){
        if (compare(word + "\0") == -1){
            return true;
        } else {
            return false;
        }
    }

    private class Element {
        char name;
        Element brother;
        Element son;

        public Element(char name) {
            this.name = name;
            brother = null;
            son = null;
        }
    }
}


