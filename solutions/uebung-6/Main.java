/*
 * Die Klasse "Main" soll eine Zeichenkette namens "name" als Instanzvariable haben und einen Konstruktor, 
 * der diese übernimmt.
 * Ausserdem soll sie eine Methode "addNameTo" haben, welche "name" an eine Instanz von Typ "Addable", 
 * hinzufügt, die als Parameter übergeben wird
 * 
 * In der "main"-Methode soll eine Instanz "main" der Klasse "Main" angelegt werden, 
 * ein "SearchableArray" { "Banane", "Kiwi", "Kirsche", "Ananas", "Apfel" }
 * mit Kapazität 100 wie auch ein "SearchableString" 
 * mit Inhalt "GanzLangeZeichenketteMitBirnenUndAnanasSowieNochMehrAnanassenUndPfirsichen".
 * 
 * Die "addNameTo"-Methode soll für die Main-Instanz auf die Instanzen von SearchableArray und SearchableString
 * angewendet werden.
 * Ausserdem soll auf der Konsole ausgegeben werden, wie oft nun die Instanzvariable "name" in den Instanzen von
 * SearchableArray und SearchableString vorkommen
 * 
 */

public class Main {
    private String name;

    public Main(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Main main = new Main("Ananas");
        SearchableArray array = new SearchableArray(
                new String[] { "Banane", "Kiwi", "Kirsche", "Ananas", "Apfel" }, 100);
        SearchableString string = new SearchableString(
                "GanzLangeZeichenketteMitBirnenUndAnanasSowieNochMehrAnanassenUndPfirsichen");

        assert (array.search(main.name));
        assert (string.search(main.name));

        main.addNameTo(array);
        main.addNameTo(string);

        int occString = string.countOccurences(main.name);
        int occArray = array.countOccurences(main.name);
        System.out.println("Das aktualisierte Array enthält " + occArray + " Mal die Zeichenkette '" + main.name +
                "' die aktualisierte Zeichenkette enthält es " + occString + " Mal.");
    }

    public void addNameTo(Addable addable) {
        addable.add(this.name);
    }
}
