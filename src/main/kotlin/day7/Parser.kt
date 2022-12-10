package day7

class Parser(private val fileContent: List<String>) {
    fun parse(): Directory {
        val baseDirectory = Directory(name = SLASH)
        var currentDirectory: Directory = baseDirectory
        var isListing = false

        for (it in fileContent) {
            if (it == CD_HOME_COMMAND) {
                continue // Consume next line
            }

            if (it == LS_COMMAND) {
                // we read the next data in this folder
                isListing = true
                continue // Consume next line
            }

            if (it.startsWith(CD_COMMAND)) {
                // We are done with the current folder
                isListing = false

                currentDirectory = if (it == CD_COMMAND_GO_UP) {
                    // Go to the previous level
                    currentDirectory.parent!!
                } else {
                    // Update the current directory to the new one (It should be a child of the current one)
                    val destFolder = it.drop(CD_COMMAND_LENGTH)
                    currentDirectory.findDirByName(destFolder)!!
                }
                continue // Consume next line
            }

            if (isListing) {
                // Populate the children of this folder
                if (it.startsWith(DIR)) {
                    // We have a directory
                    currentDirectory.addDirectory(name = it.drop(DIR_PART_IN_STR))
                } else {
                    // We have a file, extract its parts
                    val parts = it.split(SPACE)
                    currentDirectory.addFile(size = parts[0].toInt(), name = parts[1])
                }
            }
        }

        return baseDirectory
    }

    companion object {
        private const val CD_COMMAND = "$ cd "
        private const val CD_HOME_COMMAND = "$ cd /"
        private const val CD_COMMAND_GO_UP = "$ cd .."
        private const val LS_COMMAND = "$ ls"
        private const val SPACE = " "
        private const val SLASH = "/"
        private const val DIR = "dir"
        private const val DIR_PART_IN_STR = 4
        private const val CD_COMMAND_LENGTH = 5
    }
}