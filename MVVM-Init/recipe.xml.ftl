<?xml version="1.0"?>
<recipe>
	<merge from="root/res/AndroidManifest.xml.ftl"
             to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />
             
	<mkdir at="${escapeXmlAttribute(resOut)}/anim" />
             
    <merge from="root/res/anim/anim_bottom_in.xml.ftl"
             to="${escapeXmlAttribute(resOut)}/anim/anim_bottom_in.xml" />
             
    <merge from="root/res/anim/anim_bottom_out.xml.ftl"
             to="${escapeXmlAttribute(resOut)}/anim/anim_bottom_out.xml" />
	
	<mkdir at="${escapeXmlAttribute(srcOut)}/api" />

    <mkdir at="${escapeXmlAttribute(srcOut)}/base" />
    
    <mkdir at="${escapeXmlAttribute(srcOut)}/base/adapter" />
    
    <mkdir at="${escapeXmlAttribute(srcOut)}/di" />

    <mkdir at="${escapeXmlAttribute(srcOut)}/di/component" />

    <mkdir at="${escapeXmlAttribute(srcOut)}/di/module" />

    <mkdir at="${escapeXmlAttribute(srcOut)}/di/scope" />

    <mkdir at="${escapeXmlAttribute(srcOut)}/extension" />

    <mkdir at="${escapeXmlAttribute(srcOut)}/model" />

    <mkdir at="${escapeXmlAttribute(srcOut)}/repository" />

    <mkdir at="${escapeXmlAttribute(srcOut)}/ui" />

    <mkdir at="${escapeXmlAttribute(srcOut)}/util" />

    <mkdir at="${escapeXmlAttribute(srcOut)}/vo" />
    
    <mkdir at="${escapeXmlAttribute(srcOut)}/widget" />

<#if generateLayout>
    <instantiate from="root/res/layout/activity_simple.xml.ftl"
                 	to="${escapeXmlAttribute(resOut)}/layout/${simpleLayoutName}.xml" />
</#if>

	<instantiate from="root/src/app_package/App.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/App.kt" />
                   
	<instantiate from="root/src/app_package/api/APIException.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/api/APIException.kt" />

    <instantiate from="root/src/app_package/api/APIService.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/api/APIService.kt" />

    <instantiate from="root/src/app_package/api/NullStringToEmptyAdapterFactory.kt.ftl"
      			   to="${escapeXmlAttribute(srcOut)}/api/NullStringToEmptyAdapterFactory.kt" />

    <instantiate from="root/src/app_package/api/StringAdapter.kt.ftl"
      			   to="${escapeXmlAttribute(srcOut)}/api/StringAdapter.kt" />

    <instantiate from="root/src/app_package/base/BaseActivity.kt.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/base/BaseActivity.kt" />

    <instantiate from="root/src/app_package/base/BaseAdapterViewModel.kt.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/base/BaseAdapterViewModel.kt" />

    <instantiate from="root/src/app_package/base/BaseBottomFragment.kt.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/base/BaseBottomFragment.kt" />

    <instantiate from="root/src/app_package/base/BaseFragment.kt.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/base/BaseFragment.kt" /> 
       			   
    <instantiate from="root/src/app_package/base/BaseRepository.kt.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/base/BaseRepository.kt" /> 
    
    <instantiate from="root/src/app_package/base/BaseViewModel.kt.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/base/BaseViewModel.kt" /> 
       			   
    <instantiate from="root/src/app_package/base/adapter/BaseAdapterItem.kt.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/base/adapter/BaseAdapterItem.kt" /> 
       			   
    <instantiate from="root/src/app_package/base/adapter/BaseMultiTypeRecyclerAdapter.kt.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/base/adapter/BaseMultiTypeRecyclerAdapter.kt" /> 
      
    <instantiate from="root/src/app_package/base/adapter/BaseRecyclerAdapter.kt.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/base/adapter/BaseRecyclerAdapter.kt" /> 
       
    <instantiate from="root/src/app_package/base/adapter/RecyclerViewHolder.kt.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/base/adapter/RecyclerViewHolder.kt" /> 
    
    <instantiate from="root/src/app_package/di/component/AppComponent.kt.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/di/component/AppComponent.kt" /> 

    <instantiate from="root/src/app_package/di/module/AppModule.kt.ftl"
               	   to="${escapeXmlAttribute(srcOut)}/di/module/AppModule.kt" /> 

    <instantiate from="root/src/app_package/di/module/BuilderModule.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/di/module/BuilderModule.kt" /> 

    <instantiate from="root/src/app_package/di/module/NetworkModule.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/di/module/NetworkModule.kt" /> 

    <instantiate from="root/src/app_package/di/module/ViewModelModule.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/di/module/ViewModelModule.kt" /> 

    <instantiate from="root/src/app_package/di/scope/PerActivity.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/di/scope/PerActivity.kt" /> 

    <instantiate from="root/src/app_package/di/DaggerViewModelFactory.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/di/DaggerViewModelFactory.kt" /> 
                   
    <instantiate from="root/src/app_package/di/ViewModelKey.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/di/ViewModelKey.kt" /> 
                   
    <instantiate from="root/src/app_package/extension/AnimationEx.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/extension/AnimationEx.kt" /> 
                                      
    <instantiate from="root/src/app_package/extension/ContextEx.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/extension/ContextEx.kt" /> 
                  
    <instantiate from="root/src/app_package/extension/EdittextEx.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/extension/EditextEx.kt" />

    <instantiate from="root/src/app_package/extension/ImageViewEx.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/extension/ImageViewEx.kt" />
                   
    <instantiate from="root/src/app_package/extension/RecyclerViewEx.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/extension/RecyclerViewEx.kt" />

    <instantiate from="root/src/app_package/extension/SchedulersEx.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/extension/SchedulersEx.kt" />

    <instantiate from="root/src/app_package/extension/SharePreferencesEx.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/extension/SharePreferencesEx.kt" />

    <instantiate from="root/src/app_package/model/Response.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/model/Response.kt" />

    <instantiate from="root/src/app_package/vo/NetworkBoundResource.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/vo/NetworkBoundResource.kt" />

    <instantiate from="root/src/app_package/vo/ViewModelTypeResolver.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/vo/ViewModelTypeResolver.kt" />
                   
	<instantiate from="root/src/app_package/SimpleActivity.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/ui/${slashedPackageName(moduleName)}/${activityClass}.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/ui/${slashedPackageName(moduleName)}/${activityClass}.kt" />

    <instantiate from="root/src/app_package/SimpleViewModel.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/ui/${slashedPackageName(moduleName)}/${viewModelClass}.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/ui/${slashedPackageName(moduleName)}/${viewModelClass}.kt" />

    <instantiate from="root/src/app_package/SimpleRepository.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/repository/${slashedPackageName(moduleName)}/${repositoryClass}.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/repository/${slashedPackageName(moduleName)}/${repositoryClass}.kt" />
    
    <instantiate from="root/src/versions.gradle.ftl"
     			   to="${topOut}/versions.gradle" />
    
    <merge from="root/build.gradle.ftl" to="${topOut}/build.gradle" />
	
	<merge from="root/src/build.gradle.ftl" to="${projectOut}/build.gradle" />
	
	<merge from="root/res/values/styles.xml.ftl" to="${escapeXmlAttribute(resOut)}/values/styles.xml" />

</recipe>
