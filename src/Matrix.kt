import java.util.*
import kotlin.collections.ArrayList
import kotlin.reflect.typeOf

class Matrix(val strok: Int, val stolb : Int, val variant : Boolean){
    val array = ArrayList<ArrayList<Int>>()

    init {
        for (i in 0 until strok){
            array.add(ArrayList())
            for (j in 1..stolb)
                array[i].add(0)
        }
    }
    init {
        if(variant){
            println("Заполните матрицу: ")
            for (item in array){
                for (i in 0 until stolb){
                    item[i] = readLine().toString().toInt()
                }
            }
        }
        else{
            for (item in array){
                for (i in 0 until stolb){
                    item[i] = kotlin.random.Random.nextInt(0,50)
                }
            }
        }
    }
    override fun toString() : String{
        var str = ""
        for (item in array){
            str += "[ "
            for (i in 0 until stolb){
                str+= "${item[i]} "
            }
            str +="]\n"
        }
        return str
    }
    fun determinant(matrix : ArrayList<ArrayList<Int>>, rows : Int, columns : Int) : Double{
        if( rows == columns) {
            if (rows == 1 && columns == 1)
                return matrix[rows - 1][columns - 1].toDouble();
            else {
                var determ : Double = 0.0
                var matrixNew = ArrayList<ArrayList<Int>>();
                for (i in 0 until rows-1){
                    matrixNew.add( ArrayList())
                    for (j in 1..columns-1)
                        matrixNew[i].add(0)
                }

                for (c in 0 until columns) {
                    var count_i_new = 0
                    for (i in 1 until rows) {
                        var count_j_new = 0
                        for (j in 0 until columns) {
                            if (c != j) {
                             matrixNew[count_i_new][count_j_new] = matrix[i][j]
                             ++count_j_new
                    }
                }
                     ++count_i_new
                }
                    var minor = determinant(matrixNew, rows - 1, columns - 1);
                    determ += Math.pow((-1).toDouble(), c.toDouble() + 2) * minor * matrix[0][c];


                }
                return determ;
            }
        }else{
            println("Матрица имеют разные размеры!")
            return 0.0;
        }
    }
    fun returnRows() : Int{
        return strok
    }
    fun returnColums() : Int{
        return stolb
    }
    fun returnMatrix() : ArrayList<ArrayList<Int>>{
        return array
    }

}




fun main(){
    var a = 15
    println()
    var obj = Matrix(5,5,false)
    println(obj.toString())
    println("Determinant = ${obj.determinant(obj.returnMatrix(), obj.returnRows(), obj.returnColums())}")
}