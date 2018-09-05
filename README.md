### AndroidStudio-MVVM-Template

####本插件针只对于https://github.com/leasual/MvvmAchitecture架构而开发

####使用此插件可以加快开发效率。

#### 使用说明：

##### 首先需要将MVVM-Init、 MVVM-Activity、 MVVM-Fragment三个文件夹拷贝到
        android-studio\plugins\android\lib\templates\activities\
##### 然后重启AndroidStudio

##### 1. 使用MVVM Init新建项目，构建完成后，

    app目录下的build.gradle 中注释的这一行
    //apply plugin: 'kotlin-kapt' 打开，
    并删除dependencies中重复的依赖项
    implementation 'com.android.support:appcompat-v7:26.1.0'删除
    即可完成整个项目的构建
    
##### 2. 通过选择app或以下层级目录右键，New -> MVVM -> MVVM Activity或者MVVM Fragment即可新建。

##### 3. 新建好的Activity或者Fragment还需要在di中进行依赖注入的声明：
        
        3.1 无Fragment的Activity声明
        
            @ContributesAndroidInjector
            internal abstract fun mainActivity(): MainActivity
        
            有Fragment的Activity声明
            
                @ContributesAndroidInjector(modules = [(MainModule::class)])
                internal abstract fun mainActivity(): MainActivity
                
            新建MainModule文件中Fragment进行声明
            
                @Module
                abstract class MainModule {
                    @ContributesAndroidInjector
                    abstract fun mainFragment(): MainFragment
                }
        
        3.2 ViewModel需要在ViewModelModule进行声明
        
                @Binds
                    @IntoMap
                    @ViewModelKey(MainViewModel::class)
                    abstract fun bindsMainViewModel(mainViewModel: MainViewModel): ViewModel
                    
##### 4. ViewModel的数据通过 MediatorLiveData或者LiveData暴露给UI
##### 如有其他不足之处，欢迎大家积极进行完善。