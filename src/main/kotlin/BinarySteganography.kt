import com.google.common.primitives.Bytes
import java.io.*

// hiding file example: java steg.kt original_file hidden_file new_file
//unhiding file example: java steg.kt file new_file

fun main(args: Array<String>) {

    val original = args[0]
    val hidden = args[1]
    var newFile: String? = null
    if(args.size == 3)
        newFile = args[2]
    val separator = "------666666------".toByteArray()


    if(newFile == null){
        val originalFile = File(original)
        val bytes = originalFile.readBytes()
        val index = Bytes.indexOf(bytes, separator)
        val hiddenBytes = bytes.sliceArray(index + separator.size..bytes.size - 1)
        val hiddenFile = File(hidden)
        hiddenFile.writeBytes(hiddenBytes)
        println("$hiddenFile is unhidden")
        return
    }
    println("hiding $hidden inside of $original")
    val originalBytes = File(original).readBytes()
    val hiddenBytes = File(hidden).readBytes()
    val file = File(newFile!!)
    file.writeBytes(originalBytes + separator + hiddenBytes)
    println("$newFile is created")
}