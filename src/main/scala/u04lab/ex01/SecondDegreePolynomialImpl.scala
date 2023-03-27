package u04lab.ex01

import u04lab.code.SecondDegreePolynomial

case class SecondDegreePolynomialImpl(override val constant: Double,
                                 override val firstDegree: Double,
                                 override val secondDegree: Double) extends SecondDegreePolynomial {

  override def +(polynomial: SecondDegreePolynomial): SecondDegreePolynomial =
    new SecondDegreePolynomialImpl(constant + polynomial.constant, firstDegree + polynomial.firstDegree, secondDegree + polynomial.secondDegree)

  override def -(polynomial: SecondDegreePolynomial): SecondDegreePolynomial =
    new SecondDegreePolynomialImpl(constant - polynomial.constant, firstDegree - polynomial.firstDegree, secondDegree - polynomial.secondDegree)
}
