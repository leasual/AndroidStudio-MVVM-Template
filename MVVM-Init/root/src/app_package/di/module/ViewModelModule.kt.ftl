package ${packageName}.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import ${packageName}.di.DaggerViewModelFactory
import ${packageName}.di.ViewModelKey
import ${packageName}.ui.main.${viewModelClass}

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by james.li on 2018/8/21.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(${viewModelClass}::class)
    abstract fun bindsMainViewModel(viewModel: ${viewModelClass}): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}