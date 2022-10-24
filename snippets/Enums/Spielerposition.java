/**
 * Ein "enum" ist eine Aufzählung von bestimmten unterscheidbaren Objekten.
 * Im folgenden Enum werden die verschiedenen Spielerpositionen im Fussball
 * aufgezählt.
 * Intern erhält jeder der aufgezählten Dinge eine Ganzzahl (0, 1, 2, ...)
 * zugewiesen. Dieser kann mit der ordinal()-Methode des enums abgerufen werden
 * In Java können die verwendeten Namen der Objekte ausserdem mit Hilfe der
 * name()-Methode abgerufen werden.
 * 
 * Zu jedem enum gibt es zudem
 * - eine statische Methoden values(), welche alle
 * Objekte des enums in einem Array wiedergibt, sowie
 * - eine statische Methode valueOf(String name), welches das entsprechende
 * Objekt zu einem gültigen Namen zurückliefert.
 */
public enum Spielerposition {
    STUERMER, TORWART, VERTEIDIGER, MITTELFELDSPIELER
}

// Bemerkung: Die