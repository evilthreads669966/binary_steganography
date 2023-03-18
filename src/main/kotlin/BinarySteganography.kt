import com.google.common.primitives.Bytes
import java.io.*

// hiding file example: java -jar Steg.jar original_file hidden_file new_file
//unhiding file example: java -jar Steg.jar file new_file

fun main(args: Array<String>) {

    val original = args[0]
    val hidden = args[1]
    var newFile: String? = null
    if(args.size == 3)
        newFile = args[2]
    val separator = "------666666------".toByteArray()

    //unhide the file
    if(newFile == null){
        val bytes = readBytes(original)
        val index = Bytes.indexOf(bytes, separator)
        val hiddenBytes = bytes.sliceArray(index + separator.size..bytes.size - 1)
        val hiddenFile = File(hidden)
        hiddenFile.writeBytes(hiddenBytes)
        println("$hiddenFile is unhidden")
        return
    }

    //hide the file
    println("hiding $hidden inside of $original")
    val originalBytes = readBytes(original)
    val hiddenBytes = readBytes(hidden)
    val file = File(newFile!!)
    file.writeBytes(originalBytes + separator + hiddenBytes)
    println("$newFile is created")
}

fun readBytes(path: String): ByteArray{
    val file = RandomAccessFile(path, "r")
    val bytes = ByteArray(file.length().toInt())
    file.readFully(bytes)
    return bytes
}