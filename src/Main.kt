enum class ShapeType{
    CIRCLE,
    RECTANGLE,
    Sphere
}

abstract class Shape {
    abstract fun getName():String
}

interface TwoDimensional{
    fun calculateArea():Double
}

interface ThreeDimensional{
    fun calculateVolume():Double
}

class Circle(val radius:Double) : Shape(),TwoDimensional{
    override fun getName():String{
        return ShapeType.CIRCLE.toString()
    }

    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

class Rectangle(val witdh:Double,val height:Double):Shape(),TwoDimensional{
    override fun getName(): String {
    return ShapeType.RECTANGLE.toString()
    }

    override fun calculateArea(): Double {
       return witdh*height
    }

}

class Sphere (val radius:Double):Shape(),TwoDimensional,ThreeDimensional{
    override fun getName(): String {
        return ShapeType.Sphere.toString()
    }

    override fun calculateArea(): Double {
        return 4 * Math.PI * radius * radius
    }

    override fun calculateVolume(): Double {
        return (4/3) * Math.PI * radius * radius * radius
    }

}

fun main (){

    println("Dairenin radiusunu yaz: ")
    var crcleRadius = readln()

    var shapes:Array<Shape> =  arrayOf(
        Circle(crcleRadius.toDouble()),
        Rectangle(5.0,6.0),
        Sphere(6.0)
    )

    println("")
    shapes.forEach {
        val name = it.getName()

        when(it){
            is TwoDimensional -> println(name+"="+it.calculateArea())
            is ThreeDimensional-> println(name+"="+it.calculateVolume())
            else -> throw Exception("Sehvdi")
        }
    }

}
