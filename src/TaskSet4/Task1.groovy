package TaskSet4

def projectsFile = new File("Projekty.txt")

Map<String, String[]> projectsProgrammersMap = [:]

projectsFile.each {
    def tmp = it.split("\t")
    projectsProgrammersMap[tmp[0]] = tmp.drop(1)
}

def bigProjectsFile = new File("ProjektyDuze.txt")
bigProjectsFile.text = ""
projectsProgrammersMap.each {
    if (it.value.size() > 3)
        bigProjectsFile.text += "${it.key}\n"
}

def programmersFile = new File("Programisci.txt")
programmersFile.text = ""
projectsProgrammersMap.values().flatten().unique().each { name ->
    programmersFile.text +=
            "${name}\t${projectsProgrammersMap.findAll { it.value.contains(name) }.collect { it.key }.join("\t")}\n"
}
