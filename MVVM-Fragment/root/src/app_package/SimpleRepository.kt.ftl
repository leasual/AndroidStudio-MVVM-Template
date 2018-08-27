package ${packageName}.repository.${moduleName}


import ${packageName}.App
import ${packageName}.base.BaseRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by james on 2018/8/21.
 */

@Singleton
class ${repositoryClass} @Inject constructor(private val app: App): BaseRepository() {


}