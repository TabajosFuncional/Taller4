/*
 * Taller 4: Colecciones y expresiones for
 * Integrantes: John Freddy Belalcázar - 2182464
 *              Santiago González Gálvez - 2183392
 */

package object MatchingProblem {

  type Match = (Int, Int)
  type Matching = List[Match]
  type Preferences = Vector[Vector[Int]]

  def matchByElement(i: Int, n: Int): Matching = {
    val matches = (for(s <- 1 to n if(1<=i && i<=n)) yield (i,s)).toList
    matches
  }

  def matchsByElements(n: Int): List[Matching] = {
    val matchesAux = (for(s <- 1 to n) yield matchByElement(s,n)).toList
    matchesAux
  }

  def possibleMatchings(n: Int): List[List[Match]] = {

    val AllMatches = matchsByElements(n)
    AllMatches.foldLeft(List(List.empty[Match])) { (acc, subLista) =>
      for {
        x <- acc                           //acc es un acumulador que inicia con List(List()[Match])
        y <- subLista                      //subLista recorre cada subLista de AllMatches
        if !x.exists(_._1 == y._1)         //Verifica que no se repita un piloto en la misma sublista
      } yield x :+ y
    }
  }

  def matchings (n: Int): List[Matching] = {

    def noCopRepetido(subLista: List[(Int, Int)]): Boolean = {
      val copilotos = for (x <- subLista) yield x._2
      copilotos.toSet.size == subLista.length   //Si no hay cops repetidos, el tamaño del conjunto y la sublista original tienen misma longitud -> true
    }
    val allMatches = possibleMatchings(n)
    val matchsValidos = for {
      m <- allMatches
      if noCopRepetido(m)
    } yield m
    matchsValidos.distinct
  }

  def weightedMatchings(n: Int, pilotPrefs: Preferences, navigPrefs: Preferences): List[(Matching, Int)] = {
    def calcularPeso(subLista: Matching): Int = {
      val pesos = for {
        m <- subLista
      } yield (List(pilotPrefs.take(m._1).last.take(m._2).last, navigPrefs.take(m._2).last.take(m._1).last) foldLeft 1) ((x,y) => x*y)
      //println(pesos)
      (pesos foldLeft 0) ((x,y) => x+y)
    }
    for {
      m <- matchings(n)
    } yield (m, calcularPeso(m))
  }

  def bestMatching(n: Int, pilotPrefs: Preferences, navigPrefs: Preferences): (Matching, Int) = {
    val matchs = weightedMatchings(n, pilotPrefs, navigPrefs)
    val pesos = for {
      m <- matchs
    } yield m._2
    val peso_maximo = pesos.max
    val soluciones = for {
      m <- matchs
      if (m._2==peso_maximo)
    } yield m
    soluciones.head
  }
}
