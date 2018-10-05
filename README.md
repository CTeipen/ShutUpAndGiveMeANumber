# ShutUpAndGiveMeANumber
## Beschreibung
Das Programm ist eine JavaFX Anwendung mit der man sich eine Reihe von Zahlen generieren lassen kann.
Diese Zahlen lassen sich mittels der Bedienelemente auf verschiedenste Weise manipulieren.

## Bedienung
<center>![Die Oberfläche der Anwendung](https://github.com/CTeipen/ShutUpAndGiveMeANumber/blob/master/images/interface.png "Oberfläche von ShutUpAndGiveMeANumber")</center>
Die Menüleiste bietet die Optionen die Anwendung zu schließen über "File -> Close".
Über "Help -> ?" öffnet sich ein Fenster mit Hilfen zu der Manipulation eines spezifischen Anwendungsfalles.


Im mittleren Bereich der Oberfläche befinden sich links und rechts je eine Liste. In dieser Liste werden die Zahlen angezeigt, die (links) noch verfügbar sind und (rechts) schon verwendet wurden.


Der untere Bereich zeigt verschiedene Bedienelemente. Von links nach rechts:
Im ersten Textfeld kann eine Zahl angegeben werden. Diese Zahl bestimmt die Anzahl der zu generierenden Zahlen (1 - n).
Die Generierung wird über den Button rechts neben dem Textfeld angestoßen.

Über die Schaltflächen "Schieben" und "Löschen" können Zahlen aus der linken Liste in die rechte Liste verschoben werden, oder aus der rechten Liste gelöscht werden.

Für Lösch-Szenarien, die einen Algorithmus fordern, bieten der Button "Lösche je" und die darauf folgenden Textfelder einige Optionen. Das erste Textfeld gibt an, welcher Index der rechten Liste gelöscht werden soll, der Modulo dem Wert gleich 0 ist. Bei der Eingabe von 3, wird jede 3. Zahl gelöscht.
Das zweite Textfeld gibt an, ab welchem Index das Löschen der je n-ten Zahl durchgeführt werden soll.
Der Button "Lösche je" führt die Aktion aus.

Der Button "Leeren löscht alle Einträge aus der linken und rechten Liste.

Beim Klick des Buttons "Zufall" wird eine zufällige Zahl aus der linken Liste ausgewählt, in einer Meldung angezeigt und dann der rechten Listen hinzugefügt.
