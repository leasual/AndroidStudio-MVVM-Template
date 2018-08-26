package ${packageName}.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by james.li on 2018/8/21.
 */
@Module
abstract class BuilderModule {

    // support fragment injection
    //@ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    //internal abstract fun mainActivity(): MainActivity
}