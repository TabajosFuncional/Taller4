import MatchingProblem ._

// Pruebas: matchByElement
val MBE1 = matchByElement(6,5) // Esperado: List()

val MBE2 = matchByElement(2,5) // Esperado: List((2,1), (2,2), (2,3), (2,4), (2,5))
val MBE3 = matchByElement(3,5) // Esperado: List((3,1), (3,2), (3,3), (3,4), (3,5))
val MBE4 = matchByElement(4,5) // Esperado: List((4,1), (4,2), (4,3), (4,4), (4,5))
val MBE5 = matchByElement(5,5) // Esperado: List((5,1), (5,2), (5,3), (5,4), (5,5))

// Pruebas: matchsByElements
val MBES1 = matchsByElements(1)
val MBES2 = matchsByElements(2)
val MBES3 = matchsByElements(3)
val MBES4 = matchsByElements(4)
val MBES5 = matchsByElements(5)

// Pruebas: possibleMatchings
val PM1 = possibleMatchings(1)
val PM2 = possibleMatchings(2)
val PM3 = possibleMatchings(3)
println("Combinaciones posibles PM5 = "+ PM3.length)
val PM4 = possibleMatchings(4)
println("Combinaciones posibles PM4 = "+ PM4.length)
val PM5 = possibleMatchings(5)
println("Combinaciones posibles PM5 = "+ PM5.length)

// Pruebas: matchings
val match1 = matchings(1)
val match2 = matchings(2)
val match3 = matchings(3)
println("Combinaciones válidas match3 = "+ match3.length)
val match4 = matchings(4)
println("Combinaciones válidas match4 = "+ match4.length)
val match5 = matchings(5)
println("Combinaciones válidas match5 = "+ match5.length)

// Pruebas: weightedMatchings

val tp = Vector(Vector(2,3,1,1), Vector(1,1,4,3), Vector(1,2,3,4), Vector(2,3,2,1))
val tc = Vector(Vector(4,1,3,2), Vector(4,2,3,1), Vector(1,1,1,4), Vector(3,2,3,3))

weightedMatchings(1,tp,tc)
weightedMatchings(2,tp,tc)
weightedMatchings(3,tp,tc)
weightedMatchings(4,tp,tc)

// Pruebas: bestMatching

bestMatching(1,tp,tc)
bestMatching(2,tp,tc)
bestMatching(3,tp,tc)
bestMatching(4,tp,tc)