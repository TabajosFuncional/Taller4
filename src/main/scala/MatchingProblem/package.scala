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

  def possibleMatchings(n: Int): List[List[(Int,Int)]] = {

    val AllMatches = matchsByElements(n)
    AllMatches.foldLeft(List(List.empty[Match])) { (acc, subLista) =>
      for {
        x <- acc
        y <- subLista
        if !x.exists(_._1 == y._1)
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
/*
  def weightedMatchings(n: Int, pilotPrefs: Preferences, navigPrefs: Preferences): List[(Matching, Int)] = {

  }

  def bestMatching(n: Int, pilotPrefs: Preferences, navigPrefs: Preferences): (Matching, Int) = {

  }*/
}
