package digSearch2;

public class digSearch {
    private Element tree;
    private Element current;

    public digSearch() {
        tree = new Element('\0');
    }


    private int compare(String word){   // ищет в дереве совпадения, возвращает число совпадений и
                                       // присваивает "current" последнюю совпадающую вершину
        Element element, nextElement = tree;
        for (int i = 0; i < word.length() ; i++) {
            element = nextElement;
            while (nextElement != null){
                if (current.name == word.charAt(i)){
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
        for (int i = countCompare + 1; i < word.length(); i++) {
            Element element = new Element(word.charAt(i));
            element.brother = current;
            current = element;
        }
        return true;
    }

    public boolean search(String word){
        if (compare(word + " ") == -1){
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


