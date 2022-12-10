package day7

sealed class FSEntry {
    abstract fun size(): Int
}

class Directory(
    var children: MutableList<FSEntry> = mutableListOf(),
    val name: String,
    val parent: Directory? = null
) : FSEntry() {
    override fun size(): Int = children.sumOf { it.size() }

    fun addFile(size: Int, name: String) {
        children.add(File(size, name))
    }

    fun addDirectory(children: MutableList<FSEntry> = mutableListOf(), name: String) {
        this.children.add(Directory(children, name, this))
    }

    fun findDirByName(name: String): Directory? = children.filterIsInstance<Directory>().firstOrNull { it.name == name }

    fun flat(directories: MutableList<Directory> = mutableListOf()): List<Directory> {
        directories.add(this)
        children.filterIsInstance<Directory>().forEach { directories.addAll(it.flat()) }
        return directories
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Directory) return false

        if (name != other.name) return false
        if (children != other.children) return false

        return true
    }

    override fun hashCode(): Int {
        var result = children.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + (parent?.hashCode() ?: 0)
        return result
    }
}

class File(val size: Int, val name: String) : FSEntry() {
    override fun size(): Int = size
}