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

    val matches = matchsByElements(n)
    matches.foldLeft(List(List.empty[Match])) { (acc, sublist) =>
      for {
        x <- acc
        y <- sublist
        if !x.exists(_._1 == y._1)
      } yield x :+ y
    }
  }

  def matchings (n: Int): List[Matching] = {

    def noCopRepetido(subLista: List[(Int, Int)]): Boolean = {
      val setAux = subLista.map(_._2).toSet
      setAux.size == subLista.length
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
