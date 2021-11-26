package TaskSet4

import groovy.json.JsonSlurper

def PLNPriceRegex = /[+-]?[0-9]+\.[0-9]+\s+PLN|[+-][0-9]+\s+PLN/
def PLNToEURRate = new JsonSlurper().parse(new URL("http://api.nbp.pl/api/exchangerates/rates/a/eur?format=json"))['rates'][0]['mid']

def menuPLNFile = new File("MenuPl.txt")
def menuEURFile = new File("MenuEur.txt")
menuEURFile.text = ""
menuPLNFile.each {
    menuEURFile.text += it.replaceAll(PLNPriceRegex) { number -> String.format(Locale.US, '%.2f', number.toString().split("\\s").first().toBigDecimal() / (PLNToEURRate as Number)) } + " EUR\n"
}
