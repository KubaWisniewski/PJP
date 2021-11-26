package TaskSet1

import static javax.swing.JOptionPane.showInputDialog
import static javax.swing.JOptionPane.showMessageDialog

def words = 'zero jeden dwa trzy cztery pięć sześć siedem osiem dziwięć dziesięć'.tokenize()
def input = showInputDialog("Wprowadz liczbe całkowitą:")
def out = []

for (character in input) {
    out << words[character.toInteger()]
}

showMessageDialog(null, out.join('-'))
