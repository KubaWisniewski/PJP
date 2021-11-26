package TaskSet4

def htmlFilesPackage = new File("TestHtmlFiles")
def counter = 1

htmlFilesPackage.eachFileRecurse {
    if (it.isFile() && it.name.endsWith('.html')) {
        println("${counter++} ${it}")
    }
}
