package config.wiz

import org.jgrapht.experimental.dag.DirectedAcyclicGraph

import scala.collection.mutable.ArrayBuffer

class GraphSerializer(val taskFileFetcher: FileFetcher, val repoFileFetcher: FileFetcher) {

  private val dag = new DirectedAcyclicGraph[Dependency, DependencyEdge](
                        (source, target) => new DependencyEdge(source, target))

  def serialize : ArrayBuffer[Dependency] = {

    val file = taskFileFetcher fetch "dependency.json"

    val task = DependencyFile(file)

    task.task.fileFetcher = taskFileFetcher

    this serialize task

    val ret = ArrayBuffer[Dependency]()

    dag.iterator.forEachRemaining(ret.append(_))

    ret.reverse
  }

  private def serialize (df : DependencyFile) {
    this addVertex df.task

    for (task <- df.dependencies) {
      this addVertex task

      val taskUrl = repoFileFetcher.baseUrl + task.url + "/"

      task.fileFetcher = new FileFetcher(taskUrl)

      dag addEdge (df.task, task)

      this serialize DependencyFile(task.fileFetcher fetch "dependency.json")
    }
  }

  private def addVertex(d : Dependency) {
    if (!dag.containsVertex(d)) dag addVertex d
  }
}
