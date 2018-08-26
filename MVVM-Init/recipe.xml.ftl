<?xml version="1.0"?>
<recipe>
	<merge from="root/res/AndroidManifest.xml.ftl"
             to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />
             
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
    <instantiate from="root/res/layout/simple.xml.ftl"
                 	to="${escapeXmlAttribute(resOut)}/layout/${simpleLayoutName}.xml" />
</#if>

	<instantiate from="root/src/app_package/App.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${applicationClass}.java" />
                   
	<instantiate from="root/src/app_package/base/BaseActivity.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/base/BaseActivity.java" />

    <instantiate from="root/src/app_package/base/BaseAdapter.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/base/BaseAdapter.java" />

    <instantiate from="root/src/app_package/base/BaseFragment.java.ftl"
      			   to="${escapeXmlAttribute(srcOut)}/base/BaseFragment.java" />

    <instantiate from="root/src/app_package/base/BasePresenter.java.ftl"
      			   to="${escapeXmlAttribute(srcOut)}/base/BasePresenter.java" />

    <instantiate from="root/src/app_package/base/BaseView.java.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/base/BaseView.java" />

    <instantiate from="root/src/app_package/base/BindingViewHolder.java.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/base/BindingViewHolder.java" />

    <instantiate from="root/src/app_package/base/DataBindingActivity.java.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/base/DataBindingActivity.java" />

    <instantiate from="root/src/app_package/base/DataBindingFragment.java.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/base/DataBindingFragment.java" /> 
       			   
    <instantiate from="root/src/app_package/gson/NullStringToEmptyAdapterFactory.java.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/network/gson/NullStringToEmptyAdapterFactory.java" /> 
    
    <instantiate from="root/src/app_package/gson/StringAdapter.java.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/network/gson/StringAdapter.java" /> 
    
    <instantiate from="root/src/app_package/network/HttpService.java.ftl"
       			   to="${escapeXmlAttribute(srcOut)}/network/HttpService.java" /> 

    <instantiate from="root/src/app_package/network/BaseSubscriber.java.ftl"
               to="${escapeXmlAttribute(srcOut)}/network/BaseSubscriber.java" /> 

    <instantiate from="root/src/app_package/network/RxException.java.ftl"
               to="${escapeXmlAttribute(srcOut)}/network/RxException.java" /> 

    <instantiate from="root/src/app_package/utils/LogUtil.java.ftl"
               to="${escapeXmlAttribute(srcOut)}/utils/LogUtil.java" /> 

    <instantiate from="root/src/app_package/utils/SharedPreferencesUtil.java.ftl"
               to="${escapeXmlAttribute(srcOut)}/utils/SharedPreferencesUtil.java" /> 

	<instantiate from="root/src/app_package/SimpleActivity.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${slashedPackageName(moduleName)}/view/${activityClass}.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${slashedPackageName(moduleName)}/view/${activityClass}.java" />

    <instantiate from="root/src/app_package/SimpleContract.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${slashedPackageName(moduleName)}/contract/${contractClass}.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${slashedPackageName(moduleName)}/contract/${contractClass}.java" />

    <instantiate from="root/src/app_package/SimplePresenter.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${slashedPackageName(moduleName)}/presenter/${presenterClass}.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${slashedPackageName(moduleName)}/presenter/${presenterClass}.java" />
	
	<instantiate from="root/src/app_package/MVPReadMe.txt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/MVPReadMe.txt" />
				   
	<open file="${escapeXmlAttribute(srcOut)}/MVPReadMe.txt" />
	
	<merge from="root/src/build.gradle.ftl" to="${projectOut}/build.gradle" />
	
	<merge from="root/build_apt.gradle.ftl" to="${topOut}/build.gradle" />

</recipe>
