<resources>


    <!--dialog fragment-->
    <style name="CustomBottomDialogFragment">
        <item name="android:layout_width">match_parent</item>
        <item name="android:layout_height">wrap_content</item>
        <item name="android:windowIsFloating">true</item>
        <item name="android:windowAnimationStyle">@style/CustomBottomDialogFragmentAnimation</item>
    </style>
    <style name="CustomBottomDialogFragmentAnimation" parent="@android:style/Animation.Dialog">
        <item name="android:windowEnterAnimation">@anim/anim_bottom_in</item>
        <item name="android:windowExitAnimation">@anim/anim_bottom_out</item>
    </style>

</resources>
