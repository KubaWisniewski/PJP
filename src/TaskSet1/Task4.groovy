package TaskSet1

import javax.swing.UIManager
import static javax.swing.JOptionPane.showInputDialog
import static javax.swing.JOptionPane.showMessageDialog

UIManager.put("OptionPane.okButtonText", "Dodaj produkt")
UIManager.put("OptionPane.cancelButtonText", "Wyświetl liste zsumowanych produktów")

def map = [:].withDefault { 0 }

while (true) {
    def input = showInputDialog("Podaj produkt w formie (pozycja = koszt):")
    if (input == null) break

    input = input.tokenize('=').collect { x -> x.trim() }

    if (input.size() == 2) {
        map[input[0]] += input[1].toBigDecimal()
    }
}

UIManager.put("OptionPane.okButtonText", "Zamknij okno")
showMessageDialog(null, "${map.isEmpty() ? "Brak produktów" : map}")
