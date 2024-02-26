import java.util.Scanner

data class CarCosts(
    val factoryCost: Double,
    val pctDistributor: Int,
    val pctTax: Int,
    val pctDistributorApplied: Double,
    val pctTaxApplied: Double,
    val totalPrice: Double
)

fun main() {
    val scanner = Scanner(System.`in`)

    var factoryCost: Double
    do {
        print("Informe o custo de fábrica do carro: R$ ")
        factoryCost = scanner.nextDouble()

        if(factoryCost <= 0) {
            println("Insira um valor apropriado.")
        }
    } while(factoryCost <= 0)

    val carCosts = calc(factoryCost)
 
    println(String.format("- Custo distribuidor: R$ %.2f (%d%%)", carCosts.pctDistributorApplied, carCosts.pctDistributor))
    println(String.format("- Custo impostos: R$ %.2f (%d%%)", carCosts.pctTaxApplied, carCosts.pctTax))
    println(String.format("-> Total a ser pago pelo carro: R$ %.2f", carCosts.totalPrice))
}

fun calc(factoryCost: Double): CarCosts {
    var pctDistributor: Int
    var pctTax: Int

    if(factoryCost <= 50000) {
        pctDistributor = 5
        pctTax = 0
    } else if(factoryCost > 80000) {
        pctDistributor = 15
        pctTax = 20
    } else {
        pctDistributor = 10
        pctTax = 15
    }

    val pctDistributorApplied = factoryCost * pctDistributor / 100
    val pctTaxApplied = factoryCost * pctTax / 100

    val totalPrice = factoryCost + pctDistributorApplied + pctTaxApplied

    return CarCosts(
        factoryCost,
        pctDistributor,
        pctTax,
        pctDistributorApplied,
        pctTaxApplied,
        totalPrice
    ) 
}