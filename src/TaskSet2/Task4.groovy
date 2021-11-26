package TaskSet2

import static javax.swing.JOptionPane.showInputDialog
import static javax.swing.JOptionPane.showMessageDialog

static def getData(Class<?> elType = String, Closure closure = { return true }) {
    def list = []
    def errorList = []
    def error = false
    def val = ""
    def convertedValue

    while (true) {
        if (error)
            val = showInputDialog(null, "Błędy: ${errorList} \nPodaj poprawną listę elementów jednego typu:", val)
        else
            val = showInputDialog("Podaj listę elementów jednego typu:")

        if (val != null) {
            list = []
            errorList = []
            error = false
            val.tokenize(" ").each {
                try {
                    convertedValue = it.asType(elType)
                    if (!(elType == String && it.isNumber()) && closure(convertedValue))
                        list << convertedValue
                    else {
                        errorList << convertedValue
                        error = true
                    }
                } catch (Exception e) {
                    errorList << it
                    error = true
                }

            }
        }
        if (!error) {
            showMessageDialog(null, list.isEmpty() ? "Nic nie wprowadziłeś" : "Lista: ${list.join(' ')}")
            break
        }
    }
}

//getData(Integer) { it > 0 }            // liczby całkowite większe od 0
//getData() { it.size() > 3 }   // słowa o długości większej od 3 (domyślny typ: String)
//getData()                          // dowolne napisy (słowa)
getData(BigDecimal)         // dowolne liczby
