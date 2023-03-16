import kotlin.random.Random

fun czyPierwsza(n: Int): Boolean {
    if (n < 2) return false
    var i = 2
    while (i * i < n) {
        if (n % i == 0) return false
        i++
    }
    return true
}

fun generujPierwsze(): Int {
    var pierwsza: Int = Random.nextInt(10000, 20000)
    while (!czyPierwsza(pierwsza))
        pierwsza++
    return pierwsza
}

fun nwd(a: Int, b: Int): Int {
    var b = b
    var a = a
    var temp:Int
    while (b != 0) {
        temp = b
        b = a % b
        a = temp
    }
    return a
}

fun main(args: Array<String>) {
    val p = generujPierwsze()
    val q = generujPierwsze()
    println("$p\n$q\n")
    val n = p * q
    val k = (p - 1) * (q - 1)
    var e = Random.nextInt(2, k)
    while (nwd(k, e) != 1 && !czyPierwsza(e))
        e++
    println("e: $e\n")
    var d = Random.nextInt(0, k)
    while (e * d % k != 1)
        d++
    println("d: $d\n")
    println("\n====================================\n")
    println("Klucz publiczny: $e$n\n")
    println("Klicz prywatny: $d$n\n")
    println("\n====================================\n")
}