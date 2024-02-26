fun main() {
    val qttDays = 5
    val qttCats = 2

    var packageWeight: Double
    do {
        print("Informe o peso (kg) do saco de ração: ")
        packageWeight = readLine()!!.toDouble()

        if(packageWeight <= 0) {
            println("Insira um valor apropriado.")
        }
    } while(packageWeight <= 0)

    var foodPerCat: Double
    do {
        print("Informe a quantidade diária de ração (g) para cada gato: ")
        foodPerCat = readLine()!!.toDouble()

        if(foodPerCat <= 0) {
            println("Insira um valor apropriado.")
        }
    } while(foodPerCat <= 0)

    val(foodEaten, foodLeft) = calc(qttDays, qttCats, packageWeight, foodPerCat)

    println(String.format("Após $qttDays dias, serão consumidos %.2fg de ração, restando %.2fkg no saco.", foodEaten, foodLeft))
}

fun calc(qttDays: Int, qttCats: Int, packageWeight: Double, foodPerCat: Double): Pair<Double, Double> {
    val foodEaten = qttDays * qttCats * foodPerCat
    var foodLeft = packageWeight * 1000 - foodEaten
    foodLeft /= 1000

    return Pair(foodEaten, foodLeft)
}