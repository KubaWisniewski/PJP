package TaskSet2

import static javax.swing.JOptionPane.showInputDialog
import static javax.swing.JOptionPane.showMessageDialog

static def getInts() {
    def integerList = []
    def errorList = []
    def error = false
    def val = ""

    while (true) {
        if (error)
            val = showInputDialog(null, "Błędne liczby: ${errorList} \nPodaj poprawną listę liczb całkowitych:", val)
        else
            val = showInputDialog("Podaj listę liczb całkowitych:")

        if (val != null) {
            integerList = []
            errorList = []
            error = false
            val.tokenize(" ").each {
                if (it.isInteger())
                    integerList << it
                else {
                    errorList << it
                    error = true
                }
            }
        }
        if (!error) {
            showMessageDialog(null, integerList.isEmpty() ? "Nie wprowadziłeś liczb" : "Lista liczb całkowitych: ${integerList.join(' ')}")
            break
        }
    }
}

getInts()
