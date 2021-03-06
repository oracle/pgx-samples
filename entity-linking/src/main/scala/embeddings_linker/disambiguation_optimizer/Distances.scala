/*
 ** Copyright (c) 2019, Oracle and/or its affiliates.  All rights reserved.
 ** Licensed under the Universal Permissive License v 1.0 as shown at http://oss.oracle.com/licenses/upl.
 */

package embeddings_linker.disambiguation_optimizer

import breeze.linalg.{DenseVector, norm}

object Distances {
  def cosine(
              x: DenseVector[Double],
              y: DenseVector[Double],
              x_norm: Option[Double] = None,
              y_norm: Option[Double] = None
            ): Double =  {

    val x_n: Double = x_norm.getOrElse(norm(x))
    val y_n: Double = y_norm.getOrElse(norm(y))
    val tot: Double = x dot y

    1 - tot / (x_n * y_n)
  }
}
